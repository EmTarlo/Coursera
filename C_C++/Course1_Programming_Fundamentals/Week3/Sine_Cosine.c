// this program outputs a table of sine and cosine values between 0 and 1, with 0.10 increments.
#include<stdio.h>
#include<math.h>

int main(){

double interval;
int i;

printf("\n-----------------------------\n");
printf("\nValue     Sine      Cosine\n");
printf("\n-----------------------------\n");

// core of the program: for loop that prints values and respective sine and cosine 
for(i=0;i<=10;i++){

interval = i/10.0;
printf("\n%lf  %lf  %lf\n",interval,sin(interval),cos(interval));
}

printf("\n-------------------------------\n");
return 0;
}