
#include <stdio.h>
#include <stdlib.h>
#include <cabecalho.h>
#include <search.h>
#include <util.h>
#include <insert.h>
#include <update.h>

int main(){

/*
    Pra registro - utilizar as funções no trab de indices primarios

    Arvore:

    consulta a chave primaria antes de inserir p/ n inserir duplicadas
    
    novas chaves -> insere -> nó folha 
        se superar limite de chaves -> balanceamento -> divisão/promoção do nó

    estrutura da arvore:
        Header: RRN raiz / Espaço livre
        Nós: Chave primaria/ RRN registro / Filho/ nChave/ flag éFolha/ espaço livre
        
    obs:

    1. Cada nó, quando carregado na memória, pode ser armazenado em uma TAD.
    2. utilizar 4096 bytes no arquivo

*/

    FILE* file = abrirArquivo();
    FILE* indexFile = abrirIndexFile();
    char operacao[6];
    int id;
    BOOL fim = false;
    PAGE* pageCabeca = criarPage();
    INDEX* index;
    INDEXOVERFLOW* aux; 

    do{
        scanf("%s",operacao);
        switch(operacao[0]){
            case('i'): //insert
                index = insert(file);
                aux = addIndex(index,pageCabeca,indexFile);
                if (aux != NULL){
                    pageCabeca = atualizarPageCabeca(aux);
                }

                break;
            case('s'): //search
                scanf("%d",&id);
                long byteOffset=search(id,pageCabeca, indexFile);
                lerRegistros(file, byteOffset);
                
                break;
            
            case('u'): //update
                scanf("%d",&id);
                update(id,pageCabeca, indexFile, file);

                break;
            case('e'): //exit
                free(pageCabeca);
                fclose(file);
                fclose(indexFile);
                fim = true; //sinalizador para o do while
                break;
        }  
        
    
    }while(fim == false);

    return EXIT_SUCCESS;
}