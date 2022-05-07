#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

//valores trocados para long int pq o caso 28 não cabe em int

void trocaPonteiro(long int *ponteiro1, long int *ponteiro2){
    //função que troca o ponteiro 1 pelo ponteiro 2.
    long int auxiliar = *ponteiro1;
    *ponteiro1 = *ponteiro2;
    *ponteiro2 = auxiliar;
}
int main(){
    long int x1,y1,l1,h1;
    long int x2,y2,l2,h2;
    long int xi,yi,li,hi;
   //colhendo as entradas:
   //retangulo 1
    scanf("%ld %ld %ld %ld\n", &x1, &y1, &l1, &h1);
    //retangulo 2
    scanf("%ld %ld %ld %ld\n", &x2, &y2, &l2, &h2);
/* 
    Como o retângulo possui entradas do tipo <x> <y> <l> <h>,
    o formato de crescimento do triangulo será sempre seguindo o canto inferior direito.
    Sendo assim, precisamos verificar qual dos 2 triangulos possui o menor ponto (x,y), 
    pois assim, ele é o retângulo 1, como no caso do run.codes. Para isso, podemos trocar a ordem
    dos triangulos utilizando a funçao trocaPonteiro(), pois só nos interessa o triangulo de 
    intersecção.
*/
    //Logo, verificando qual "X" dos triangulos é o primeiro, temos:
    if (x1 > x2){ //se x1 for maior que x2, então ele está a direita, logo:
        trocaPonteiro(&x1,&x2); //x2 é maior, então entra no primeiro retangulo
        trocaPonteiro(&l1,&l2); //l2 também é maior, pois será o primeiro retangulo (o que engloba)
    }

    //agora, verificando "Y":
    if (y1 > y2){
        trocaPonteiro(&y1, &y2);
        trocaPonteiro(&h1, &h2);
    }
    //agora, precisamos verificar se o retângulo 2 está dentro do retângulo 1, depois verificar 
    // se existe intersecção em apenas um canto ou se não existe intersecção.
    //verificando se existe intesecção:

    if ((abs(x2 - x1 ) <= l1 ) && (abs(y2 - y1) <= h1)){
        //existe intesecção, então vamos encontrar o retângulo de intersecção:
        xi = x2;
        yi = y2;
        // agora, verificando qual será o tamanho da largura e altura, vamos ver qual das diferenças é menor:
        if ((x1 + l1) >= (x2 + l2)){ 
            li = (x2 + l2) - x2; 
        } else li = (x1 + l1) - x2;  
        if ((y1 + h1) >= (y2 + h2)){ 
            hi = (y2 + h2) - y2; 
        } else hi = (y1 + h1) - y2; 

        printf("HIT: %ld %ld %ld %ld\n", xi, yi, li, hi);
    }
    else printf("MISS\n");
    
    
    
    return EXIT_SUCCESS;
}