#include <stdio.h>
#include <stdlib.h>

typedef long long int lli;

void swap(lli *a, lli *b) {
    lli aux = *a;
    *a = *b;
    *b = aux;
}

lli min(lli a, lli b) {
    if (a >= b)
        return b;
    else
        return a;
}

int main() {
    lli x1, y1, l1, a1, x2, y2, l2, a2;
    lli hit_x, hit_y, hit_l, hit_a;

    scanf("%lld %lld %lld %lld", &x1, &y1, &l1, &a1);
    scanf("%lld %lld %lld %lld", &x2, &y2, &l2, &a2);

    if (x1 > x2) { // Valor x2 e l2 serão os maiores
        swap(&x1, &x2);
        swap(&l1, &l2);
    }
    if (y1 > y2) { // Valor y2 e a2 serão os maiores
        swap(&y1, &y2);
        swap(&a1, &a2);
    }
    if ((abs(x2 - x1) <= l1) && (abs(y2 - y1) <= a1)){ // Checa se está contido ou na borda, ou fora
        hit_x = x2;
        hit_y = y2;
        hit_l = min(x1 + l1, x2 + l2) - hit_x;
        hit_a = min(y1 + a1, y2 + a2) - hit_y;
        printf("HIT: %lld %lld %lld %lld\n", hit_x, hit_y, hit_l, hit_a);
    } else { // Se estiver fora
        printf("MISS\n");
    }
    return 0;
}