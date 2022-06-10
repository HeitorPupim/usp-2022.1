#include <stdlib.h>
#include <stdio.h>

#define NUM_ROWS 32
#define NUM_COLUMNS 64

//elements of the matrix:
#define SAND '#'
#define WATER '~'
#define CEMENT '@'
#define AIR ' '


void imprime_matriz(int);
void applyPhysics();
void troca(int, int, int, int);

char matriz[NUM_ROWS][65];
char matriz_copia[NUM_ROWS][NUM_COLUMNS];

int main() {
   int num_frames, frame, x, y;
   char particula;

   //Create a matrix and put '\0' delim in the last cell.
   for (int i = 0; i < NUM_ROWS; i++) {
      for (int j = 0; j < NUM_COLUMNS+1; j++) {
         if (j == NUM_COLUMNS) {
               matriz[i][j] = '\0';
         } else {
               matriz[i][j] = AIR;
         }
      }
   }

   scanf("%d", &num_frames);

   int contador = 0;
   while (contador < num_frames) {
      int leitura = scanf(" %d: %d %d %c", &frame, &x, &y, &particula);

      if (leitura == EOF) {
         // Quando for EOF, sai do loop
         frame = num_frames;
      }
      while (contador < frame) {
         // Para cada iteração, imprime a matriz, adicionando a física na próxima iteração
         imprime_matriz(contador);
         applyPhysics();
         contador++;
      }
      if (leitura != EOF) {
         // Não sendo EOF, adiciona na matriz a partícula
         matriz[y][x] = particula;
      }
   }
   return EXIT_SUCCESS;
}

void applyPhysics(){
   //Create a copy of the matrix to get veririf. in physics comparting the next with the previous movement
   for (int i = 0; i < NUM_ROWS; i++){
      for (int j = 0; j < NUM_COLUMNS; j++){     
         matriz_copia[i][j] = matriz[i][j];
      }
   }

   // Aplly physics based on elements:
   for (int y = 0; y < NUM_ROWS; y++) {
      for (int x = 0; x < NUM_COLUMNS; x++) {
         
         if (matriz[y][x] == SAND){ //
               // Se for areia, checa se é água ou ar
               // A checagem das bordas se encontra na função troca
               if (matriz[y+1][x] ==  WATER || matriz[y+1][x] == AIR){
                  troca(x, y, x, y+1);
               } else if (matriz[y+1][x-1] ==  WATER || matriz[y+1][x-1] == AIR){
                  troca(x, y, x-1, y+1);
               } else if (matriz[y+1][x+1] ==  WATER || matriz[y+1][x+1] == AIR){
                  troca(x, y, x+1, y+1);
               }
         } else if (matriz[y][x] ==   WATER) {
               // Se for água, checa se é ar
               // Checa, ainda, se é borda. Caso seja, não fará a troca
               // Nesse caso foi necessário checar nos ifs, pois alguns ifs eram aceitos
               // sem essas condições
               if (matriz[y+1][x] == AIR && y+1 < NUM_ROWS) {
                  troca(x, y, x, y+1);
               } else if (matriz[y+1][x-1] == AIR && y+1 < NUM_ROWS && x-1 >= 0){
                  troca(x, y, x-1, y+1);
               } else if (matriz[y+1][x+1] == AIR && y+1 < NUM_ROWS && x+1 < NUM_COLUMNS){
                  troca(x, y, x+1, y+1);
               } else if (matriz[y][x-1] == AIR && x-1 >= 0){
                  troca(x, y, x-1, y);
               } else if (matriz[y][x+1] == AIR && x+1 < NUM_COLUMNS){
                  troca(x, y, x+1, y);
               }
         }
      }
   }
   for (int i = 0; i < NUM_ROWS; i++) {
      for (int j = 0; j < NUM_COLUMNS; j++) {
         // Salva a cópia na matriz original
         matriz[i][j] = matriz_copia[i][j];
      }
   }
}

void troca(int x1, int y1, int x2, int y2) {
   // Checa as condições caso seja detectado uma borda
   if (x2 < NUM_COLUMNS && x2 >= 0 && y2 < NUM_ROWS) {
      // Faz a troca entre 2 posições da matriz_copia
      char aux = matriz_copia[y1][x1];
      matriz_copia[y1][x1] = matriz_copia[y2][x2];
      matriz_copia[y2][x2] = aux;
   }
}

void imprime_matriz(int contador) {
   printf("frame: %d\n", contador + 1);
   for (int i = 0; i < NUM_ROWS; i++) {
      // Loop para imprimir as linhas
      printf("%s\n", matriz[i]);
   }
}