import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> number1 = new ArrayList<>();
        number1.add(10);
        number1.add(20);
        number1.add(80);
        number1.add(40);

        //sort ArrayList
        System.out.println(number1);
        Collections.sort(number1);
        System.out.println(number1);

        // add one arraylist to another arrayList
        ArrayList<Integer> number2 = new ArrayList<>();
        number2.add(50);
        number2.add(20);
        number2.add(80);
        number2.add(10);

        /*for(Integer i: number2){
            number1.add(i);
        }
        System.out.println(number1);*/

        number1.addAll(number2); // should be same data type in both ArrayList
        System.out.println(number1);


        // binary search in arrayList
        int i = Collections.binarySearch(number1,20);
        System.out.println(i);

        //ArrayList<Integer> numbers = (ArrayList<Integer>)Arrays.asList(10,30,50,20);

    }
}
