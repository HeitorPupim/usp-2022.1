#ifndef DELETE_H
#define DELETE_H

#include <cabecalho.h>

/*
Realiza uma busca pelo 'id' do primeiro parâmetro, iguala um Index ao noCabeca do parâmetro. A busca é realizada percorrendo o index noCabeca
Se encontrar o id, o byteOffset é igualado ao byteOffset do inde. Se percorrer a lista e não encontrar, retorna -1.
*/
long deleteSearch(int id, INDEX* noCabeca);

/*
    Faz uma busca pelo 'id' do parâmetro, se encontrar, deleta o index requisitado, mas não quebra a lógica da lista.
    A função é chamada recursivamente até encontrar o index desejado.
*/
void deleteIndex(int id ,INDEX* noCabeca);

/*
Deleta o registro do arquivo com key 'id' do arquivo, colocando um marcador do tipo '|***' no lugar do registro excluido.
*/
void deletarRegistro(FILE* file, int id, INDEX* noCabeca);

#endif //DELETE_H