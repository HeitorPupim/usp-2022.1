#ifndef UPDATE_H
#define UPDATE_H
#include <cabecalho.h>

INDEX * insertUpdate(FILE* file,int id);
void update(int id, PAGE* pageCabeca, FILE* indexFile, FILE* file);






#endif //UPDATE_H