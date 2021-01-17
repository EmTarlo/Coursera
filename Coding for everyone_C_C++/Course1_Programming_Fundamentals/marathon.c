#include <stdio.h>

int main(void){

int miles=26, yards=385;
double kilometeres;

kilometeres = 1.609*(miles + yards/1760.0);
printf("\nA marathon is %lf kilometers long\n\n", kilometeres);

return 0;


}