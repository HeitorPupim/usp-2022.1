#include "trab.h"

struct aluno_{
    int nUSP;
    char nomeCompleto[50], curso[50];
    float nota;
};

FILE* abrir(char* arquivo){
    FILE* file = fopen(arquivo, "rb");
    return file;
}

long tamanhoArquvo(FILE*file){
    fseek(file, 0, SEEK_END);
    long fileSize = ftell(file);
    return fileSize;
}

int quantidadeRegistro(FILE* file,long fileSize){
    fseek(file, 0, SEEK_SET);
    int vectorSize = fileSize/sizeof(ALUNO);
    return vectorSize;
}

ALUNO* criarAluno(int vectorSize){
    ALUNO * vetor = (ALUNO*) malloc(vectorSize*sizeof(ALUNO));
    return vetor;
}

void lerTudo(ALUNO *aluno, int vectorSize, FILE *file){
    fread(aluno, sizeof(ALUNO), vectorSize, file);
    for (int i = 0; i < vectorSize; i++){
        printf("nUSP: %d\nNome: %s\nCurso: %s\nNota: %.2f\n", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
        if (i != vectorSize-1){
            printf("\n");
        }
    }
}

void lerPrimeiraMetade(ALUNO *aluno, int vectorSize, FILE *file){
    fread(aluno, sizeof(ALUNO), vectorSize/2, file);
    for (int i = 0; i < vectorSize/2; i++){
        printf("nUSP: %d\nNome: %s\nCurso: %s\nNota: %.2f\n", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
        if (i != (vectorSize/2)-1){
            printf("\n");
        }
    }
}

void lerSegundaMetade(ALUNO *aluno, int vectorSize, FILE *file){
    fread(aluno, sizeof(ALUNO), vectorSize/2, file);
    fread(aluno, sizeof(ALUNO), vectorSize/2, file);
    for (int i = 0; i < vectorSize/2; i++){
        printf("nUSP: %d\nNome: %s\nCurso: %s\nNota: %.2f\n", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
        if (i != (vectorSize/2)-1){
            printf("\n");
        }
    }
}

void lerIntervalos(ALUNO *aluno, FILE *file,int inicioIntervalo,int fimIntervalo){
    fread(aluno, sizeof(ALUNO), (inicioIntervalo -1), file);
    fread(aluno, sizeof(ALUNO), (fimIntervalo - inicioIntervalo)+1, file);
    for (int i = 0; i <(fimIntervalo - inicioIntervalo) +1 ; i++){
        printf("nUSP: %d\nNome: %s\nCurso: %s\nNota: %.2f\n", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
        if (i != (fimIntervalo - inicioIntervalo) ){
            printf("\n");
        }
    }
}

void lerEspecifico(ALUNO *aluno, FILE *file, int especifico){
    fread(aluno, sizeof(ALUNO), (especifico -1), file);
    fread(aluno, sizeof(ALUNO), 1, file);
    for (int i = 0; i <1 ; i++){
        printf("nUSP: %d\nNome: %s\nCurso: %s\nNota: %.2f\n", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
    }
}

void limparMemoria(ALUNO* vector){
        free(vector);
}

void fechar(FILE* file){
    fclose(file);
}
