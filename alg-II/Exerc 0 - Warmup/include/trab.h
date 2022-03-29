
#ifndef TRAB_H
#define TRAB_H
#include <stdio.h>
#include <stdlib.h>

typedef struct aluno_ ALUNO;

//Abre o arquivo binário
FILE* abrir(char* arquivo);
//Retorna o tamanho do arquivo em long int.
long tamanhoArquvo(FILE*file);
//Retorna a quantidade de registros do arquivo em iteiro.
int quantidadeRegistro(FILE* file,long fileSize);
//Aloca na memória a struct ALUNO com o parâmetro da quantidade de cadastros de alunos que será feito.
ALUNO* criarAluno(int vectorSize);
//Lê o arquivo e aloca no vetor com fread(), depois printa todos os registros.
void lerTudo(ALUNO *aluno, int vectorSize, FILE *file);
//Lê o arquivo e aloca no vetor com fread(), depois printa a primeira metade dos registros.
void lerPrimeiraMetade(ALUNO *aluno, int vectorSize, FILE *file);
//Lê o arquivo e aloca no vetor com fread(), depois printa a segunda metade dos registros.
void lerSegundaMetade(ALUNO *aluno, int vectorSize, FILE *file);
//Lê o arquivo e aloca no vetor com fread(), depois printa os registros do intervalo desejado.
void lerIntervalos(ALUNO *aluno, FILE *file,int inicioIntervalo,int fimIntervalo);
//Lê o arquivo e aloca no vetor com fread(), depois printa os registros especificados pelo usuário
void lerEspecifico(ALUNO *aluno, FILE *file, int especifico);
//Desaloca memória do programa.
void limparMemoria(ALUNO* vector);
//Fecha o arquivo.
void fechar(FILE* file);

#endif //TRAB_H