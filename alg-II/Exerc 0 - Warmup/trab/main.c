#include "trab.h"

int main(){    
    char* arquivo = "reg.dat";
    int operacao;
    operacao = 3;

    FILE* file = abrir(arquivo);

    long fileSize = tamanhoArquvo(file);
    int vectorSize = quantidadeRegistro(file,fileSize);
    ALUNO* vector = criarAluno(vectorSize);

    if(operacao == 1){
        lerTudo(vector, vectorSize, file);
    }else if(operacao == 2){
        lerPrimeiraMetade(vector,vectorSize,file);
    }else if(operacao ==3){
        lerSegubdaMetade(vector,vectorSize,file);
    }else if(operacao == 4){
        int inicioIntervalo, fimIntervalo;
        fimIntervalo= 30;
        inicioIntervalo=20;
        lerIntervalos(vector,vectorSize,file,inicioIntervalo,fimIntervalo);
    }else if(operacao == 5){
        int especifico;
        especifico = 97;
        lerEspecifico(vector,file,especifico);
    }else{
        printf("Operacao invalida");
    }

    limparMemoria(vector);

    fechar(file);

    return 0; 
}