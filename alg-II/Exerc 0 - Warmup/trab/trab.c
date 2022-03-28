#include "trab.h"

struct aluno_{
    int nUSP;
    char nomeCompleto[50], curso[50];
    float nota;
};

//abre o arquivo binário.
FILE* abrir(char* arquivo){
    FILE* file = fopen(arquivo, "rb");
    return file;
}

//retorna o tamanho do arquivo em long int.
long tamanhoArquvo(FILE*file){
    fseek(file, 0, SEEK_END);
    long fileSize = ftell(file);
    return fileSize;
}

//retorna a quantidade de registros em int.
int quantidadeRegistro(FILE* file,long fileSize){
    fseek(file, 0, SEEK_SET);
    int vectorSize = fileSize/sizeof(ALUNO);
    return vectorSize;
}

//aloca na memória a struct aluno
ALUNO* criarAluno(int vectorSize){
    ALUNO * vetor = (ALUNO*) malloc(vectorSize*sizeof(ALUNO));
    return vetor;
}

//lê todas as entradas, aloca na memória e printa os dados de cada aluno
void lerTudo(ALUNO *aluno, int vectorSize, FILE *file){
    fread(aluno, sizeof(ALUNO), vectorSize, file);
    for (int i = 0; i < vectorSize; i++){
        printf("\nNUSP: %d\nNome: %s\nCurso:%s \nNota:%.2f", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
    }
    printf("\n");
}

//lê e aloca na memória primeira metade do vetor
void lerPrimeiraMetade(ALUNO *aluno, int vectorSize, FILE *file){
    fread(aluno, sizeof(ALUNO), vectorSize/2, file);
    for (int i = 0; i < vectorSize/2; i++){
        printf("\nNUSP: %d\nNome: %s\nCurso:%s \nNota:%.2f", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
    }
    printf("\n");
}

// lê e aloca na memória a segunda metade do vetor
void lerSegubdaMetade(ALUNO *aluno, int vectorSize, FILE *file){
    fread(aluno, sizeof(ALUNO), vectorSize/2, file);
    fread(aluno, sizeof(ALUNO), vectorSize/2, file);
    for (int i = 0; i < vectorSize/2; i++){
        printf("\nNUSP: %d\nNome: %s\nCurso:%s \nNota:%.2f", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
    }
    printf("\n");   
}

//lê e aloca na memória 
void lerIntervalos(ALUNO *aluno, int vectorSize, FILE *file,int inicioIntervalo,int fimIntervalo){
    fread(aluno, sizeof(ALUNO), (inicioIntervalo -1), file);
    fread(aluno, sizeof(ALUNO), (fimIntervalo - inicioIntervalo)+1, file);
    for (int i = 0; i <(fimIntervalo - inicioIntervalo) +1 ; i++){
        printf("\nNUSP: %d\nNome: %s\nCurso:%s \nNota:%.2f", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
    }
    printf("\n");
}

// lê e aloca na memória o intervalo específico
void lerEspecifico(ALUNO *aluno, FILE *file, int especifico){
    fread(aluno, sizeof(ALUNO), (especifico -1), file);
    fread(aluno, sizeof(ALUNO), 1, file);
    for (int i = 0; i <1 ; i++){
        printf("\nNUSP: %d\nNome: %s\nCurso:%s \nNota:%.2f", aluno[i].nUSP, aluno[i].nomeCompleto, aluno[i].curso, aluno[i].nota);
    }
    printf("\n");
}

void limparMemoria(ALUNO* vector){
        free(vector);
}

void fechar(FILE* file){
    fclose(file);
}
