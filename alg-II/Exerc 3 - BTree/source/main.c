#include <stdio.h>
#include <stdlib.h>
#include <cabecalho.h>
#include <search.h>
#include <util.h>
#include <insert.h>




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
    2. 
    utilizar 4096 bytes no arquivo
*/
    FILE* file = abrirArquivo();
    char operacao[6]; 
    int id;
    long byteOffset;
    int fim=0;

    INDEX* no =criarIndex();

    do{
        scanf("%s",operacao);
        switch(operacao[0]){
            case('i'): //insert
                insert(file, no);
                break;
            case('s'): //search
                scanf("%d",&id);
                byteOffset=search(id,no); 
                lerRegistros(file,byteOffset);
                break;
            case('d'): //delete
                scanf("%d",&id);
                deletarRegistro(file, id, no);
                break;
            case('u'): //update
    	        //qnd implementar a função de update, colocar as funçoes aqui.
                break;
            case('e'): //exit
                sair(file,no);
                fim = 1; //sinalizador para o do while
                break;
        }   
    }while(fim == 0);

    return EXIT_SUCCESS;
}