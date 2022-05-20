#include <stdio.h>
#include <stdlib.h>


int main(){

    char tmp;
    char tmpB4 = '.';
    int words = 1, lines = 0 , characters = 0 ; //se der errado, colocar inicio em 1
    do{
        tmpB4 = tmp; //verifica char anterior.
        tmp = getchar();

        //count lines.
        if ((tmp == '\n') || (tmp == '\r')){
            lines++;
            if ((tmp == '\n')&& (tmpB4 == '\r')) //check \r\n
                lines--;
        }
        //count words.
        if ((tmp == ' ') || (tmp == '\n') || (tmp == '\t' )|| (tmp == '\r')){
            //words++ only if the char before is different than space, tabs, linebreaks,etc.
            if ((tmpB4 != '\r') && (tmpB4 != '\n') && ( tmpB4 != '\t') && (tmpB4 != ' '))
                words++;   
        }
        characters++;
    } while (tmp != EOF);
    
    // if the last characacter is not a linebreak or space, it counts as a word.
    if ((tmpB4 != '\n') && (tmpB4 != '\r') && (tmpB4 != '\t') && (tmpB4 != ' ')) 
        words++;
            
    //fix 'do while' EOF case.
    characters--;
    words--;

    printf("Linhas\tPalav.\tCarac.\n");
    printf("%d\t%d\t%d", lines, words, characters);    




    return EXIT_SUCCESS;
}