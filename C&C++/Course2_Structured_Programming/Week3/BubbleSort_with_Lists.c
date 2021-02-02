#include<stdio.h>
#include<stdlib.h>
#include<time.h>



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

// bubble-sort algorithm

list* bubble_sort(list* l){

    int temp;
    list* a;
    list* b=l->next;     

    while(b!=NULL){
        a = b;
        b = a->next;
        //printf("\n%d %d\n\n",a->data,b->data);
        if((a->data)>(b->data)){
            temp = b->data; 
            b->data=a->data;
            a->data = temp;
        }
    }
    return l;
}


int main(){  
    
    list* input_list = random_list(100);
    print_list(input_list);
    list* output_list = bubble_sort(input_list);
    print_list(output_list);

    return 0;
}