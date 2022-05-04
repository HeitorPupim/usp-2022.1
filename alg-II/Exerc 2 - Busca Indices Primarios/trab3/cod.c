#include "cod.h"

struct index_st{
    int id;//id é igual a nUSP
    long byteOffset;
    struct index_st* proxIndex;
};

struct registro_st{
    int nUSP;
    char* nome;
    char* sobrenome;
    char* curso;
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
    
    if(index->proxIndex == NULL){
        INDEX* newIndex = (INDEX*)malloc(sizeof(INDEX));
        newIndex->id = registro->nUSP;
        newIndex->byteOffset=byteOffset;
        newIndex->proxIndex=NULL;
    }else{
        if(index->id == registro->nUSP) printf("O Registro ja existe!\n");
        index = index->proxIndex;
        addIndex(index, registro, byteOffset);
    }
}

char* readline(char parada){
    char* linha = NULL;
    char tmp;
    int count = 0;

    do
    {
        tmp = getchar();
        if (tmp == '\r') tmp = getchar(); // para ignorar o \r do windows
        if (count % BUFFER == 0) 
        {
            linha = realloc(linha, sizeof(char)*(count + BUFFER));
        }
        if (tmp != parada) 
        {
            linha[count++] = tmp; 
        }
    } while (tmp != parada || tmp == EOF);

    linha[count] = '\0'; 
    
    return linha;
}//le uma linha de input até parada e salva em uma variavel 

long insert(FILE* file, INDEX* index){//precisa arruma

    REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
    fseek(file,0, SEEK_END);
    long byteOffset = ftell(file);
    scanf("%d",&reg->nUSP);
    printf("nUSP: %i\n",reg->nUSP);
    fwrite(&reg->nUSP,sizeof(reg->nUSP),1,file);
    char* pula = readline(',');//o primeiro caracter que readline vai encontra é ','.a função dessa linha é avançar o ',' apos o numUSP 
    free(pula);
    reg->nome = readline(',');
    printf("nome: %s\n",reg->nome);
    fwrite(reg->nome,sizeof(reg->nome),1,file);
    reg->sobrenome = readline(',');
    printf("sobrenome: %s\n",reg->sobrenome);
    fwrite(reg->sobrenome,sizeof(reg->nome),1,file);
    reg->curso = readline(',');
    printf("curso: %s\n",reg->curso);
    fwrite(reg->curso,sizeof(reg->curso),1,file);
    scanf("%e",&reg->nota);
    printf("nota: %.2f\n",reg->nota);
    fwrite(&reg->nota,sizeof(reg->nota),1,file);
    printf("----------------------------------\n");
    addIndex(index, reg, byteOffset);
    free(reg);
    return byteOffset; 
}

void lerRegistros(FILE* file,long byteOffset){
    REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
    char* nome;
    fseek(file,byteOffset, SEEK_SET);printf("-------------------------------\n");
    fread(&reg->nUSP, sizeof(reg->nUSP),1, file);
    printf("nUSP: %d\n",reg->nUSP);
    fread(nome,sizeof(nome),1,file);
    printf("nome: %s\n",nome);
    fread(reg->sobrenome,sizeof(reg->sobrenome),1,file);
    printf("Sobrenome: %s\n",reg->sobrenome);
    fread(reg->curso,sizeof(reg->curso),1,file);
    printf("Curso: %s\n",reg->curso);
    fread(&reg->nota,sizeof(reg->nota),1,file);
    printf("Nota: %.2f\n",reg->nota);
    printf("-------------------------------\n");
    free(nome);
    free(reg);

}

void search(int id, INDEX* noCabeca){
    INDEX* index= (INDEX*)malloc(sizeof(INDEX));
    index = noCabeca->proxIndex;
    do{
        if(index->nUSP == id){
            long byteOffset = index->byteOffset;
            return byteOffset;
        }else{
            if(index->proxIndex ==NULL){
                printf("Registro nao encontrado!\n");
            }else{
                index= index->proxIndex;
            }
        }

    }
}


void fechar(FILE* file){
    fclose(file);
}