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
void fechar(FILE* file);


#endif //cod_h