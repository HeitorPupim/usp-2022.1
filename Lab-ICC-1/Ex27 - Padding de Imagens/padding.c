#include <stdio.h>
#include <stdlib.h>


int **createMatrix(int m, int n){
   int **matrix = (int **)malloc(m * sizeof(int *));
   for (int i = 0; i < m; i++) {
      matrix[i] = (int *)malloc(n * sizeof(int));
   }
   return matrix;
}

void getMatrixData(int **matrix, int m, int n){
   for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
         scanf("%d", &matrix[i][j]);
      }
   }
}

void printMatrix(int **matrix, int m, int n){
   for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
         printf("%d ", matrix[i][j]);
      }
      printf("\n");
   }
}

void freeMatrix(int **matrix, int a){
   for (int i = 0; i < a; i++) {
      free(matrix[i]);
   }
   free(matrix);
}

void getPaddedMatrix(int **matrix, int m, int n, int **paddedMatrix, int p){
   for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
         paddedMatrix[i][j] = 0;
      }
   }
   for (int i = 0; i < p; i++) {
      for (int j = 0; j < p; j++) {
         paddedMatrix[i][j] = 0;
      }
   }
   for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
         paddedMatrix[i + p][j + p] = matrix[i][j];
      }
   }
}

int main(){

   int m, n;
   scanf("%d %d", &n, &m);
   int **matrix = createMatrix(m, n);
   getMatrixData(matrix, m, n);
   
   int nPadding;
   scanf("%d", &nPadding);
   int **paddedMatrix = createMatrix(m +  2*nPadding, n + 2*nPadding);
   
   getPaddedMatrix(matrix, m, n, paddedMatrix, nPadding);
   
   printMatrix(paddedMatrix, m + 2*nPadding, n + 2*nPadding);
   printf("\n");
   printMatrix(matrix, m, n);
   
   
   
   freeMatrix(matrix, m);
   freeMatrix(paddedMatrix, m + 2*nPadding);

   return EXIT_SUCCESS;
}