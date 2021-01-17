#include <stdio.h>
int main()
{
    // kindly input the file name (if in same folder) or file path from your machine below, replacing mine
    FILE* f = fopen("elephantSeals.txt", "r");
    int n = 0, i = 0, size=0, sum=0;
    double avg;
    
    // getting the amount of elephant seals weights in the file to determine array's size
    while( fscanf(f, "%d\t,", &n) !=EOF) 
    {
       //printf("\n%d\n\n",n);
       size++;
    }

    //initialising the array that will contain elephant seals weights
    int weights[size];
    //printf("\n%d\n\n",weights[45]);
    
    
    //looping through all weights in file and assigning them to the array
     while( fscanf(f, "%d\t,", &n) !=EOF) 
    {
        weights[i++]=n;
    }
    
    //closing the file
    fclose(f);
    //

    TBC:  //looping through the array and printing all weights
    for(i=0;i<size;i++){
        printf("\n%d\n\n",weights[i]);
    }
    
    //looping through the array and get the sum of all weights
    for(i=0;i<size;i++){
        sum=sum + weights[i];
    }
    
    //determining the average and printing it out
    avg = sum/size;
    //printf("\n%lf\n\n",avg);
}