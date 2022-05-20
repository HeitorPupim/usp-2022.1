#include <stdio.h>
#include <stdlib.h>

void printMessage(int message, int round, int newRound) {
    if (message == 1) {
        if (round == 1) {
            printf("%d pinguim\n", newRound);
        } else {
            printf("%d pinguins\n", newRound);
        }
    } else if (message == 2) {
        printf("no gelo\n");
    } else {
        printf("uhuu!\n");
    }
}

int main() {
    
    int n, // num max. de rodadas
    m, // num. jogadores
    p; // vez pingu

    scanf("%d %d %d", &n, &m, &p);

    int newRound = 1, message = 1, count = 1; //def. cond. inicial 

    for (int round = 1; round <= n; round++) {
        if (count == 0) {
            count = newRound; // reseta contagem
            message++; // Muda de message toda vez que mudar de round
        }
        if (p == m) {
            if (round % m == 0) printMessage(message, round, newRound);
            
        } else {
            if (round % m == p) printMessage(message, round, newRound);
        }
        count--;
        if (message == 3 && count == 0) {
            message = 0;
            newRound++;
        }
    }
    return EXIT_SUCCESS;
}