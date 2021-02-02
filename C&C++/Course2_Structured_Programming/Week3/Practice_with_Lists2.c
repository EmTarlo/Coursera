#include<stdio.h>
#include<stdlib.h>

typedef struct list{int data; struct list *next;} list;


int is_empty(list *l){
    return(l==NULL);
}


void print_list(list* pointer_to_list){
   
   printf("\n");

   while(pointer_to_list!=NULL){
        int d = pointer_to_list -> data;
        printf("%d\t",d);
        pointer_to_list = pointer_to_list -> next;        
    }
    printf("\n\n");
}

list* create_list(int d){

    list your_list;
    list* pointer_to_your_list = malloc(sizeof(your_list));

    pointer_to_your_list->data = d;
    pointer_to_your_list->next = NULL;

    return pointer_to_your_list;

}

list* add_to_front(int d, list* old_list){

    list* pointer_to_new_list = create_list(d);
    pointer_to_new_list -> next = old_list;

    return pointer_to_new_list;

}


list* array_to_list(int input_arr[], int size){

    list* l = create_list(input_arr[0]);
    
    for(int i=1;i<size;i++){        
        l = add_to_front(input_arr[i],l);   
    }

    return l;
}

int main(){

    int arr[11] = {0,1,2,3,4,5,6,7,8,9,10};  
    list* l = array_to_list(arr,11);
    print_list(l);  

    return 0;
}