#include "cod.h"


char* readline(char parada){
    char* linha = NULL;
    char tmp;
    int count = 0;

    do
    {
        tmp = getchar();
        if (tmp == '\r') tmp = getchar(); // para ignorar o \r do windows
        if (count % BUFFER == 0) 
        {
            linha = realloc(linha, sizeof(char)*(count + BUFFER));
        }
        if (tmp != parada) 
        {
            linha[count++] = tmp; 
        }
    } while (tmp != parada || tmp == EOF);

    linha[count] = '\0'; 
    
    return linha;
}//le uma linha de input até parada e salva em uma variavel 

struct registro_st{
    int numeroUSP;
    char nomeCompleto[50],curso[50];
    float nota;
};

FILE* abrirArquivo(){
    FILE* arquivo = fopen("bin.data","w+b");
    return arquivo;
}

void fechar(FILE* file){
    fclose(file);
}

long tamanhoArquvo(FILE*file){
    fseek(file, 0, SEEK_END);
    long fileSize = ftell(file);
    return fileSize;
}

int quantidadeRegistro(FILE* file,long fileSize){
    fseek(file, 0, SEEK_SET);
    int vectorSize = fileSize/sizeof(REGISTRO);
    return vectorSize;
}

void escreverTexto(FILE* file){
    REGISTRO* reg= (REGISTRO*) malloc(sizeof(REGISTRO));
    char* nome;
    char* curso;
    char tmp;
    do{
        scanf("%d",&reg->numeroUSP);
        fwrite(&reg->numeroUSP,sizeof(reg->numeroUSP),1,file);
        nome = readline(',');
        nome = readline(',');
        fwrite(nome,sizeof(reg->nomeCompleto),1,file);
        curso = readline(',');
        fwrite(curso,sizeof(reg->curso),1,file);
        scanf("%e",&reg->nota);
        fwrite(&reg->nota,sizeof(reg->nota),1,file);
        tmp = getchar();
    }while(tmp != EOF);
}

void lerUltimo10Registros(int quantidadeRegistro, FILE* file){
    fseek(file, (quantidadeRegistro-10)*sizeof(REGISTRO), SEEK_SET);
    REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
    for (int i = 0; i < 10; i++){
        fread(&reg->numeroUSP, sizeof(reg->numeroUSP),1, file);
        printf("Numero USP: %d\n",reg->numeroUSP);
        fread(reg->nomeCompleto,sizeof(reg->nomeCompleto),1,file);
        printf("Nome: %s\n",reg->nomeCompleto);
        fread(reg->curso,sizeof(reg->curso),1,file);
        printf("Curso:%s\n",reg->curso);
        fread(&reg->nota,sizeof(reg->nota),1,file);
        printf("Nota:%.2f\n",reg->nota);
        if (i != 10-1){
            printf("\n");
        }
    }
    free(reg);
}
