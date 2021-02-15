#include<stdio.h>


#define max_size 7


void print_array(int arr[],int size){

    for(int i=0;i<size;i++){
        printf("\n%d",arr[i]);
    }

}


void read_data_from_file(FILE* ptr, int arr[], int* size){
    *size = 0;

    while(fscanf(ptr,"%d",&arr[*size])==1){
        (*size)++;
    }
}


int main(){

    int size = max_size;

    int data_from_file[max_size] = {0};
    
    FILE* ipf;
    ipf = fopen("Input_File.txt","r");


    read_data_from_file(ipf,data_from_file,&size);

    print_array(data_from_file,size);
    printf("\n%c","");

    fclose(ipf);

    return 0;
}