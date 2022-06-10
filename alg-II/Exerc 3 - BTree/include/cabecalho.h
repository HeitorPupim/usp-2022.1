#ifndef CABECALHO_H
#define CABECALHO_H

#include <stdio.h>
#include <stdlib.h>

#define BOOL int
#define true 1
#define false 0

#define PAGESIZE 4096
#define TREE_HEADER PAGESIZE
#define NUMAXINDEX 204
#define AUX_FIELDS_SIZE_ON_PAGE (2+1) /*number o f key s and ” i s l e a f ” bool */
#define FREE_SPACE_ON_PAGE (PAGESIZE - ( (MAXKEYS*4 )+(MAXKEYS*8 ) +(( MAXKEYS+1) *8 ) +3) )

#define BUFFER 16

typedef struct index_st{
    int id;//id = nUSP
    long byteOffset;
} INDEX;

typedef struct page_st {
    INDEX index[NUMAXINDEX] ;
    long filhos[NUMAXINDEX+1] ;
    short numberOfIndex ;
    BOOL ehFolha;
} PAGE ;

typedef struct indexOverflow_st {
 int id ;
 long byteOffset ;
 long filhos [2] ;
} INDEXOVERFLOW;

typedef struct registro_st{
    int nUSP;
    char nome[25];
    char sobrenome[25];
    char curso[25];
    float nota;
} REGISTRO;


void apagaRegistro(int id ,INDEX* noCabeca);


#endif //CABECALHO_H