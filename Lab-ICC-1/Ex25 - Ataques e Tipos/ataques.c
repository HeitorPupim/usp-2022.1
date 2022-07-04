#include <stdio.h>
#include <stdlib.h>

/*
Cria e aloca espaço para uma matriz que multiplica o dano 
dos ataques com o tamanho passado como parâmetro.
*/
float **createMatrix(int nTypes){
   float **matrix = (float**)malloc(nTypes*sizeof(float*) * nTypes);
   for (int i = 0; i < nTypes; i++){
      matrix[i] = (float*)malloc(nTypes*sizeof(float));
   }
   return matrix;
}

//Insere dados na matriz multiplicadores de dano:
void getData(float **matrix, int nTypes){
   for (int i = 0; i < nTypes; i++){
      for (int j = 0; j < nTypes; j++){
         scanf("%f", &matrix[i][j]);
      }
   }
}

//Cria a matriz com 2colunas e nlinhas.
int **createAtkMatrix(){
   int **matrix = (int**)malloc(sizeof(int**)*1); //cria uma matriz de tam. minimo 1.
   return matrix;
}

//
void printMostAffectiveATKKind(float **multMatrix, int **AtkMatrix, int nAtkCount,int enemyType){
   float maxDMG = 0, DMG = 0;
   int MostAffectiveKind = 0;
   for (int i = 0; i < nAtkCount; i++) {
      DMG = AtkMatrix[i][0] * multMatrix[AtkMatrix[i][1]][enemyType];
      if (DMG > maxDMG) { 
         maxDMG = DMG;
         MostAffectiveKind = i;
      }
   }
   printf("O melhor ataque possui indice %d e dano %.2f\n", MostAffectiveKind, maxDMG);
}

void freeMem(float **multMatrix, int nTypes, int **atkMatrix, int nAtkCount) {
    for (int i = 0; i < nAtkCount; i++) {
        free(atkMatrix[i]);
    }
    for (int i = 0; i < nTypes; i++) {
        free(multMatrix[i]);
    }
    free(atkMatrix);
    free(multMatrix);
}

// Lê os ataques e insere na matriz até encontrar -1.
void showResult(int **atkMatrix, int nAtkCount, float **multMatrix, int nTypes){
   int atk1, atk2;
   
   while(1){
      scanf("%d", &atk1);
      if (atk1 != -1){
         scanf("%d", &atk2);

         atkMatrix = (int**)realloc(atkMatrix, sizeof(int**)*(nAtkCount+1)); //realoca a matriz para 2 colunas.
         atkMatrix[nAtkCount] = (int*)malloc(sizeof(int)*2); //aloca 2 linhas para cada coluna.

         atkMatrix[nAtkCount][0] = atk1;
         atkMatrix[nAtkCount][1] = atk2;
         
         nAtkCount++;
      }else //qnd o atk1 for = -1, sai do while.
         break;
   }
   int enemyType;
   scanf("%d", &enemyType);
   printMostAffectiveATKKind(multMatrix, atkMatrix, nAtkCount, enemyType);
   freeMem(multMatrix, nTypes, atkMatrix, nAtkCount);
}



int main(){

   int nTypes;
   scanf("%d\n", &nTypes);

   //Criando a matriz de multiplicador de dmg e insere os dados nela. 
   float **multMatrix = createMatrix(nTypes);
   getData(multMatrix, nTypes);

   //Criando matriz de ataques:
   int **atkMatrix = NULL;
   int nAtkCount = 0;
   
   showResult(atkMatrix, nAtkCount, multMatrix, nTypes);
   
   return EXIT_SUCCESS; 
}
