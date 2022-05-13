#include "cabecalho.h"

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

void insert(FILE* file, INDEX* no){//precisa arruma

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

 
}