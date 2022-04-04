#include <stdio.h>
#include <stdlib.h>

int main(){
   int a, b; 
   scanf("%d %d\n", &a, &b); 
   
   printf("%d\n", (a & b)); // a AND b
   printf("%d\n", (a | b)); // a OU b
   printf("%d\n", (a ^ b)); // a XOR B
   printf("%d\n", ~(a));    // COMPLEMENT a
   printf("%d\n", ~(b));    // COMPLEMENT b
   printf("%d\n", a >> 2);  // RIGHT SHIFT a
   printf("%d\n", b << 2);  // LEFT SHIGT b
   
    return EXIT_SUCCESS; 
}