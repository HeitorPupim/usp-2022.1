#include <stdio.h>
#include <stdlib.h>

#define ROTOR_SIZE 26

//ignore word until its end
void ignoreWord(char wordEnd){
   char tmp;
   do
   {
      tmp = getchar();
   } while (tmp != wordEnd);
}

//
int *getRotor(){
   int* rotor = malloc(sizeof(int)*ROTOR_SIZE); //malloc rotor size

   for (size_t i = 0; i < ROTOR_SIZE; i++){
      scanf("%d", &rotor[i]);
   }

   return rotor;
}

// check the spinGear function.
void printRotor(int *rotor){
   for (int i = 0; i < ROTOR_SIZE; i++)
   {
      //printf("rotor[%d] = %d || ", i, rotor[i]);
      printf("%d || ", rotor[i]);
   }
   printf("\n");
}

//Turn the Rotor Gear in 1 position.
void spinGear(int *rotor){
   //temporary position -> store the first and add to the last index.
   int tmpIndex = rotor[0];

   for (int i = 0; i < ROTOR_SIZE; i++){
      if (i < 25){
         rotor[i] = rotor[i+1];
      }
      else rotor[25] = tmpIndex;
   }
}

int main(){
   //ignore "Rotores:"
   ignoreWord('\n');

   //scan Rotor values.
   int* rotor1 = getRotor();
   int* rotor2 = getRotor();
   int* rotor3 = getRotor();

   //skip linebreak "\n"
   getchar(); 
   getchar();
   // ignore "Mensagem: "
   ignoreWord('\n'); 

   
   int r1Index=0, r2Index=0;
   char charTMP; //temporary char.
   
   while (1){ //infinite loop till it gets EOF.
      charTMP = getchar();
         if (charTMP == EOF) break; //check EOF -> break while loop.

      if (r1Index == ROTOR_SIZE){
         spinGear(rotor2);
         r2Index++;
         r1Index = 0;
      }
      if (r2Index == ROTOR_SIZE){
         spinGear(rotor3);
         r2Index =0;
      }

      //decoding message: If charTMP is alpha., then -> get rotorIndex and print char -> spinGear() and add 1 to r1Index.
      //                   else: do not convert and print charTMP
      //filter UpperCase letters between A and Z in the ascii table:
      if ((charTMP >= 'A') && (charTMP <= 'Z')) {   
         printf("%c", rotor3[rotor2[rotor1[charTMP - 'A']]] + 'A'); 
         spinGear(rotor1); 
         r1Index++; 
      }else if (charTMP >= 'a' && charTMP <= 'z') { //filter LowerCase letters.
         printf("%c", rotor3[rotor2[rotor1[charTMP - 'a']]] + 'a'); 
         spinGear(rotor1); // Gira o rotor 1
         r1Index++; 
      }else printf("%c", charTMP);
   }

   //Free alocated memory in getRotor() function.
   free(rotor1);
   free(rotor2);
   free(rotor3);

   return EXIT_SUCCESS;
}