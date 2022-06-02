#ifndef SEARCH_H
#define SEARCH_H

#include <cabecalho.h>


/*
    Lê os registros colocados no arquivo e printa as informações contidas e printa com a formatação desejada pelo exercício.
*/
void lerRegistros(FILE* file,long byteOffset);

/*
    Realiza a busca pelo id inserido no parâmetro, caso existir retorna o byteOffset desse Index, caso contrário, retorna -1 e printa "Registro não encontrado!"
*/
//long search(int id, INDEX* noCabeca);
#endif //SEARCH_H