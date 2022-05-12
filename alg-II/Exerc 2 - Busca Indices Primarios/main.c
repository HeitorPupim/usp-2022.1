#include "cod.h"

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
                byteOffset = insert(file, no);
                break;
            case('s'):
                scanf("%d",&id);
                byteOffset=search(id,no); 
                lerRegistros(file,byteOffset);
                break;
            case('d'):
                scanf("%d",&id);
                byteOffset=search(id,no);
                deletarRegistro(file, byteOffset, id, no);
                break;
            case('e'):
                sair(file,no);
                fim = 1;
                break;

        }   
    }while(fim == 0);


    //fechar(file);
    return 0;
}