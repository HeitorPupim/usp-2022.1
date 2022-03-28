
#ifndef TRAB_H
#define TRAB_H
#include <stdio.h>
#include <stdlib.h>

typedef struct aluno_ ALUNO;

FILE* abrir(char* arquivo);
long tamanhoArquvo(FILE*file);
int quantidadeRegistro(FILE* file,long fileSize);
ALUNO* criarAluno(int vectorSize);
void lerTudo(ALUNO *aluno, int vectorSize, FILE *file);
void lerPrimeiraMetade(ALUNO *aluno, int vectorSize, FILE *file);
void lerSegubdaMetade(ALUNO *aluno, int vectorSize, FILE *file);
void lerIntervalos(ALUNO *aluno, int vectorSize, FILE *file,int inicioIntervalo,int fimIntervalo);
void lerEspecifico(ALUNO *aluno, FILE *file, int especifico);
void limparMemoria(ALUNO* vector);
void fechar(FILE* file);

#endif //TRAB_H