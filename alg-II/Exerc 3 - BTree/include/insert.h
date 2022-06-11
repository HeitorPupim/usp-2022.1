#ifndef INSERT_T
#define INSERT_T
#include <cabecalho.h>

/*
    Abre o arquivo com fopen e retorna o arquivo no formato FILE *
*/
FILE* abrirArquivo();

/*
    Abre o arquivo de indice com fopen e retorna o arquivo no formato FILE *
*/
FILE* abrirIndexFile();

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
    "Escreve" uma página no arquivo de indices, faz ftell no byteOffset do arquivo,
    escreve os registros e retorna um long com o byteOffset da página.
*/
long escreverPage(FILE* indexFile, PAGE* page);

/*
    Para o caso de ter que atualizar página se o numero de indices ultrapassar o limite,
    escreve no arquivo espaço para nova página.
*/
void atualizarPage(FILE* indexFile, PAGE* page,long byteOffset);

/*
    Cria um índice para o caso de overflow. Ocupa os campos do índice com -1 e retorna este índice.
*/
INDEXOVERFLOW* criarIndexOverflow();

/*
    Atualiza a página "cabeça" com uma nova página em branco. Atribui os campos do índice de overflow para a nova página.
*/
PAGE* atualizarPageCabeca(INDEXOVERFLOW * index);

/*
    Funçao void, passa como parâmetro o index e a página. 
    A finalidade é adicionar o index do parâmetro na página requisitada.
*/
void addIndexPage(INDEX* index, PAGE* page);


INDEXOVERFLOW* splitPage(PAGE* page, INDEX* index, FILE* indexFile);

/*
    Cria uma nova página e um novo índice de overflow.
    Faz as verificações de índice e divide a página se necessário, para colocar novo elemento.
    Se não for o maior índice, adiciona o novo elemento entre os maiores. 
    Retorna o novo índice de overflow.
*/
INDEXOVERFLOW* addIndexOverPage(INDEXOVERFLOW* over, PAGE* page, FILE* indexFile);

/*
    Funçao que adiciona um novo índice, fazendo recursão até encontrar a parte necessária 
    para inserção. A adição é feita pela addIndexPage()
*/
INDEXOVERFLOW* addIndex(INDEX* index, PAGE* page,FILE* indexFile);

/*
Aloca espaço para um novo REGISTRO.
Lê o input do usuário para os campos do registro, aloca e escreve no arquivo. Quando terminar de escrever no arquvio, adiciona um novo Index
*/
INDEX * insert(FILE* file);

#endif //INSERT_H