#include <stdlib.h>
#include <stdio.h>

#define NUM_ROWS 32
#define NUM_COLUMNS 64

//elements of the matrix:
#define SAND '#'
#define WATER '~'
#define CEMENT '@'
#define AIR ' '

//define matrix:
char matrix[NUM_ROWS][NUM_COLUMNS+1];
char newMatrix[NUM_ROWS][NUM_COLUMNS];


void createMatrix(){
   for (int i = 0; i < NUM_ROWS; i++) {
      for (int j = 0; j < NUM_COLUMNS+1; j++) {
         if (j == NUM_COLUMNS) {
               matrix[i][j] = '\0';
         } else {
               matrix[i][j] = AIR;
         }
      }
   }
}


void printMatrix(int count) {
   printf("frame: %d\n", count + 1);
   for (int i = 0; i < NUM_ROWS; i++) {
      printf("%s\n", matrix[i]);
   }
}


void switchPosition(int x1, int y1, int x2, int y2) {
   if (x2 < NUM_COLUMNS && x2 >= 0 && y2 < NUM_ROWS) {
      //switch pos. of elements in the matrix:
      char aux = newMatrix[y1][x1];
      newMatrix[y1][x1] = newMatrix[y2][x2];
      newMatrix[y2][x2] = aux;
   }
}

void applyPhysics(){
   //Create a copy of the matrix to get veririf. in physics comparting the next with the previous movement
   for (int i = 0; i < NUM_ROWS; i++){
      for (int j = 0; j < NUM_COLUMNS; j++){     
         newMatrix[i][j] = matrix[i][j];
      }
   }

   // Aplly physics based on current elements:
   for (int y = 0; y < NUM_ROWS; y++) {
      for (int x = 0; x < NUM_COLUMNS; x++) {
         
         if (matrix[y][x] == SAND){ 
               // if the elem is sand, check if the next post is air or water
               if (matrix[y+1][x] ==  WATER || matrix[y+1][x] == AIR){
                  //check upper element:
                  switchPosition(x, y, x, y+1);
               } else if (matrix[y+1][x-1] ==  WATER || matrix[y+1][x-1] == AIR){
                  //check left element
                  switchPosition(x, y, x-1, y+1);
               } else if (matrix[y+1][x+1] ==  WATER || matrix[y+1][x+1] == AIR){
                  //check right element
                  switchPosition(x, y, x+1, y+1);
               }
         } else if (matrix[y][x] ==   WATER) {
               // if elem. is water, check if the next post is air or cement.
               if (matrix[y+1][x] == AIR && y+1 < NUM_ROWS) {
                  ///check upper element:
                  switchPosition(x, y, x, y+1);
               } else if (matrix[y+1][x-1] == AIR && y+1 < NUM_ROWS && x-1 >= 0){
                  //check left element on y+1:
                  switchPosition(x, y, x-1, y+1);
               } else if (matrix[y+1][x+1] == AIR && y+1 < NUM_ROWS && x+1 < NUM_COLUMNS){
                  //check right element on y+1:
                  switchPosition(x, y, x+1, y+1);
               } else if (matrix[y][x-1] == AIR && x-1 >= 0){
                  //check left element:
                  switchPosition(x, y, x-1, y);
               } else if (matrix[y][x+1] == AIR && x+1 < NUM_COLUMNS){
                  //check right element:
                  switchPosition(x, y, x+1, y);
               }
         }
      }
   }
   for (int i = 0; i < NUM_ROWS; i++) {
      for (int j = 0; j < NUM_COLUMNS; j++) {
         // create new matrix with the new positions:
         matrix[i][j] = newMatrix[i][j];
      }
   }
}

int main() {
   int nFrames, frame; //frame = current frame. nFrames = number of frames to simulate.

   int x, y; //aux to get the position of the element.
   char currentParticle;

   //Create a matrix and put '\0' delim in the last cell.
   createMatrix();

   scanf("%d", &nFrames);

   int count = 0;

   while (count < nFrames) {
      int getCurrentFrame = scanf(" %d: %d %d %c", &frame, &x, &y, &currentParticle);

      
      if (getCurrentFrame == EOF) {
        // if gcf, break the loop
         frame = nFrames;
      }

      while (count < frame) {
         //in each iteration/ frame:
         printMatrix(count);
         applyPhysics();
         count++;
      }
      if (getCurrentFrame != EOF) {
         matrix[y][x] = currentParticle;
      }
      
   }
   return EXIT_SUCCESS;
}
