#include<stdio.h>

// user-defined type "month"
typedef enum month {jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec} month;

// user-defined type "date" (struct)
typedef struct date {month m; int d;} date;

// void method to print out full months' names
void printMonth(month m){
    switch(m){
        case(0):printf("January");break;
        case(1):printf("February");break;
        case(2):printf("March");break;
        case(3):printf("April");break;
        case(4):printf("May");break;
        case(5):printf("June");break;
        case(6):printf("July");break;
        case(7):printf("August");break;
        case(8):printf("September");break;
        case(9):printf("October");break;
        case(10):printf("November");break;
        case(11):printf("December");break;
 
    }
}


// function to get the number of days in given month (assumption: February has always 28 days)
int getDaysInMonth(month m){
    if(m==1){
        return 28;
    }else if(m==10||m==3||m==5||m==8){
        return 30;
    }else{
        return 31;
    }
}

// function to get the next day starting from an input date
date getNextDay(date input_date){
    month input_month = input_date.m;
    int days_in_month = getDaysInMonth(input_month);
    date ret_date;
    if((((input_date.d)+1)<=days_in_month)){
        ret_date.m = input_month;
        ret_date.d = input_date.d +1;
    }else{
        ret_date.m = (input_month+1)%12;
        ret_date.d = 1;
    }
    return ret_date;
}


int main(){

    // Testing the above defined functions using following dates: January 1, February 28, March 14, October 31 and December 31.
    
    date test_date;
    test_date.m = jan;
    test_date.d = 1;

    date next_day_date = getNextDay(test_date);
    
    printf("\nInput date is: ");
    printMonth(test_date.m); 
    printf(" %d",test_date.d);

    printf("\nNext day is: ");
    printMonth(next_day_date.m); 
    printf(" %d\n\n",next_day_date.d);

    test_date.m =feb;
    test_date.d =28;

    next_day_date = getNextDay(test_date);
    
    printf("\nInput date is: ");
    printMonth(test_date.m); 
    printf(" %d",test_date.d);

    printf("\nNext day is: ");
    printMonth(next_day_date.m); 
    printf(" %d\n\n",next_day_date.d);

    test_date.m =mar;
    test_date.d =14;

    next_day_date = getNextDay(test_date);
    
    printf("\nInput date is: ");
    printMonth(test_date.m); 
    printf(" %d",test_date.d);

    printf("\nNext day is: ");
    printMonth(next_day_date.m); 
    printf(" %d\n\n",next_day_date.d);

    test_date.m =oct;
    test_date.d =31;

    next_day_date = getNextDay(test_date);
    
    printf("\nInput date is: ");
    printMonth(test_date.m); 
    printf(" %d",test_date.d);

    printf("\nNext day is: ");
    printMonth(next_day_date.m); 
    printf(" %d\n\n",next_day_date.d);

    test_date.m =dec;
    test_date.d =31;

    next_day_date = getNextDay(test_date);
    
    printf("\nInput date is: ");
    printMonth(test_date.m); 
    printf(" %d",test_date.d);

    printf("\nNext day is: ");
    printMonth(next_day_date.m); 
    printf(" %d\n\n",next_day_date.d);


    return 0;
}