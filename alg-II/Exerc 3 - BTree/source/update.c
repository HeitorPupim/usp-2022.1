#include <update.h>
#include <cabecalho.h>
#include <insert.h>
#include <search.h>
#include <util.h>

INDEX * insertUpdate(FILE* file,int id){
    REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
    fseek(file,0, SEEK_END);
    long byteOffset = ftell(file);

    scanf("%d",&reg->nUSP);
    reg->nUSP = id;
    fwrite(&reg->nUSP,sizeof(reg->nUSP),1,file);
    
    //caractere ignorado pelo readline.
    char* ignore1 = readline('"');
    free(ignore1);

    char* nome = readline('"');
    fwrite(nome,sizeof(reg->nome),1,file);
    free(nome);

    char* ignore2 = readline('"');
    free(ignore2);

    char* sobrenome = readline('"');
    fwrite(sobrenome,sizeof(reg->sobrenome),1,file);
    free(sobrenome);

    char* ignore3 = readline('"');
    free(ignore3);

    char* curso = readline('"');
    fwrite(curso,sizeof(reg->curso),1,file);
    free(curso);

    char* ignore4 = readline(',');
    free(ignore4);

    scanf("%e",&reg->nota);
    fwrite(&reg->nota,sizeof(reg->nota),1,file);
    
    // *** reg->id (nao existe campo id em reg) reg = REGISTRO
    INDEX *index = criarIndex(reg->nUSP,byteOffset);
    free(reg);
    return index;
}

void update(int id, PAGE* pageCabeca, FILE* indexFile, FILE* file){
    for(int i=0;i<NUMAXINDEX;i++){
        if(pageCabeca->index[i].id == id){
            INDEX* index = insertUpdate(file,id);
            pageCabeca->index[i].byteOffset = index->byteOffset;
            free(index);
            break;
        }else if(pageCabeca->index[i].id > id){
            if (pageCabeca->filhos[i] != -1){
                PAGE *pageNew = abrirPage(indexFile, pageCabeca->filhos[i]);
                update(id,pageNew, indexFile, file);
                atualizarPage(indexFile, pageNew, pageCabeca->filhos[i]);
                free(pageNew);
                break;
            }
        } 
    }
}
/*
    Função de update dá pra reaproveitar a leitura da insert,
    pq quando faz update ele lê a mesma qtde de campos da inserção.

    -> ex: update 18:

        cria um novo tipo registro
        acessa o index 18

        remove 18->nome, 18-> sobrenome, etc.

        lê nome
        insere nome
        lê sobrenome
        insere sobrenome, etc.
    

*/