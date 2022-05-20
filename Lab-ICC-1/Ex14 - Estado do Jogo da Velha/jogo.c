#include <stdio.h>
#include <stdlib.h>

#define ROWS 3
#define COLUMNS 3

#define TRUE 1
#define FALSE 0

void readArray(char array[ROWS][COLUMNS]){
    
    for (int r = 0; r < ROWS; r++){
        for (int c = 0; c < COLUMNS; c++){
            char tmp; //temporary
            tmp = getchar(); 
            if ((tmp == '\n') || (tmp == ' ')) 
                    tmp = getchar();
            array[r][c] = tmp;
        }
    }
}

void printArray(char array[ROWS][COLUMNS]){
    for (int r = 0; r < ROWS; r++){
        for (int c = 0; c < COLUMNS; c++){
            printf("%c", array[r][c]);
        }
        printf("\n"); 
    }
}

char checkRows(char array[ROWS][COLUMNS]){
    char rowStauts = 'z';
    for (int r = 0; r < ROWS; r++){
        if ((array[r][0] == array[r][1]) && (array[r][0] == array[r][2])){
            rowStauts = array[r][0];
        }
    }
    return rowStauts;
}

char checkColumns(char array[ROWS][COLUMNS]){
    char columnsStatus = 'z';
    
    for (int c = 0; c < ROWS; c++){
        if ((array[0][c] == array[1][c]) && (array[0][c] == array[2][c])){
            columnsStatus = array[0][c];
        }
    }
    return columnsStatus;
}

char checkDiagonals(char array[ROWS][COLUMNS]){
    char diagonalStatus = 'z';

    if ((array[0][0] == array[1][1]) && (array[0][0] == array[2][2])){
        diagonalStatus = array[0][0];
    }else if ((array[0][2] == array[1][1]) && (array[0][2] == array[2][0]))
    {
        diagonalStatus = array[0][2];
    }
    return diagonalStatus;
}

int checkIngameStatus(char array[ROWS][COLUMNS]){
    int inGame = FALSE;
    for (int r = 0; r < ROWS; r++){
        for (int c = 0; c < COLUMNS; c++){
            if (array[r][c] == '-'){
                inGame = TRUE;
                break;
            }
        }
    }
    return inGame;
}

void printGameStatus(char array[ROWS][COLUMNS]){

    if ((checkRows(array) != 'z') && (checkRows(array) != '-')){
        printf("%c ganhou", checkRows(array));
    }else if ((checkColumns(array) != 'z') && (checkColumns(array) != '-')){
        printf("%c ganhou", checkColumns(array));
    }else if ((checkDiagonals(array) != 'z') && (checkDiagonals(array) != '-')){
            printf("%c ganhou", checkDiagonals(array));
    }else if(checkIngameStatus(array) == TRUE){
        printf("em jogo");
    }else printf("empate");
}




int main(){

    char array[ROWS][COLUMNS];
    
    readArray(array);
    //printArray(array);
    printGameStatus(array);

    return EXIT_SUCCESS;
}