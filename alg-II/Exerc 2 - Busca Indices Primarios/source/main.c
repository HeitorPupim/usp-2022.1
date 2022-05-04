#include "cod.h"

int main(){

    FILE* file = abrirArquivo();
    char operacao[6];
    int i=0;
    INDEX* no =criarIndex();
    
    do{
    scanf("%s",operacao);
    printf("%s\n",operacao);
    if( operacao[0] == 105){// 105 = 'i' na tabela ascii
        long byteOffset = insert(file, no);

        lerRegistros(file,byteOffset);
    }
    i++;
    }while(i<5);

    return 0;
}