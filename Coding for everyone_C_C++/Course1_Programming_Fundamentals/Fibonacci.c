#include<stdio.h>


long int rFibonacci(int n){
    if(n<=1){
        return n;
    }else{
        return(rFibonacci(n-1)+rFibonacci(n-2));
    }

}

long int iFibonacci(int n){
 long f2=0,f1=1,f_old;
 int i;

    for(int i=0;i<n;i++){
       f_old=f2;
       f2 = f2+f1;
       f1 = f_old; 
    }
    return f2;
}


int main(){
    int item=0;
    while(item<=10){
        printf("\nitem %d: %ld  %ld\n",item,iFibonacci(item),rFibonacci(item));
         item++;
    }

}