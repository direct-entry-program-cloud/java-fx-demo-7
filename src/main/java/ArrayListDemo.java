import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
/*

        */
/*Array Declaration and initializing*//*


        int[] numbers = new int[5];
        numbers[0] = 10;
        numbers[1] = 10;
        numbers[2] = 10;
        numbers[3] = 10;
        numbers[4] = 10;

        int[] numbers2 = new int[]{10,20,30,40,50};

        int[] num2;
        num2 = new int[]{10,20,30,40};

        int[] numbers3 = {10,20,30,40};

        */
/*int num3;
        num3 = {10,20,30};*//*


        int i =10;
        System.out.println(i);

        Integer j = 10;
        System.out.println(j);


        */
/*Boxing and Unboxing*//*


        //Auto-Boxing
        Integer a =10;

        //Auto-Unboxing
        int d = a;

        //Boxing
        Integer b = new Integer(10);
        Integer b2 = Integer.valueOf(10);

        //Unboxing
        int c= b.intValue();

        */
/*==============================================*//*


        long x =20;
        Long yy = 20L;
        //Long y = 20; //can;t do auto boxing. we can manually do boxing
        Long z = new Long(20);
        Long z1 = Long.valueOf(20);

        */
/*=============================================*//*


        byte n1 = 10; // due to constant expression (only for assignment context)
        byte n2 = 10+30;
        //byte n3 = 128; //out of range

        int n4 = 10;
        //short n5 =n4;
*/

        /*=========================================*/

        //Array
        int[] numberA = new int[4];
        numberA[0]=10;
        numberA[1]=20;
        numberA[2]=30;
        numberA[3]=40;

        for(int m=0; m<numberA.length; m++){
            System.out.println(numberA[m]);
        }

        for(int m : numberA){
            System.out.println(m);
        }

        System.out.println(Arrays.toString(numberA));

        numberA[0] = 100;
        System.out.println(Arrays.toString(numberA));


        //ArrayList
        ArrayList<Integer> numberB = new ArrayList<>();
        numberB.add(10); //append (add to tail)
        numberB.add(20);
        numberB.add(30);
        numberB.add(40);
        numberB.add(30);

        for(int m=0; m<numberB.size(); m++){
            System.out.println(numberB.get(m));
        }
        for(Integer m : numberB){
            System.out.println(m);
        }

        System.out.println(numberB); //[10, 20, 30, 40, 30]

        numberB.set(0,100);
        System.out.println(numberB); //[100, 20, 30, 40, 30]

        numberB.add(2,200);
        System.out.println(numberB); //[100, 20, 200, 30, 40, 30]

        numberB.add(0,300); //prepend [300, 100, 20, 200, 30, 40, 30]
        System.out.println(numberB);

        numberB.remove(2);
        System.out.println(numberB); //[300, 100, 200, 30, 40, 30]

        numberB.remove(Integer.valueOf(30));
        //numberB.remove(new Integer(30));
        System.out.println(numberB); //[300, 100, 200, 40, 30]

        System.out.println(numberB.contains(20));
        System.out.println(numberB.contains(10));

        numberB.forEach(System.out::println);

        numberB.clear();
        System.out.println(numberB);


    }
}
