#include<stdio.h>
#include<stdlib.h>

/*
Program to double the spacing in a given input file and save it in a new output file.
Key idea: practice argc and argv as arguments to main.
*/

void print_file(FILE* fptr){
    int c;
    rewind(fptr);
    while(c=getc(fptr)!=EOF){
        putc(c,stdout);
    }
}

void double_space(FILE* input, FILE* output){
    int c;
    rewind(input);
    while((c=getc(input))!=EOF){
        putc(c,output);
        if(c=='\n'){
            putc(c,output);
        }
    }
}


int main(int argc, char *argv[]){    
    
    FILE* input;
    FILE* output; 

    if(argc!=3){
        printf("\nPlease note: you need to enter \n1) An executable file \n2) An input file \n3) An output file \nas arguments. Exiting the program.\n\n");
        exit(1);
    }else{
        input = fopen(argv[1],"r+");
        output = fopen(argv[2],"w+");
        printf("\nInput file read was: %s",argv[1]);
        print_file(input);
        printf("\nOutput file read was: %s",argv[2]);
        printf("\n\n");
        double_space(input,output);
        print_file(output); 
        printf("\n\n");      

    }

    fclose(input);
    fclose(output);

    return 0;

}