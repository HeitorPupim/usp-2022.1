#include <stdio.h>
#include <stdlib.h>

#define TAM_ESTACAO 10

struct ESTACAO{
    int numEstacao;
    char* NomeEstacao;
};

void criarEstacao(struct ESTACAO* linhaMetro){
    for (int i = 0; i < TAM_ESTACAO; i++){
        switch (i){
        case 0:
            linhaMetro[i].NomeEstacao = "* Morumbi ";
            linhaMetro[i].numEstacao = i;
            break;
        case 1:
            linhaMetro[i].NomeEstacao = "* Butanta ";
            linhaMetro[i].numEstacao = i;
            break;
        case 2:
            linhaMetro[i].NomeEstacao = "* Pinheiros ";
            linhaMetro[i].numEstacao = i;
            break;
        case 3:
            linhaMetro[i].NomeEstacao = "* Faria Lima ";
            linhaMetro[i].numEstacao = i;
            break;
        case 4:
            linhaMetro[i].NomeEstacao = "* Fradique Coutinho ";
            linhaMetro[i].numEstacao = i;
            break;
        case 5:
            linhaMetro[i].NomeEstacao = "* Oscar Freire ";
            linhaMetro[i].numEstacao = i;
            break;
        case 6:
            linhaMetro[i].NomeEstacao = "* Paulista ";
            linhaMetro[i].numEstacao = i;
            break;
        case 7:
            linhaMetro[i].NomeEstacao = "* Higienopolis-Mackenzie ";
            linhaMetro[i].numEstacao = i;
            break;
        case 8:
            linhaMetro[i].NomeEstacao = "* Republica ";
            linhaMetro[i].numEstacao = i;
            break;
        case 9:
            linhaMetro[i].NomeEstacao = "* Luz ";
            linhaMetro[i].numEstacao = i;
            break;
        default:
            break;
        }
    }
}

void printaEstacao(int keyEstacaoDeEmbarque, struct ESTACAO* linhaMetro){
    if (keyEstacaoDeEmbarque <= 5){// embarca antes da oscar freire
        for (int i = keyEstacaoDeEmbarque; i <= 5; i++){
            printf("%s\n", linhaMetro[i].NomeEstacao);
            if(i != 5)    printf("|\n");
            
            
        }
    }
    else for (int i = keyEstacaoDeEmbarque; i <= 9 ; i++){
        printf("%s\n", linhaMetro[i].NomeEstacao);
        if(i != 9)     printf("|\n");
            
    }
}

void limpaEstacao(struct ESTACAO* linhaMetro){
    free(linhaMetro);
}

int main(){
    //armazenar a estaçao num vetor de ESTACAO:
    struct ESTACAO* linhaMetro = malloc(sizeof(struct ESTACAO)*TAM_ESTACAO);
    criarEstacao(linhaMetro);
    
    int estacaoEmbarque;
    scanf("%d\n", &estacaoEmbarque);
    printaEstacao(estacaoEmbarque, linhaMetro);

    
    limpaEstacao(linhaMetro);
    return EXIT_SUCCESS;
}