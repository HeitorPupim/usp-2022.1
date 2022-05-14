#ifndef CABECALHO_H
#define CABECALHO_H

#include <stdio.h>
#include <stdlib.h>



#define BUFFER 16

typedef struct index_st{
    int id;//id é igual a nUSP
    long byteOffset;
    struct index_st* proxIndex;
} INDEX;

typedef struct registro_st{
    int nUSP;
    char nome[25];
    char sobrenome[25];
    char curso[25];
    float nota;
} REGISTRO;


void apagaRegistro(int id ,INDEX* noCabeca);


#endif //CABECALHO_H