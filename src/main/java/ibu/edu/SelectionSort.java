package ibu.edu;

public class SelectionSort {

    static boolean swapped = false;

    public static void sort(Comparable[] elements){

        Comparable temp;

        for(int i = 0;i< (elements.length-1);i++){

            int min = i;

            for(int j = i+1;j<elements.length;j++){
                if(elements[j].compareTo(elements[min])<0){
                    min = j;
                }
            }
            if(elements[i] != elements[min]) {
                temp = elements[i];
                elements[i] = elements[min];
                elements[min] = temp;
                swapped = true;
            }
            if(swapped == false) {
                break;
            }
        }
    }
}
