#ifndef LISTA_H
#define LISTA_H

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

//definindo a lista:
typedef int num;
typedef struct no_st no_t;

struct no_st { //bignumber
    num info;
    int carry;
    no_t *prox;
};

typedef struct lista_st {
    no_t *ini, *fim;
    int tam;
}lista_t;

//prop. da lista encadeada:
lista_t *cria();
void destroi(lista_t *lista);
void popularLista(char *numero);
void insertFim(lista_t *lista, num x);
void insertInicio(lista_t *lista, num x);
void remover(lista_t *lista, num x);
void imprimir(lista_t *lista);
int tamanho(lista_t *lista);
int esta_na_lista(lista_t *lista, int x);
int encontrarPosicao(lista_t *lista, int pos);

#endif // LISTA_H
