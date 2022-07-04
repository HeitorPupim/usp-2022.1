#include <stdlib.h>
#include <stdio.h>
#include <string.h>


char *getForbiddenWord(){
   char *word = (char *)malloc(sizeof(char) * 100);
   scanf("%s\n", word);
   return word;

}


// ajusta a frase retirando as palavras indesejadas.
char* getFixedPhrase(char* forbiddenWord, int forbiddenWordSize){
   char *phrase = NULL;
   int letterCount = 0, nTimesAppeared = 0;
   char tmp;
   do
   {
      //le caractere e aloca na memória da frase.
      tmp = getchar();
      phrase = realloc(phrase, sizeof(char) * (letterCount + 1));
      phrase[letterCount++] = tmp;

      if( letterCount >= forbiddenWordSize){ //começa a verificar se a palavra proibida está na string.
         char * auxPointer = phrase + letterCount - forbiddenWordSize;
        

         if(strncmp(auxPointer, forbiddenWord, forbiddenWordSize) == 0){ //quando encontra, deleta a palavra da frase.
            letterCount -= forbiddenWordSize; //refaz o letterCount para não perder os caracteres da frase.
            phrase = realloc(phrase, sizeof(char) * letterCount);
            nTimesAppeared++;
         }
         
      }
   } while (tmp != EOF && tmp != '$');
   //printa o num. de vezes q apalavra aparece.
   printf("A palavra tabu foi encontrada %d vezes\n", nTimesAppeared);  

   phrase[letterCount-1] = '\0'; //Troca '$' por '\0' no final da frase.
   return phrase; 
}

int main(){

   char *forbiddenWord = getForbiddenWord();
   //printf("%s\n", forbiddenWord);
   int forbiddenWordSize = strlen(forbiddenWord); //pega o tamamnho da palavra proibida

   char *phrase = getFixedPhrase(forbiddenWord, forbiddenWordSize); 

   printf("Frase: %s", phrase);
   return EXIT_SUCCESS;
}