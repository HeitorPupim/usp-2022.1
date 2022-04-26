#include "cod.h"

int main (){

    FILE* file = abrirArquivo();
    escreverTexto(file);
    long toamanhoArq = tamanhoArquvo(file);
    int quantidedesReg = quantidadeRegistro(file,toamanhoArq);
    lerUltimo10Registros(quantidedesReg, file);
    fechar(file);
    return 0;
}