#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int wordCounter(FILE *file){
   int counter = 0;
   
   char ch = '.' ; 
   char tmp = '.';
   
   while((ch = fgetc(file)) != EOF){  
   //Counts each word  
      if((ch == ' ' || ch == '\n') && tmp != '\n' && tmp != ' '){
         counter++;
      }
      tmp = ch;  //Saves the last character read to compare double lines
   }
   if (tmp == '\n' || tmp == ' '){
      return counter;
   }
   counter++; //counts EOF
   return counter;
}

void showAnswer(int count1, int count2){
   printf("O candidato digitou %d de %d palavras (%d%%).\n", count2, count1, (count2*100)/count1);

   if (((count2*100)/count1) > 20){
      printf("Parabéns, candidato! Você foi aprovado!\n");
   }else printf("Lamentamos informar, mas você não cumpre os requisitos da vaga, candidato!\n");
}



int main(){

   FILE *file1;
   FILE *file2;

   int count1 = 0;
   int count2 = 0;
   /**/
   char nomeArquivo[100];
   char nomeArquivoLido[100];
   scanf("%s\n", nomeArquivo);
   scanf("%s\n", nomeArquivoLido);

   
   file1 = fopen(nomeArquivo, "r");
   file2 = fopen(nomeArquivoLido, "r");

   count1 = wordCounter(file1);
   count2 = wordCounter(file2);
  
   showAnswer(count1, count2);
   

   fclose(file1);
   fclose(file2);

   return EXIT_SUCCESS;
}