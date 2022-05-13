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

FILE* abrirArquivo();
void insert(FILE* file, INDEX* index);
void lerRegistros(FILE* file,long byteOffset);
INDEX* criarIndex();
void addIndex(INDEX* index, REGISTRO* registro, long byteOffset);
long search(int id, INDEX* noCabeca);
void apagaRegistro(int id ,INDEX* noCabeca);
void deletarRegistro(FILE* file, int id, INDEX* noCabeca);
void sair(FILE* file, INDEX* noCabeca);

#endif //CABECALHO_H