#include<stdio.h>
#include<stdlib.h>
#include<time.h>


//-------------------- What follows immediately below are helper functions---------------------------

// defining the type "list"
typedef struct list{int data; struct list *next;} list;

// simple function to check if input list is empty
int is_empty(list *l){
    return(l==NULL);
}

// void function to print all the elements of input list
void print_list(list* pointer_to_list){
   
   int helper = 0; // helper variable to print only 5 list-items on each row
   printf("\n");

   while(pointer_to_list!=NULL){
        helper++;
        int d = pointer_to_list -> data;
        printf("%d\t",d);
        if(helper%5==0){printf("\n");};  // go to new line if helper is a multiple of 5
        pointer_to_list = pointer_to_list -> next;        
    }
    printf("\n\n");
}

// function to create a single-item list from integer input d
list* create_list(int d){

    list your_list;
    list* pointer_to_your_list = malloc(sizeof(your_list));

    pointer_to_your_list->data = d;
    pointer_to_your_list->next = NULL;

    return pointer_to_your_list;

}

// function to add input integer d to the front of input list old_list
list* add_to_front(int d, list* old_list){

    list* pointer_to_new_list = create_list(d);
    pointer_to_new_list -> next = old_list;

    return pointer_to_new_list;

}

// function to swap data of two nodes a and b //
void swap(list* a, list* b) 
{ 
    int temp = a->data; 
    a->data = b->data; 
    b->data = temp; 
} 


// helper function to generate random numbers between 0 and (max-1)
int rand_num(int max){
    int ret_num = rand() %(max);
    return ret_num;
}


// function to generate a list of (max) random elements (from 0 to max-1) 
list* random_list(int max){
    
    //re-setting the seed for random numbers' generator
    srand(time(NULL));
    
    list* my_list = create_list(rand_num(max));

    for(int i=1;i<100;i++){
        int r = rand_num(100);
        my_list = add_to_front(r,my_list);

    }

    return my_list;

}


//-------------------- What follows immediately below is the bubble-sort algorithm and the main program ---------------------------

// bubble-sort algorithm
void bubbleSort(list* start) 
{ 
    int swapped, i; 
    struct list* ptr1; 
    struct list* lptr = NULL; 
  
    /* Checking for empty list */
    if (start == NULL) 
        return; 
  
    do
    { 
        swapped = 0; 
        ptr1 = start; 
  
        while (ptr1->next != lptr) 
        { 
            if (ptr1->data > ptr1->next->data) 
            {  
                swap(ptr1, ptr1->next); 
                swapped = 1; 
            } 
            ptr1 = ptr1->next; 
        } 
        lptr = ptr1; 
    } 
    while (swapped); 
}   


int main(){  
    
    // generating a list of 100 random numbers
    list* l = random_list(100);
    
    //printing the list before sorting 
    printf("\nList before sorting:\n\n");
    print_list(l);

    //calling bubble-sort on the list
    bubbleSort(l);

    //printing the list after sorting
    printf("\nList after sorting:\n\n");
    print_list(l);
  
    return 0;
}