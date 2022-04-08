#include "trab.h"
#include <util.h>

int main(){    
    char* arquivo = readline('\n');
    int operacao,inicioIntervalo, fimIntervalo, especifico;

    scanf("%d", &operacao);

    FILE* file = abrir(arquivo);

    long fileSize = tamanhoArquvo(file);
    int vectorSize = quantidadeRegistro(file,fileSize);
    ALUNO* vector;

    switch (operacao){
    case 1: //Exibe todos os registros.
        vector = criarAluno(vectorSize);
        lerTudo(vector, vectorSize, file);
        break;
    case 2: //Exibe a primeira metade dos registros.
        vector = criarAluno(vectorSize/2);
        lerPrimeiraMetade(vector,vectorSize,file);
        break;
    case 3: //Exibe a segunda metade dos registros.
        vector = criarAluno(vectorSize/2);
        lerSegundaMetade(vector,vectorSize,file);
        break;
    case 4: //Lê intervalo e exibe os registros deste intervalo.
        scanf("%d", &inicioIntervalo);
        scanf("%d", &fimIntervalo);
        //para verificar se a entrade é maior que o tam. do vetor
        if (fimIntervalo >= vectorSize){
            fimIntervalo = vectorSize;
        }
        vector = criarAluno(fimIntervalo-inicioIntervalo+1);
        lerIntervalos(vector,file,inicioIntervalo,fimIntervalo);
        break;
    case 5: //Lê um número de registro e exibe o conteúdo deste.
        scanf("%d", &especifico);
        vector = criarAluno(1);
        lerEspecifico(vector, file, especifico);
        break;
    default:
        printf("Operação Inválida!");
        break;
    }
    free(arquivo);
    limparMemoria(vector);
    fechar(file);
    return 0; 
}