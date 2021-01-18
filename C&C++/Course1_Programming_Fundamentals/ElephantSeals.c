#include<stdio.h>

int main(){
    int c;
    int size=0;

    FILE *file;
    file = fopen("elephantSeals.txt", "r");
    if (file) {
        while ((c = getc(file)) != EOF)
            putchar(c);
            //printf("\n%d\n\n",c);
        fclose(file);
    }
    printf("\n%d\n\n",size);
}