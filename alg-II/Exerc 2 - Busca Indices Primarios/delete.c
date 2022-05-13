#include"cabecalho.h"

long deleteSearch(int id, INDEX* noCabeca){
    INDEX* index= (INDEX*)malloc(sizeof(INDEX));
    index = noCabeca;
    do{
        if(index->id == id){
            long byteOffset = index->byteOffset;
            return byteOffset;
        }else{
            if(index->proxIndex ==NULL){
                return -1;
            }else{
                index= index->proxIndex;
            }
        }

    }while(1==1);
} 

void apagaIndex(int id ,INDEX* noCabeca){
    INDEX* index= noCabeca;
    INDEX* aux;
    if(index->proxIndex->id == id){
        aux= index->proxIndex;
        index->proxIndex = aux->proxIndex;
        free(aux);
    }else{ 
        index= index->proxIndex;
        apagaIndex(id, index);
    }
}

void deletarRegistro(FILE* file, int id, INDEX* noCabeca){
    long byteOffset = deleteSearch(id, noCabeca);
    if (byteOffset!=-1){
        fseek(file,byteOffset, SEEK_SET);
        fputs("|***",file);
        apagaIndex(id,noCabeca);
    }
}