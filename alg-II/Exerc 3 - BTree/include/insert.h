#ifndef INSERT_T
#define INSERT_T
#include <cabecalho.h>

/*
    Abre o arquivo com fopen e retorna o arquivo no formato FILE *
*/
FILE* abrirArquivo();

/*
Cria o nó cabeça do INDEX (id = -1, byteOffset = -1, proxIndex =NULL)
e retorna um INDEX*
*/
INDEX* criarIndex();

/*
Adiciona um index, sse já existir, printa ("O Registro ja existe!"),
Se não existir, aloca espaço para um novo Index (se proxIndex  == NULL), insere os dados do registro no index,
Se o index->ProxIndex != NULL, faz a recursão da função até encontrar um proxIndex == NULL.
*/
//void addIndex(INDEX* index, REGISTRO* registro, long byteOffset);

PAGE* criarPage();

PAGE* abrirPage(FILE* indexFile, long byteOffset);

void addIndexPage(INDEX* index, PAGE* page);

void addIndex(INDEX* index, PAGE* page,FILE* indexFile)
/*
Aloca espaço para um novo REGISTRO.
Lê o input do usuário para os campos do registro, aloca e escreve no arquivo. Quando terminar de escrever no arquvio, adiciona um novo Index
*/
void insert(FILE* file, INDEX* index);

#endif //INSERT_H