#include <update.h>


/*
    Função de update dá pra reaproveitar a leitura da insert,
    pq quando faz update ele lê a mesma qtde de campos da inserção.

    -> ex: update 18:

        cria um novo tipo registro
        acessa o index 18

        remove 18->nome, 18-> sobrenome, etc.

        lê nome
        insere nome
        lê sobrenome
        insere sobrenome, etc.
    

*/