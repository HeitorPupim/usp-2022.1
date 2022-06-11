#include <util.h>
#include <cabecalho.h>


char* readline(char parada){
    char* linha=(char*)malloc(25) ;
    char tmp;
    int count = 0;

    do
    {
        tmp = getchar();
        if (tmp == '\r') tmp = getchar(); // para ignorar o \r do windows
        if (tmp != parada) 
        {
            linha[count++] = tmp; 
        }
    } while (tmp != parada || tmp == EOF);

    linha[count] = '\0'; 
    
    return linha;
}//le uma linha de input até parada e salva em uma variavel 

