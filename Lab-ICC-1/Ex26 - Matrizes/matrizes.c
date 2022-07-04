#include <stdio.h>
#include <stdlib.h>


int **createMatrix(int m, int n){

   //Aloca espaço para as linhas da matriz.
   int **matrix = (int**)malloc(sizeof(int**)*m);

   for (int i = 0; i < m; i++){ //para cada linha.
      // para cada linha, aloca o tamanho das colunas da matriz.
      matrix[i] = (int*)malloc(sizeof(int)*n);
      for (int j = 0; j < n; j++){
         //Insere os elementos.
         scanf("%d", &matrix[i][j]);
      }
   }

   return matrix;
}

void freeMatrix(int **matrix, int a){
   for (int i = 0; i < a; i++){
      free(matrix[i]);
   }
   free(matrix);
}

int **transpMatrix(int **matrix,int m, int n){

   int **transp = (int**)malloc(sizeof(int**)*n);
   for (int i = 0; i < n; i++){
      transp[i] = (int*)malloc(sizeof(int)*m);
   }
   for (int i = 0; i < m; i++){
      for (int j = 0; j < n; j++){
         transp[j][i] = matrix[i][j];
      }
   }
   return transp;
}

void printMatrix(int **matrix, int m, int n){
   for (int i = 0; i < m; i++){
      for (int j = 0; j < n; j++){
         printf(" %d", matrix[i][j]);
      }
      //printf("\n");
   }
}

void multiplyMatrix(int **matrix1, int **matrix2, int m, int n){
   int **mult = (int**)malloc(sizeof(int**)*m);
   for (int i = 0; i < m; i++){
      mult[i] = (int*)malloc(sizeof(int)*m);
   }

   for (int i = 0; i < m; i++){
      for (int j = 0; j < m; j++){
         mult[i][j] = 0;
         for (int k = 0; k < n; k++){
            mult[i][j] += matrix1[i][k] * matrix2[k][j];
         }
      }
   }
   printf("%d %d", m, m);
   printMatrix(mult, m, m);
   freeMatrix(mult, m);
}



int main(){

   int m, n; //DIMENSÕES DA MATRIZ.
   scanf("%d %d", &m, &n);

   int **matrix = createMatrix(m, n);
   //printMatrix(matrix, m, n);
   int ** matrixT = transpMatrix(matrix, m, n);
   //printMatrix(matrixT, n, m);

   multiplyMatrix(matrix, matrixT, m, n);
   freeMatrix(matrix, m);
   freeMatrix(matrixT, n);
   





   return EXIT_SUCCESS;
}