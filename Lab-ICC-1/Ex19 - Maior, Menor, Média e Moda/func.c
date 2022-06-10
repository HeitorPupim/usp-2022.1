#include <stdio.h>
#include <stdlib.h>

#define DATA_SIZE 10 // 10 entradas.

int  *getDataFromInput(){
   int *data = (int *)malloc(DATA_SIZE*sizeof(int));
   for (int i = 0; i < DATA_SIZE; i++){
      scanf("%d", &data[i]);
   }
   return data;
}

void getMax(int *data){
   int max = data[0];
   for (int i = 0; i < DATA_SIZE; i++){
      if (data[i] > max){
         max = data[i];
      }
   }
   printf("%d ", max);
}

void getMin(int *data){
   int min = data[0];
   for (int i = 0; i < DATA_SIZE; i++){
      if (data[i] < min){
         min = data[i];
      }
   }
   printf("%d ", min);
}

void getMean(int *data){
   double sum = 0;
   for (int i = 0; i < DATA_SIZE; i++){
      sum += data[i];
   }
   printf("%.2f ", (sum/DATA_SIZE));
}

void getMode(int *data){
   int indexMaxValue = 0;
   int maxCount = 0;
   for (int i = 0; i < DATA_SIZE; i++){
      int numCount = 0;
      for (int j = 0; j < DATA_SIZE; j++){
         if (data[i] == data[j]){
            numCount++;
         }
      }
      if (numCount > maxCount){
         maxCount = numCount;
         indexMaxValue = i;
      }
   }
   printf("%d\n", data[indexMaxValue]);
}

int main(){
   int *data = getDataFromInput();

   getMax(data);
   getMin(data);  
   getMean(data);
   getMode(data);

   free(data);
   return EXIT_SUCCESS;
}