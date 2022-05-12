#include "cod.h"

struct index_st{
    int id;//id é igual a nUSP
    long byteOffset;
    struct index_st* proxIndex;
};

struct registro_st{
    int nUSP;
    char nome[25];
    char sobrenome[25];
    char curso[25];
    float nota;
};

FILE* abrirArquivo(){
    FILE* arquivo = fopen("bin.data","w+b");
    return arquivo;
}

INDEX* criarIndex(){//cria o nó cabeça do index
    INDEX* index = (INDEX*)malloc(sizeof(INDEX));
    index->id = -1;
    index->byteOffset = -1;
    index->proxIndex = NULL;
    return index;
}

void addIndex(INDEX* index, REGISTRO* registro, long byteOffset){
    
    if(index->id == registro->nUSP){
        printf("O Registro ja existe!\n");
    }else{
        if(index->proxIndex == NULL){
        INDEX* newIndex = (INDEX*)malloc(sizeof(INDEX));
        newIndex->id = registro->nUSP;
        newIndex->byteOffset=byteOffset;
        newIndex->proxIndex=NULL;
        index->proxIndex = newIndex;
        }
        else{
            index = index->proxIndex;
            addIndex(index, registro, byteOffset);
       }
    }
}

char* readline(char parada){
    char* linha=(char*)malloc(25) ;
    char tmp;
    int count = 0;

    do
    {
        tmp = getchar();
        if (tmp == '\r') tmp = getchar(); // para ignorar o \r do windows
        if (tmp != parada) 
        {
            linha[count++] = tmp; 
        }
    } while (tmp != parada || tmp == EOF);

    linha[count] = '\0'; 
    
    return linha;
}//le uma linha de input até parada e salva em uma variavel 

long insert(FILE* file, INDEX* no){//precisa arruma

    REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
    long byteOffset = ftell(file);

    fseek(file,0, SEEK_END);

    scanf("%d",&reg->nUSP);
    fwrite(&reg->nUSP,sizeof(reg->nUSP),1,file);
    
    char* pula = readline(',');//o primeiro caracter que readline vai encontra é ','.a função dessa linha é avançar o ',' apos o numUSP 
    free(pula);

    char* nome = readline(',');
    fwrite(nome,sizeof(reg->nome),1,file);
    free(nome);

    char* sobrenome = readline(',');
    fwrite(sobrenome,sizeof(reg->nome),1,file);
    free(sobrenome);

    char* curso = readline(',');
    fwrite(curso,sizeof(reg->curso),1,file);
    free(curso);

    scanf("%e",&reg->nota);
    fwrite(&reg->nota,sizeof(reg->nota),1,file);
    

    addIndex(no, reg, byteOffset);
    free(reg);

    return byteOffset; 
}

void lerRegistros(FILE* file,long byteOffset){
    if(byteOffset != -1){
        REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
        fseek(file,byteOffset, SEEK_SET);
        printf("-------------------------------\n");

        fread(&reg->nUSP, sizeof(reg->nUSP),1, file);
        printf("nUSP: %d\n",reg->nUSP);

        char nome[25];
        fread(&nome,sizeof(nome),1,file);
        printf("nome: %s\n",nome);


        fread(&reg->sobrenome,sizeof(reg->sobrenome),1,file);
        printf("Sobrenome: %s\n",reg->sobrenome);

        fread(&reg->curso,sizeof(reg->curso),1,file);
        printf("Curso: %s\n",reg->curso);

        fread(&reg->nota,sizeof(reg->nota),1,file);
        printf("Nota: %.2f\n",reg->nota);

        printf("-------------------------------\n");
        free(reg);
    }

}//ainsda tem q arrumar

long search(int id, INDEX* noCabeca){
    INDEX* index= (INDEX*)malloc(sizeof(INDEX));
    index = noCabeca->proxIndex;
    do{
        if(index->id == id){
            long byteOffset = index->byteOffset;
            return byteOffset;
        }else{
            if(index->proxIndex ==NULL){
                printf("Registro nao encontrado!\n");
                return -1;
            }else{
                index= index->proxIndex;
            }
        }

    }while(1==1);
}   

void apagaRegistro(int id ,INDEX* noCabeca){
    INDEX* index= noCabeca;
    INDEX* aux;
    if(index->proxIndex->id == id){
        aux= index->proxIndex;
        index->proxIndex = aux->proxIndex;
        free(aux);
    }else{ 
        index= index->proxIndex;
        apagaRegistro(id, index);
    }
}

void deletarRegistro(FILE* file, long byteOffset,int id, INDEX* noCabeca){
    if (byteOffset!=-1){
        fseek(file,byteOffset, SEEK_SET);
        fputs("|***",file);
        apagaRegistro(id,noCabeca);
    }
}

void sair(FILE* file, INDEX* noCabeca){
    INDEX* index = noCabeca;
    if(index->proxIndex != NULL){
        sair(file,index->proxIndex);
    }else fclose(file);
    free(index);

}
/*void fechar(FILE* file){
    fclose(file);
}*/