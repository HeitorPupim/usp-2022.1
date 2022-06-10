#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define EARTH_DAYS 365
typedef long long unsigned int llui;


llui getSeconds(){
   llui seconds;
   scanf("%llu", &seconds);
   return seconds;
}

char *getPlanetName(){
   char *planetName = malloc(sizeof(char)*10);

   scanf("%s", planetName);
   return planetName;
}

void printData(llui inputSeconds, char* planetName){
   printf("%llu\n", inputSeconds);
   printf("%s\n", planetName);
}


void getEquivalentTime(llui inputSeconds, char* planetName){

   llui days, hours, minutes, seconds;


   if (!(strcmp(planetName, "Venus"))){
      // 1 diaVenus = 3600*24 * 243;
      days = inputSeconds / (3600*24 * 243);
      hours = (inputSeconds % (3600*24 * 243)) / 3600;
      minutes = (inputSeconds % (3600*24 * 243)) % 3600 / 60;
      seconds = (inputSeconds % (3600*24 * 243)) % 3600 % 60;
      
   }else if (!(strcmp(planetName, "Mercurio"))){
      //1 diaMercurio = (3600*24 * 58) + (16*3600);
      days = inputSeconds / ((3600*24 * 58) + (16*3600));
      hours = (inputSeconds % ((3600*24 * 58) + (16*3600))) / 3600;
      minutes = (inputSeconds % ((3600*24 * 58) + (16*3600))) % 3600 / 60;
      seconds = (inputSeconds % ((3600*24 * 58) + (16*3600))) % 3600 % 60;

   }else if (!(strcmp(planetName, "Jupiter"))){
      // 1 diaJupiter = ((9*3600) + (56*60))
      days = inputSeconds / ((9*3600) + (56*60));
      hours = (inputSeconds % ((9*3600) + (56*60))) / 3600;
      minutes = (inputSeconds % ((9*3600) + (56*60))) % 3600 / 60;
      seconds = (inputSeconds % ((9*3600) + (56*60))) % 3600 % 60;
      
   }else{ //1 seg = 1 seg. -> Terra
      days = inputSeconds / (3600*24);
      hours = (inputSeconds % (3600*24)/3600);
      minutes = (inputSeconds % (3600*24)%3600)/60;
      seconds = (inputSeconds % (3600*24)%3600)%60;
   }

   printf("%llu segundos no planeta %s equivalem a:\n", inputSeconds, planetName);
   printf("%llu dias, %llu horas, %llu minutos e %llu segundos\n", days, hours, minutes, seconds);
}


int main(){
   
   llui seconds = getSeconds();
   char* planetName = getPlanetName();

   getEquivalentTime(seconds, planetName);

   free(planetName);

   return EXIT_SUCCESS;
}