package com.Week3;

public class CompareToPivotAndCount {


    private int nbr_of_comparisons;

    public CompareToPivotAndCount(){
        nbr_of_comparisons = 0;
    }

    public int getNbrOfComparisons(){return nbr_of_comparisons;}

    public boolean compare_to_pivot_and_count(int arr_element, int pivot){
        nbr_of_comparisons++;
        boolean flag;
        if(arr_element<pivot){flag = true;}
        else{flag =false;}
        return flag;
    }
}
