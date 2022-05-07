#include <stdio.h>

int main (){

    int year;
    scanf("%d\n", &year);

    //se for bissexto, o resultado da divisao por 4 é zero, caso contrario não é, então: 
    (year % 4 == 0) ? printf("SIM\n"): printf("NAO\n");
    
    return 0;
}