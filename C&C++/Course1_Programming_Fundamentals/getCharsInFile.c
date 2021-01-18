#include<stdio.h>

int main() {

int blanks=0,digits=0,letters=0,characters=0,others=0,c,id_sum;

for(;(c=getchar())!=EOF;characters++){
    if(c==' '){
        blanks++;
    } else if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
        letters++;
    }else if(c>='0'&&c<='9'){
        digits++;
    }else {
        others++;
    }
}

id_sum = blanks+letters+digits+others;

printf("\nWe identified %d letters.",letters);
printf("\nTotal characters found: %d\n",characters);
printf("Sum of all identified characters is: %d\n",id_sum);

return 0;

}