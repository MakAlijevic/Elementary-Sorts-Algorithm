package ibu.edu;

public class ShellSort {

    public static void sort(Comparable[] elements){

        int h = 1;

        //Define gap
        while(h < elements.length/3){
            h = h*3 + 1;
        }
        while(h>=1){

            for(int i = h ; i < elements.length ; i++){

                //Compare and swap elements
                for(int j = i; j >= h && elements[j].compareTo(elements[j-h]) < 0 ; j -= h){
                    Comparable temp = elements[j];
                    elements[j] = elements[j-h];
                    elements[j-h] = temp;
                }
            }
            //Decrease gap
            h = h/3;
        }
    }
}
