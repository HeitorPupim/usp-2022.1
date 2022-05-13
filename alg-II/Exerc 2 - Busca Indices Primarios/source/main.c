#include <cabecalho.h>
#include <insert.h>
#include <util.h>
#include <search.h>
#include <delete.h>
#include <exit.h>

int main(){

    FILE* file = abrirArquivo();
    char operacao[6];
    int id;
    long byteOffset;
    int fim=0;

    INDEX* no =criarIndex();

    do{
        scanf("%s",operacao);
        switch(operacao[0]){
            case('i'):
                insert(file, no);
                break;
            case('s'):
                scanf("%d",&id);
                byteOffset=search(id,no); 
                lerRegistros(file,byteOffset);
                break;
            case('d'):
                scanf("%d",&id);
                deletarRegistro(file, id, no);
                break;
            case('e'):
                sair(file,no);
                fim = 1;
                break;
        }   
    }while(fim == 0);


    return EXIT_SUCCESS;
}