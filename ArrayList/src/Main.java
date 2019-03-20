import academit.kashirin.arraylist.MyArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(34);
        myArrayList.add(3);
        System.out.println("Размерность листа = " + myArrayList.size());
        System.out.println("Лист = " + myArrayList.toString());

        System.out.println("На место индекса 1 установлено значение 10, а старое значение = " + myArrayList.set(1, 10));
        System.out.println("Лист = " + myArrayList.toString());

        System.out.println("Элемент с индексом 1 = " + myArrayList.get(1));

        System.out.println("Удаленный элемент с индексом 0 = " + myArrayList.remove(0));
        System.out.println("Размерность листа = " + myArrayList.size());

        System.out.println("На место индекса 1 добавлено значение 65");
        myArrayList.add(1, 65);
        System.out.println("На место индекса 2 добавлено значение 64");
        myArrayList.add(2, 64);
        System.out.println("Лист = " + myArrayList.toString());

        System.out.println("Нахождение значения 65 в листе: " + myArrayList.contains(65));

        System.out.println("Получение массива : " + Arrays.toString(myArrayList.toArray()));

        System.out.println("Добавление 64 в конец листа");
        myArrayList.add(64);
        System.out.println("Лист = " + myArrayList.toString());
        System.out.println("Индекс первого вхождения 64 = " + myArrayList.indexOf(64));
        System.out.println("Индекс последнего вхождения 64 = " + myArrayList.lastIndexOf(64));

        System.out.println("Элемент 64 удален  = " + myArrayList.remove(Integer.valueOf(64)));
        System.out.println("Лист = " + Arrays.toString(myArrayList.toArray()));

        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        myArrayList1.add(70);
        myArrayList1.add(36);
        System.out.println("Входит ли лист1 в лист : " + myArrayList.containsAll(myArrayList1));
        System.out.println("Добавление лист1 в лист в конец");
        myArrayList.addAll(myArrayList1);
        System.out.println("Лист = " + Arrays.toString(myArrayList.toArray()));
        System.out.println("Добавление лист1 в лист по индексу 1");
        myArrayList.addAll(1, myArrayList1);
        System.out.println("Лист = " + Arrays.toString(myArrayList.toArray()));
        System.out.println("Удаление лист1 из лист = " + myArrayList.removeAll(myArrayList1));
        System.out.println("Лист = " + Arrays.toString(myArrayList.toArray()));
        System.out.println("Добавление лист1 в лист в конец");
        myArrayList.addAll(myArrayList1);
        myArrayList.add(43);
        System.out.println("Лист = " + Arrays.toString(myArrayList.toArray()));
        System.out.println("Лист1 = " + Arrays.toString(myArrayList1.toArray()));
        System.out.println("Удаление элементов из листа не принадлежащих лист1 = " + myArrayList.retainAll(myArrayList1));
        System.out.println("Лист = " + Arrays.toString(myArrayList.toArray()));


        Integer[] array = new Integer[myArrayList.size()];
        array= myArrayList.toArray(array);
        System.out.println("Лист = " + Arrays.toString(array));
    }
}
