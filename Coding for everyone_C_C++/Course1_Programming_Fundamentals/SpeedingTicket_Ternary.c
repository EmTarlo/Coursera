#include<stdio.h>

int main(){

int speed;

printf("\nWhat was your speed?\n\n");
scanf("%d",&speed);

speed=(speed<=65)? 65:(speed<90)? 70:90;

switch(speed){
case 65: printf("\nNo speeding ticket.\n\n"); break;
case 70: printf("\nYou get a speeding ticket.\n\n"); break;
case 90: printf("\nYou get an expensive speeding ticket\n\n"); break;
}
return 0;
}