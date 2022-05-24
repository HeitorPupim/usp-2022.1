#include "cabecalho.h"
#include <insert.h>
#include <util.h>

FILE* abrirArquivo(){
    FILE* arquivo = fopen("bin.data","w+b");
    return arquivo;
}

INDEX* criarIndex(){
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

void insert(FILE* file, INDEX* no){
    REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
    long byteOffset = ftell(file);

    fseek(file,0, SEEK_END);

    scanf("%d",&reg->nUSP);
    fwrite(&reg->nUSP,sizeof(reg->nUSP),1,file);
    
    char* pula = readline(',');
    free(pula);

    char* nome = readline(',');
    fwrite(nome,sizeof(reg->nome),1,file);
    free(nome);

    char* sobrenome = readline(',');
    fwrite(sobrenome,sizeof(reg->sobrenome),1,file);
    free(sobrenome);

    char* curso = readline(',');
    fwrite(curso,sizeof(reg->curso),1,file);
    free(curso);

    scanf("%e",&reg->nota);
    fwrite(&reg->nota,sizeof(reg->nota),1,file);
    

    addIndex(no, reg, byteOffset);
    free(reg);

 
}