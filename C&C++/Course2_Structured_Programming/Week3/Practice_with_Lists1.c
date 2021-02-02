#include<stdio.h>
#include<stdlib.h>

typedef struct list{int data; struct list *next;} list;


int is_empty(list *l){
    return(l==NULL);
}


void print_list(list *pointer_to_list){

   list* n = pointer_to_list;
   printf("\n");

   while(n!=NULL){
        int d = pointer_to_list -> data;
        printf("%d\t",d);
        n = n -> next;        
    }
    printf("\n\n");
}


int main(){

    list list_of_int;
    list *pointer_to_list_of_int = &list_of_int;
    pointer_to_list_of_int = malloc(sizeof(list));
    pointer_to_list_of_int -> data = 5;
    pointer_to_list_of_int -> next = NULL;

    print_list(pointer_to_list_of_int);

    return 0;
}