#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(){

   char tmp = '-';   //inicializado com valor arbitrário.
   while (1)
   {
   
   //cria 2 novos nomes.
   char *nome1 = (char *) malloc(sizeof(char));
   char *lastName = (char *) malloc(sizeof(char));
   char *nome2 = (char *) malloc(sizeof(char));
   

   //controle do ultimo espaço do nome1, que marca o ultimo sobrenome.
   int lastSpace = 0;
   //controle da string do nome1
   int count = 0;
   
   //Registrando o primeiro nome:
   while(tmp != '$'){
      tmp = getchar();
      if(tmp == '$') break;
      nome1[count] = tmp; 
      count++;
      nome1 = realloc(nome1, sizeof(char) * (count + 2));

      //Verificando se é um espaço ou o final da string
      if (tmp == ' '){
         lastSpace = count;
      }   
      else if (tmp == '\n') { //Se for o final da string, vamos colocar um \0 no final
         nome1[count] = '\0';
         break;
      }
   }
   //Printando o primeiro nome:
   printf("%s", nome1);

   //verificador de final de arquivo:
   if (tmp == '$') {
      printf("\n"); 
      break;
   }
   //Registrnado o sobrenome. 
   for (int i = 0; i < (count - lastSpace); i++){
      lastName[i] = nome1[lastSpace + i];
      lastName = realloc(lastName, sizeof(char) * (i + 1));
   }

   //controle da string do nome2
   int count2 = 0;
   //Registrando o segundo nome:
   while(tmp != '$'){
      tmp = getchar();
      nome2[count2++] = tmp; 
      nome2 = realloc(nome2, sizeof(char) * (count2 + 2));
   
      //verifica se é o final do arquivo ou final do nome.
      if ((tmp == '\n') || (tmp == '$')) {
         nome2[count2-1] = ' ';
         for (int i = 0; i < (count - lastSpace); i++){
            nome2[count2 + i] = lastName[i];
            nome2 = realloc(nome2, sizeof(char) * (count2 + i + 10));
         }
         break;
      }
      
      
      if (tmp == ('$')) break;
   }
   
   //Printa o nome par:
   printf("%s", nome2);
   
   //Desaloca o epsaço para os nomes a cada interação
   free(nome1);
   free(lastName);
   free(nome2);
      
   //verifica se é final do arquivo novamente e finaliza o código
   if (tmp == ('$')) break;

   }
   return 0;

}