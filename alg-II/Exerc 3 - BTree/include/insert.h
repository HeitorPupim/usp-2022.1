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
INDEX* criarIndex(int id, long byteOffset);

/*
Adiciona um index, sse já existir, printa ("O Registro ja existe!"),
Se não existir, aloca espaço para um novo Index (se proxIndex  == NULL), insere os dados do registro no index,
Se o index->ProxIndex != NULL, faz a recursão da função até encontrar um proxIndex == NULL.
*/
//void addIndex(INDEX* index, REGISTRO* registro, long byteOffset);

PAGE* criarPage();

/*
    Aloca espaço para uma nova página, faz fseek no indexFile com o byteOffset do parâmetro,
    depois faz fread na página criada.
*/
PAGE* abrirPage(FILE* indexFile, long byteOffset);

/*
    Funçao void, passa como parâmetro o index e a página. 
    A finalidade é adicionar o index do parâmetro na página requisitada.
*/
void addIndexPage(INDEX* index, PAGE* page);

/*
    Funçao que adiciona um novo índice, fazendo recursão até encontrar a parte necessária 
    para inserção. A adição é feita pela addIndexPage()
*/
void addIndex(INDEX* index, PAGE* page,FILE* indexFile);

/*
Aloca espaço para um novo REGISTRO.
Lê o input do usuário para os campos do registro, aloca e escreve no arquivo. Quando terminar de escrever no arquvio, adiciona um novo Index
*/
long insert(FILE* file, INDEX* index);

#endif //INSERT_H