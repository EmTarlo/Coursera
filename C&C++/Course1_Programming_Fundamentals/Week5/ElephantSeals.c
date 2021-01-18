#include <stdio.h>
int main()
{
   
    //IMPORTANT: you will see that "size" is by default declared to be equal to 1000 here: I had to determine the number 
    //of weights in the txt file separately, as doing that here made my initialization of weights' array don't work: would you
    //know why is that? thank you in advance

    int n = 0;
    int i = 0;
    int sum=0;
    const int size=1000;
    double avg;

    
    // opening the file with weights - to be replaced with your own file name or file path
    FILE* f = fopen("ElephantSeals.txt", "r");

    //initializing array of weights 
    int weights[size];

    //looping through the weights in the file and storing them into the array
    while( fscanf(f, "%d\t,", &n) !=EOF) 
    {
        weights[i++]=n;
    }
    
    //closing the file
    fclose(f);    
   
   //looping through the array of weights to determine the sum (numerator of average)
    for(i=0;i<size;i++){
        sum=sum + weights[i];
    }
    
    //computing the average and then printing it
    avg = sum/size;
    printf("\nThe average weight is: %.2lf\n\n",avg);
}


