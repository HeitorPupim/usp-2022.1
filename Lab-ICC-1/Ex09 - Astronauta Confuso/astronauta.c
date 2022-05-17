#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0


void printMatrix(int n, int m, int astronautPosition){
    int k = 0, l = 0;
    int i;
    int count = 0;
    int exitLoop = FALSE;

    while(k < m && l < n){

        for(i = l; i < n; i++){
            //vai percorrer a primeira linha. -> m  = 0, n = de 0 .. *
            count++;
            if (count == astronautPosition){
                printf("O astronauta esta na posicao: %d %d \n", k, i);
                exitLoop = TRUE;
            }
        }
        k++;
        if (exitLoop == TRUE) break;
        
        //linha aumenta
        for(i = k; i < m; i++){
            // percorre ultima coluna -> m = 0.. * , n = ultima
            count++;
            if (count == astronautPosition){
                printf("O astronauta esta na posicao: %d %d \n", i, (n-1));
                exitLoop = TRUE;
            }
        }
        n--;
        if (exitLoop == TRUE) break;
        if(k < m){
            for( i = n - 1; i >= l; --i){
                //percorre na ordem reversa. linha fixa na ultima e coluna vai decrescendo
                // -> m = utlima, n = * .. 0 
                count++;
                if (count == astronautPosition){
                    printf("O astronauta esta na posicao: %d %d \n", (m-1), i);
                    exitLoop = TRUE;
                }
            }
        m--;
        if (exitLoop == TRUE) break;
        
        }
        if(l < n){
            for( i = m - 1; i >= k; i--){
                //percorre com coluna inicial, ordem reversa de linha.
                count++;
                if (count == astronautPosition){
                    printf("O astronauta esta na posicao: %d %d \n",i, l);
                    exitLoop = TRUE;
                }
            }
        l++;
        if (exitLoop == TRUE) break;
        
        }
        
    }
}

int main(){

    int matrixSize, astronautPosition;
    scanf("%d %d \n", &matrixSize, &astronautPosition);
    int n = matrixSize, m = matrixSize;
    
    //n = m ->  n*n -> qtde elem. da matriz
    matrixSize = matrixSize*matrixSize;
    
    if ((matrixSize - astronautPosition) > 0 ){
        printMatrix(m, n, astronautPosition);
        printf("Ainda faltam %d chamadas para a sua vez! \n", (matrixSize - astronautPosition));
        
    }
    else if ((matrixSize - astronautPosition) < 0 ){
        printf("O astronauta ja saiu em missao ha %d chamadas. \n",(astronautPosition - matrixSize));
        
    }
    else {
        printMatrix(m, n, astronautPosition);
        printf("Preste atencao, astronauta, chegou a sua vez! \n");
        
    }
    
    return EXIT_SUCCESS;
}