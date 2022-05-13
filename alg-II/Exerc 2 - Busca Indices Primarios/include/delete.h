#ifndef DELETE_H
#define DELETE_H

#include <cabecalho.h>


void deletarRegistro(FILE* file, int id, INDEX* noCabeca);
void deleteIndex(int id ,INDEX* noCabeca);
long deleteSearch(int id, INDEX* noCabeca);



#endif //DELETE_H