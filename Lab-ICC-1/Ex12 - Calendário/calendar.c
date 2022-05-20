#include <stdio.h>
#include <stdlib.h>


void printHeader(){
    printf("         Abril 2021         \n");
    printf(" Do  Se  Te  Qu  Qu  Se  Sa \n");
}

void printFistLineBreak(){
    printf("                ");
}

void printDay(int day){
    for (int dayCount = 1; dayCount <= 30; dayCount++){
        
        if (day == dayCount){
            printf("(%2d)", dayCount);
            if ((dayCount == 3) || (dayCount == 10) || (dayCount == 17) || (dayCount == 24) || (dayCount == 30)){
                printf("\n");
            }
        }else {
            printf(" %2d ", dayCount);
            if ((dayCount == 3) || (dayCount == 10) || (dayCount == 17) || (dayCount == 24) || (dayCount == 30)){
                printf("\n");
            }
        }
    }
}
int main (){

    int selectedDay;
    scanf("%d\n", &selectedDay);

    printHeader();
    printFistLineBreak();
    printDay(selectedDay);

    return EXIT_SUCCESS;
}