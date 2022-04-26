#ifndef COD_H
#define COD_H

#include<stdio.h>
#include<stdlib.h>

#define BUFFER 16

typedef struct registro_st REGISTRO;

FILE* abrirArquivo();//cria um arquivo chamado bin.data que pode ser escrito e lido
void fechar(FILE* file);// fecha um arquivo
long tamanhoArquvo(FILE*file);//recebe um arquivo como parametro e retorna seu tamanho
int quantidadeRegistro(FILE* file,long fileSize);//retorna a quantidade de REGISTRO tem em um arquivo
void escreverTexto(FILE* file);//escreve os REGISTRO no arquivo bin.data
void lerUltimo10Registros(int quantidadeRegistro, FILE* file);//le os ultimos 10 REGISTRO do arquivo bin.data

#endif //cod_h