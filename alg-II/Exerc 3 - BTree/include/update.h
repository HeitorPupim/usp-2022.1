#ifndef UPDATE_H
#define UPDATE_H
#include <cabecalho.h>


/*
   Cria um registro de escrita para atualizar o arquivo. Faz a busca pelos campos necessários na leitura e atribui as atualiazções nos campos do registro
   Retorna o novo índice criado na atualização.
*/
INDEX * insertUpdate(FILE* file,int id);

/*
   Faz atualização na árvore, passando a key "id", o arquivo de escrita, arquivo de índices e a página incial.
   A função busca o campo para atualização dos parametros conforme a key.
*/
void update(int id, PAGE* pageCabeca, FILE* indexFile, FILE* file);


#endif //UPDATE_H