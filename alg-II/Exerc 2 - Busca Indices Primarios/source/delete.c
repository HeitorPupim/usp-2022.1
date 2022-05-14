#include "cabecalho.h"
#include <delete.h>


long deleteSearch(int id, INDEX* noCabeca){
    //INDEX* index= (INDEX*)malloc(sizeof(INDEX));
    INDEX* index = noCabeca;
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

void deleteIndex(int id ,INDEX* noCabeca){
    INDEX* index= noCabeca;
    INDEX* aux;
    if(index->proxIndex->id == id){
        aux= index->proxIndex;
        index->proxIndex = aux->proxIndex;
        free(aux);
    }else{ 
        index= index->proxIndex;
        deleteIndex(id, index);
    }
}

void deletarRegistro(FILE* file, int id, INDEX* noCabeca){
    long byteOffset = deleteSearch(id, noCabeca);
    if (byteOffset!=-1){
        fseek(file,byteOffset, SEEK_SET);
        fputs("|***",file);
        deleteIndex(id,noCabeca);
    }
}