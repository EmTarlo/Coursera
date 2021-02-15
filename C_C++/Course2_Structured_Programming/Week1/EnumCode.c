#include<stdio.h>

enum day {sun,mon,tue,wed,thu,fri,sat};


void print_day(enum day d){
    switch(d){
        case(0):printf("\nSunday\n");break;
        case(1):printf("\nMonday\n");break;
        case(2):printf("\nTuesday\n");break;
        case(3):printf("\nWednesday\n");break;
        case(4):printf("\nThursday\n");break;
        case(5):printf("\nFriday\n");break;
        case(6):printf("\nSaturday\n");break;
        default:printf("\nNot a valid day.\n\n");
    }
}

enum day get_next_day(enum day d){
    
    return ((d+1)%7);    

}


int main(){

    print_day(7);

    return 0;
}