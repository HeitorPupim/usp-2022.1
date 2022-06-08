#ifndef UTIL_H
#define UTIL_H

#include <cabecalho.h>

/*
Lê uma linha até que seja encontrado um caractere de parada, ex: '\n'
Aloca na memória dinâmicamente. Necessário dar free após o uso.
*/
char* readline(char parada);


#endif //UTIL_H
