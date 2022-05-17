#include <stdio.h>
#include <stdlib.h>

#define VECTOR_SIZE 4

double min4Numbers(double* vector){
    double aux = vector[0];
    for (int i = 0; i < VECTOR_SIZE; i++){
        if (aux >= vector[i])   aux = vector[i];
    }
    return aux;
}

double mean(double * vector){

    double mean = 0;

    for (int i = 0; i < VECTOR_SIZE; i++){
        mean += vector[i];
    }
    
    return ((mean - min4Numbers(vector))/(VECTOR_SIZE-1));
}

int main(){
    double *vector = malloc(sizeof(double)*VECTOR_SIZE);

    scanf("%lf %lf %lf %lf \n", &vector[0] ,&vector[1] ,&vector[2] ,&vector[3]);

    printf("%.4f \n", mean(vector));

    free(vector);
    return EXIT_SUCCESS;
}