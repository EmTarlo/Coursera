#include <stdio.h>
#include <math.h>

int main () {
   
    double input, sine_value;  

    printf("Please enter a number between 0 and 1 (non inclusive):\n");
    scanf("%lf",&input);

    while(input<=0 || input>=1){
        printf("Your number has to be between 0 and 1 (non inclusive):\n");
        scanf("%lf",&input);
    }

    sine_value = sin(input);
    printf("The value of the sine function at %lf is: %lf.\n",input,sine_value);
   
    return(0);
}