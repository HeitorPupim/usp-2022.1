#ifndef EXIT_H
#define EXIT_H

#include <cabecalho.h>
#include <exit.h>

/*
Se o index->proxIndex for difernete de nulo, utiliza a função recursivamente.
Caso contrário, fecha o arquivo.
Depois, limpa memória alocada do index.
*/
void sair(FILE* file, INDEX* noCabeca);


#endif //EXIT_H