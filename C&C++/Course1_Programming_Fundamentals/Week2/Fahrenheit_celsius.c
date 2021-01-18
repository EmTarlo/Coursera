#include <stdio.h>

/* program to convert from fahrenheit to celsius*/

int main(){

float fheit, celsius;

printf("\nPlease input the temperature in Fahrenheit:\n");
scanf("%f",&fheit);
celsius = (fheit-32)*5/9;
printf("\nYour temperature in celsius is: %f degree",celsius);
return 0;
}