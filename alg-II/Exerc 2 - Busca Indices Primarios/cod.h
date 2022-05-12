#ifndef COD_H
#define COD_H

#include <stdio.h>
#include <stdlib.h>

#define BUFFER 16

typedef struct index_st INDEX;
typedef struct registro_st REGISTRO;

FILE* abrirArquivo();
long insert(FILE* file, INDEX* index);
void lerRegistros(FILE* file,long byteOffset);
INDEX* criarIndex();
void addIndex(INDEX* index, REGISTRO* registro, long byteOffset);
long search(int id, INDEX* noCabeca);
void apagaRegistro(int id ,INDEX* noCabeca);
void deletarRegistro(FILE* file, long byteOffset,int id, INDEX* noCabeca);
void sair(FILE* file, INDEX* noCabeca);

#endif //cod_h