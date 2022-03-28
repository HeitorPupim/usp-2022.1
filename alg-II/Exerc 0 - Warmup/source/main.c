#include <lista.h>
#include <util.h>
#include <string.h>

typedef struct{
    int nUSP;
    char nomeCompleto[50], curso[50];
    float nota;
}Contato;

// lê e armazena no vetor os dados do arquivo.
void lerArquivo(Contato *vector, int vectorSize, FILE *file){
    fread(vector, sizeof(Contato), vectorSize, file);
    
}

//desaloca o vetor inteiro da memória.
void limparMemoria(Contato* vector){
        free(vector);
}

int main(){
    Contato *vector;
    int vectorSize;
    long fileSize;

    char* nomeArquivo = readline('\n');

    /*
    char* arkivo = readline('\n');
    printf("%s", arkivo);
    */

    FILE *file = fopen(nomeArquivo, "rb");

    fseek(file, 0, SEEK_END);
    fileSize = ftell(file);
    
    fseek(file, 0, SEEK_SET);
    
    printf("filesize: %ld", fileSize);
    vectorSize = fileSize/sizeof(Contato);
    printf("vectorSize: %d", vectorSize);

    vector = (Contato*) malloc(vectorSize*sizeof(Contato));

    lerArquivo(vector, vectorSize, file);

    for (int i = 0; i < vectorSize; i++){
        printf("\nNUSP: %d\nNome: %s\nCurso: %s\nNota: %.2f", vector[i].nUSP, vector[i].nomeCompleto, vector[i].curso, vector[i].nota);
    }
    printf("\n");

    limparMemoria(vector);

    free(nomeArquivo);
    fclose(file);

    return 0;
}














/*
int main()
{
    int num_operacoes;
    //pegando o numero de operaçoes
    scanf("%d\n", &num_operacoes);
    char *operacao, *num_1 , *num_2;

    for (int i = 0; i < num_operacoes; i++)
    {   
        operacao = readline(' ');
        num_1 = readline(' ');
        num_2 = readline('\n');
        
        lista_t *lista_num_1 = cria();
        lista_t *lista_num_2 = cria();
        
        for (int i = 0; i < (int)strlen(num_1); i++)
            insertInicio(lista_num_1, ((int)num_1[i] - 48)); //string p int
        
        for (int i = 0; i < (int)strlen(num_2); i++)
            insertInicio(lista_num_2, ((int)num_2[i] - 48));
        
        ImprimirResultado(operacao, lista_num_1, lista_num_2);
        destroi(lista_num_1);
        destroi(lista_num_2);
        free(operacao);
        free(num_1);
        free(num_2);
    }
    return 0;
}
*/