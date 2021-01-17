#include <stdio.h>
#include <math.h>


int main(void){

    int pile_a[5]={11,22,30,82,99};
    int pile_b[7]={1,5,27,43,81,82,100};

    int m = sizeof(pile_a)/4;
    int n = sizeof(pile_b)/4;
    int o = m+n;
    int pile_c[o];
    int i=0,j=0,k=0,l=0;

    printf("\nSize of a is: %d, size of b is: %d and size of c is: %d\n",m,n,o);

    while(i<m && j<n){
        if(pile_a[i]<pile_b[j]){
            pile_c[k++]=pile_a[i++];
        }else{
            pile_c[k++]=pile_b[j++];
        }
    }
    while(i<m){
        pile_c[k++] = pile_a[i++];
    }
    while(j<n){
        pile_c[k++] = pile_b[j++];
    }
    
    
    while(l<o){
        printf("\n%d\n",pile_c[l++]);
    }


    return 0;

}