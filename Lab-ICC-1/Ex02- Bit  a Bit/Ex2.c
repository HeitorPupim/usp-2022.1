#include <stdio.h>
#include <stdlib.h>

#define WORD_SIZE 4
int main(){

    //lendo a entrada: 
    unsigned int number; 
    scanf("%d", &number);

    int word[WORD_SIZE];

    for (int i = 3; i >= 0; i--){
        word[i] = number & 255;
        number /= 256; // Faz nosso número perder as 8 casas da esquerda pra direita
    }
    //imprimindo a palavra desejada...
    for (int i = 0; i < 4; i++){
        printf("%c", word[i]);
        if (i == 3) printf("\n");   
    }

    return 0;
}