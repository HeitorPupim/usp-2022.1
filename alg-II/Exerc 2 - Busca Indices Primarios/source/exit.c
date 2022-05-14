#include "cabecalho.h"
#include <exit.h>

void sair(FILE* file, INDEX* noCabeca){
    INDEX* index = noCabeca;
    if(index->proxIndex != NULL){
        sair(file,index->proxIndex);
    }else fclose(file);
    free(index);
}