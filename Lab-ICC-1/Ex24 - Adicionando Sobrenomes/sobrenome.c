#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(){

   
   

   char tmp = '-';

   int test = 0;
   
   while (test < 2)
   {
      /* code */
   
   

   char *nome1 = (char *) malloc(sizeof(char));
   char *nome2 = (char *) malloc(sizeof(char));

   int lastSpace = 0;

   //pega primeiro nome
   int count = 0;
   while(1){
      tmp = getchar();
      nome1[count] = tmp; 
      count++;
      nome1 = realloc(nome1, sizeof(char) * (count + 2));
   
      if (tmp == ' '){
         lastSpace = count;
         printf("lastSpace: %d\n", lastSpace);
      }   
      if (tmp == '\n') {
         nome1[count] = '\0';
         break;
      }
   }
   printf("count: %d\n", count);
   printf("nome1: %s\n", nome1);
   
   //registra o lastName
   char *lastName = (char *) malloc(sizeof(char));
   printf("\n");
   for (int i = 0; i < (count - lastSpace); i++){
      lastName[i] = nome1[lastSpace + i];
      //printf("lastname: %s\n", lastName);
      lastName = realloc(lastName, sizeof(char) * (i + 1));
   }
   
   printf("lastName: %s\n", lastName);
   
   //pegando nome par.
   tmp = '0'; //arbitrary char
   int count2 = 0;
   while(1){
      tmp = getchar();

      nome2[count2] = tmp; 
      count2++;
      nome2 = realloc(nome2, sizeof(char) * (count2 + 2));
   
      if (tmp == '\n') {
         nome2[count2-1] = ' ';
         for (int i = 0; i < (count - lastSpace); i++){
            nome2[count2 + i] = lastName[i];
            nome2 = realloc(nome2, sizeof(char) * (count2 + i + 1));
         }
         
         break;
      }
      //tmp = getchar();

   }

   
   printf("nome2: %s\n", nome2);

   free(nome1);
   free(lastName);
   free(nome2);
   
   // alocar espaço para o nome q será lido:
   // salva o lugar em que teve o ultimo espaço ' ':
   // lê até o "\n" 
   // se ler o '$' da break no código.
   // lê o próximo nome, aloca espaço para ele e realoca com o espaço do outro nome q será inserido.

   // printa o nome da pessoa.
   test++;
   }
   return 0;

}