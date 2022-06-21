#include <stdio.h>
#include <stdlib.h>


void getElements(char **matrix, int nRows, int nColumns){
   for (int i = 0; i < nRows; i++){
      for (int j = 0; j <= nColumns; j++){
         scanf("%c", &matrix[i][j]);
      }
   }
}

void rotateLeft(char **matrix, int nRows, int nColumns, int rollLeft){
   char temp;
   for (int left = 0; left < rollLeft; left++){
      for (int i = 0; i <= nRows; i++){

      temp = matrix[i][0];

      for (int j = 0; j < nColumns; j++){

         matrix[i][j] = matrix[i][j+1] ;
      }
      matrix[i][nColumns-1] = temp;
      }
   }
}

void rotateDown(char **matrix, int nRows, int nColumns, int rollDown){
   char temp;
   for (int down = 0; down < rollDown; down++){
      for (int j = 0; j < nColumns; j++){

         temp = matrix[0][j];

         for (int i = 0; i < nRows; i++){
            matrix[i][j] = matrix[i+1][j];
         }
         matrix[nRows-1][j] = temp;
      }

   }
}

void printMatrix(char **matrix, int nRows, int nColumns){
   for (int i = 0; i < nRows; i++){
      for (int j = 0; j < nColumns; j++){
         printf("%c", matrix[i][j]);
      }
      printf("\n");
   }

}
int main(){

   int nRows, nColumns;
   int rollDown, rollLeft;
   scanf("%d %d", &nRows, &nColumns);
   getchar();
   
   //criando matriz.
   char **matrix = (char **)malloc(nRows * sizeof(char *));
   for (int i = 0; i < nColumns; i++){
      matrix[i] = (char *)malloc(nColumns * sizeof(char));
   }
   

   scanf("%d %d", &rollDown, &rollLeft);
   getchar();

   getElements(matrix,nRows,nColumns);


   
   rotateLeft(matrix, nRows, nColumns, rollLeft);

   rotateDown(matrix, nRows, nColumns, rollDown);

   

   printMatrix(matrix, nRows, nColumns);
  

   

   return EXIT_SUCCESS;
}