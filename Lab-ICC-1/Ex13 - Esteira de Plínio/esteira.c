#include <stdio.h>
#include <stdlib.h>

#define TRUE 1 
#define FALSE 0
#define ROWS 32
#define COLUMNS 65


void printArray(char array[ROWS][COLUMNS]){
    for (int i = 0; i < ROWS; i++){
        for (int j = 0; j < COLUMNS; j++){
            printf("%c", array[i][j]);
        }
    }    
}

/*  scan the entire array and retun the row and the column that appears the char '['*/
int* getConveyorBegin(char array[ROWS][COLUMNS]){
    
    int * conveyorBegin = malloc(sizeof(int)*2);

    for (int i = 0; i < ROWS; i++){
        for (int j = 0; j < COLUMNS; j++){
            scanf("%c", &array[i][j]);
            if (array[i][j] == '['){
                
                conveyorBegin[0] = i;
                conveyorBegin[1] = j;
            }
        }
    }
    return conveyorBegin;
}

/* Edit the array and return the errorCode.*/
int traverseConveyor(char array[ROWS][COLUMNS], int *conveyorBegin){
    int row = conveyorBegin[0], column = conveyorBegin[1] + 2; //control convey begin
    int errorCode = 2;
    char temp;  //temporary char.

    do {
        // read right:
        if (array[row][column] == '>') {
            // if detect '>', keep reading rightwards.
            array[row][column] = '.'; //replace the read char to '.'
            column += 2; //increase the column
            temp = '>';
        } else if (array[row][column] == '<') {
            // if detect '<', keep reading leftwards.
            array[row][column] = '.'; //replace the read char to '.'
            column -= 2; //decrease the column
            temp = '<';
        } 
        else if (array[row][column] == 'v') {
           // if detect 'v', keep reading downwards.
            array[row][column] = '.'; //replace the read char to '.'
            row++; // increase row
            temp = 'v';
        } 
        else if (array[row][column] == '^') {
            // if detect '^', keep reading upwards.
            array[row][column] = '.'; //replace the read char to '.'
            row--;//decrease row.
            temp = '^';
        } //special case -> char '#'
        else if (array[row][column] == '#') {
            //special char detected, so jump it.
            if (temp == '>') {
                column += 2;
            } else if (temp == '<') {
                column -= 2;
            } else if (temp == 'v') {
                row++;
            } else if (temp == '^') {
                row--;
            }
        } else if (array[row][column] == '.'){ //Loop.
            errorCode = 0;
            break; //dowhile
        } else if (array[row][column] == ' '){ //fail.
            errorCode = 1;
            break; //dowhile
        }
    }while(array[row][column] != ']'); 
    
    return errorCode;
}

int main(){

    char array[ROWS][COLUMNS];
    int* conveyorBegin; 
    conveyorBegin = getConveyorBegin(array); // vector to get the begin '[' of the reading array.
    int errorCode = traverseConveyor(array, conveyorBegin);


    switch (errorCode){
    case 2:
        printf("Ok.\n");
        break;
    case 1: 
        printf("Falha na esteira.\n");
        break;
    default:
        printf("Loop infinito.\n");
        break;
    }

    printArray(array);
    
    free(conveyorBegin);
    
    return EXIT_SUCCESS;
}