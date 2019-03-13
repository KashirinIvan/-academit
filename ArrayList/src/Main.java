import academit.kashirin.arraylist.MyArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(34);
        myArrayList.add(3);
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.toString());

        myArrayList.set(1, 10);
        System.out.println(myArrayList.toString());

        System.out.println("Элемент с индексом 1 = " + myArrayList.get(1));

        System.out.println("Удаленный элемент с индексом 0 = " + myArrayList.remove(0));
        System.out.println(myArrayList.size());

        myArrayList.add(1, 65);
        myArrayList.add(2, 64);
        System.out.println(myArrayList.toString());

        System.out.println(myArrayList.contains(65));

        System.out.println(Arrays.toString(myArrayList.toArray()));

        Iterator<Integer> iterator = myArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        myArrayList.add(64);
        System.out.println(myArrayList.toString());
        System.out.println("Индекс первого вхождения 64 = " + myArrayList.indexOf(64));
        System.out.println("Индекс последнего вхождения 64 = " + myArrayList.lastIndexOf(64));

        System.out.printf("Элемент 64 удален  = %s%n", myArrayList.remove(new Integer(64)));
        System.out.println(Arrays.toString(myArrayList.toArray()));

        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        myArrayList1.add(70);
        myArrayList1.add(36);
        System.out.println(myArrayList.containsAll(myArrayList1));

        myArrayList.addAll(myArrayList1);
        System.out.println(Arrays.toString(myArrayList.toArray()));

        myArrayList.addAll(1,myArrayList1);
        System.out.println(Arrays.toString(myArrayList.toArray()));
    }
}
