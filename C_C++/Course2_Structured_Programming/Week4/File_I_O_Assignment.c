// INSTRUCTIONS
// In order to run the program, kindly create a ".txt" file called "Integers" in the same folder
// in which you are running this c file.
// The file should contain the following integers: 4  9  11  12  15

#include<stdio.h>

// unfortunately, in C it is not possible to declare and initialize variable-sized arrays,
// hence the constant declaration below.
#define MAX_SIZE 4

// function to print the elements in a given array
void print_array(int arr[],int size){
    
    printf("\nYour array contains following elements:\n");
    printf("\n[ ");
    for(int i=0;i<size;i++){
        printf("%d ",arr[i]);
    }
    printf("]\n\n");

}

// function to read in the array size from the input file. Just for demonstration here, 
// as size is set to a constant value for the reasons mentioned above.
void get_array_size_from_file(FILE* input, int* size){    
    
    while(1){
        rewind(input);
        fscanf(input,"%d",size);
        break;
    }
}

// function to read data from a file into an input array
void read_data_from_file(FILE* ptr, int arr[], int* size){
    *size = 0;

    while(fscanf(ptr,"%d",&arr[*size])==1){
        (*size)++;
    }
}

// function to compute the average of the elements in a given array
double compute_average(int array[],int size){
    double average=0;
    for(int i=0;i<size;i++){
       average += array[i];
    }
    return average/size;
}

// function to compute the max of the elements in a given array
int compute_max(int array[],int size){
    int max = 0;
    for(int i=0;i<size;i++){
       if(array[i]>max){
           max = array[i];
       }
    }
    return max;
}

// main program
int main(){

FILE* fptr;

int size = 0;

int arr[MAX_SIZE] = {0};

fptr = fopen("Integers.txt","r");

get_array_size_from_file(fptr,&size);

printf("\nSize is: %d\n",size);

read_data_from_file(fptr,arr,&size);

print_array(arr,size);

double average = compute_average(arr,size);
printf("Average is: %lf\n\n",average);

int max = compute_max(arr,size);
printf("Max is: %d\n\n",max);

return 0;

}