#include <stdio.h>
#include <stdlib.h>

#define PIXEL_SIZE 25  
#define COLORS 5 

int *getPixelArray() {
   int *pixelArray = malloc(sizeof(int)*PIXEL_SIZE);

   for (int i = 0; i < PIXEL_SIZE; i++){
      scanf("%d", &pixelArray[i]);
   }
   return pixelArray;
}

int *createHistogram(int *pixelArray){
   //Array of 5 elem that stores the color rep.
   int *colorCount = malloc(sizeof(int)*COLORS); 

   for (int i = 0; i < COLORS; i++){
      colorCount[i] = 0;
      printf("%d: |", i);
      for (int j = 0; j < PIXEL_SIZE; j++){
         if (pixelArray[j] == i){
            colorCount[i]++;
            printf("#");
         }
      }
      printf("\n");
   }
   return colorCount;
}

int getMaxRepColor(int *colorCount){

   int maxRep = 0;
   int maxRepIndex = 0;
   for (int i = 0; i < COLORS; i++){
      if (colorCount[i] >= maxRep){
         maxRep = colorCount[i];
         maxRepIndex = i;
      }
   }
   return maxRepIndex;
}

void getMaxRepIndex(int* pixelArray, int maxRepIndex){

   for (int i = 0; i < PIXEL_SIZE; i++){
      if (pixelArray[i] == maxRepIndex){
         printf("%d\n", i);
      }
   }
}

int main(){
   int *pixelArray = getPixelArray();
   int* colorCount = createHistogram(pixelArray);
   int maxRep = getMaxRepColor(colorCount);
   
   /*
   printf("cor que mais se repete: %d\n", maxRep);
   */
   
   getMaxRepIndex(pixelArray, maxRep);

   free(pixelArray);
   free(colorCount);
   return EXIT_SUCCESS;
}