package ibu.edu;

public class InsertionSort {
    public static void sort(Comparable[] elements){

        for(int i = 1; i < elements.length;i++){

            Comparable curr = elements[i];
            int j = i - 1;

            while(j>=0 && elements[j].compareTo(curr) > 0){
                elements[j+1] = elements[j];
                j--;
            }
            elements[j+1] = curr;
        }
    }
}
