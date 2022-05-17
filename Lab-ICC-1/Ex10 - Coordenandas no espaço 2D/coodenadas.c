#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define STRING_SIZE 6

int main(){

    char* word = (char*)malloc(sizeof(char)*STRING_SIZE);

    int x = 0, y = 0; //initial coord.

    scanf("%s", word);

    for (int i = 0; i < STRING_SIZE; i++){
        if (word[i] == 'W'){ // W = 57
            y = y+1;
        }
        else if (word[i] == 'A'){ // A = 41
            x--;
        }
        else if (word[i] == 'S'){ // S = 53
            y--;
        }
        else if (word[i] == 'D'){// D = 44
            x++;
        } 
    }

    printf("%d %d", x , y);
    free(word);

    return EXIT_SUCCESS;
}