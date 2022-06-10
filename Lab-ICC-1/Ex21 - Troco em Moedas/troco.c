#include <stdio.h>
#include <stdlib.h>

int getCents(){
   int cents;
   scanf("%d", &cents);
   return cents;
}

void getTroco(int *cents){
   int reais, centavos50, centavos25, centavos10, centavos5, centavo1;

   reais = *cents / 100;
   centavos50 = (*cents % 100) / 50;
   centavos25 = ((*cents % 100) % 50) / 25;
   centavos10 = (((*cents % 100) % 50) % 25) / 10;
   centavos5 = ((((*cents % 100) % 50) % 25) % 10) / 5;
   centavo1 = (((((*cents % 100) % 50) % 25) % 10) % 5) / 1;

   printf("O valor consiste em %d moedas de 1 real\nO valor consiste em %d moedas de 50 centavos\nO valor consiste em %d moedas de 25 centavos\nO valor consiste em %d moedas de 10 centavos\nO valor consiste em %d moedas de 5 centavos\nO valor consiste em %d moedas de 1 centavo\n",
   reais, centavos50, centavos25, centavos10, centavos5, centavo1);
}

int main(){

   int cents = getCents();

   getTroco(&cents);

   return EXIT_SUCCESS;
}