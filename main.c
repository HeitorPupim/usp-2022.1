/*
        Aula 218 e 219: Lendo em arquivo binário com a função fread()

        Código escrito por Wagner Gaspar
        Junho de 2021

        Modos de abertura de arquivos:
        wb -> Escrita
        rb -> leitura
        ab -> anexar
        rb+ -> leitura e escrita
        wb+ -> leitura e escrita (apaga o conteúdo caso o arquivo exista)
        ab+ -> leitura e escrita (adiciona ao final do arquivo)
*/
#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int nUSP;
    char nome[50], curso[50];
    float nota;
}Contato;


void ler(char arq[]){
    Contato c;
    FILE *file = fopen(arq, "rb");

    if(file){
        while(!feof(file)){
            if(fread(&c, sizeof(Contato), 1, file))
                printf("\nNUSP: %d\nNome: %s\n curso: %s\n Nota:%f", c.nUSP, c.nome, c.curso, c.nota);
        }
        fclose(file);
    }
    else
        printf("\nErro ao abrir arquivo!\n");
}

//associa e abre para leitura

FILE 








int main(){
    char arquivo[] = {"/home/heitor/workspace/usp-2022.1/in_out/reg.dat"};

    ler(arquivo);

    return 0;
}