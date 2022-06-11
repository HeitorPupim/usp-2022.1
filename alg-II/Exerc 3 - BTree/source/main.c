//a
#include <stdio.h>
#include <stdlib.h>
#include <cabecalho.h>
#include <search.h>
#include <util.h>
#include <insert.h>
#include <update.h>

int main(){

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
                free(index);
                free(aux);
                
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