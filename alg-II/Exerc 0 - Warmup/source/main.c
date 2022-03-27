#include <lista.h>
#include <util.h>
#include <string.h>


// #include <operacoes.h>


typedef struct{
    int nUSP;
    char nomeCompleto[50], curso[50];
    float nota;
}Contato;

void ler(char arq[]){
    Contato c;
    FILE *file = fopen(arq, "rb");
    int contador = 0;
    if (file){
        while (!feof(file)){
            if(fread(&c, sizeof(Contato), 1 , file))
            printf("\nNUSP: %d\nNome: %s\nCurso:%s \nNota:%.2f", c.nUSP, c.nomeCompleto, c.curso, c.nota);
            contador +=1;
            printf("\n Contador = %d", contador);
        }
        fclose(file);
    }
    else    printf("\nErro ao abrir o arqivo! \n");
}


int main(){
    char arquivo[] = {"/home/heitor/workspace/usp-2022.1/alg-II/Exerc 0 - Warmup/in_out/reg2.dat"};

    ler(arquivo);

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