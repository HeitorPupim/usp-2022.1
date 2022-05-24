#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE_LINE 100


int result(char forbiddenWords[][9], char characterCount[MAX_SIZE_LINE]){
    char tmp = '0'; // temporary char.

    int count = 0, //will be used to count the number of characters
    errorExit = 0; //spam or inbox

    while(tmp != EOF) { 
        //scan until the End Of File character.
        tmp = scanf("%[^\n] ", characterCount); // lê a characterCount toda até o \n
        for (int i = 0; i < 12; i++) { //traverse forbidden words vector
            if (strstr(characterCount, forbiddenWords[i]) != NULL) { 
                //returns pointer to the first occurrence of the matched string in the given string
                count++; //count the num. of forbidden words
            }
        }
        if (count >= 2 || strlen(characterCount) > 76) {
            //forbidden words >= 2 or charCount > 76 -> spam, else, inbox
            errorExit = 1; //spam code.
            break;
        }
    }
    return errorExit;
}

int main() {
    char forbiddenWords[][9] = 
    {"gratuito", "atencao", "urgente",
     "imediato", "zoombie", "oferta", 
     "dinheiro", "renda", "fundo", 
     "limitado", "ajuda", "SOS"};

    char characterCount[MAX_SIZE_LINE]; //line size.
    
    switch (result(forbiddenWords,characterCount)){
        case 0:
            printf("Inbox\n");
            break;

        case 1:
            printf("Spam\n");
            break;
        default:
            break;
    }

    return EXIT_SUCCESS;
}