package academit.kashirin;

import academit.kashirin.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(1);
        list.addFirst(2);

        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));
        System.out.println("Значение по индексу 3 = " + list.getValue(3));

        System.out.println("Значение по индексу 0 = " + list.getHead());
        System.out.println("Старое значение по индексу 2 = " + list.setValue(2, 10));
        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));
        System.out.println("Значение по индексу 3 = " + list.getValue(3));
        System.out.println("Удаленное значение по индексу 0 = " + list.remove(0));
        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));

        list.insertAt(2, 9);
        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));
        System.out.println("Значение по индексу 3 = " + list.getValue(3));
        if (list.removeNode(1)) {
            System.out.println("Элемент найден и удачен");
        } else {
            System.out.println("Элемент не найден и не удачен");
        }
        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));

        list.removeTop();
        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));

        list.invert();
        System.out.println("Разворот списка");
        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));

        list.addFirst(65);
        SinglyLinkedList<Integer> list1;
        list1 = list.copy();
        System.out.println("Копирование списка");
        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Размерность списка = " + list1.getSize());
        System.out.println("Значение по индексу 0 = " + list1.getValue(0));
        System.out.println("Значение по индексу 1 = " + list1.getValue(1));
        System.out.println("Значение по индексу 2 = " + list1.getValue(2));


        list.insertAt(0, 55);
        list.insertAt(3, 52);
        list.insertAt(1, 30);
        System.out.println("Размерность списка = " + list.getSize());
        System.out.println("Значение по индексу 0 = " + list1.getValue(0));
        System.out.println("Значение по индексу 1 = " + list1.getValue(1));
        System.out.println("Значение по индексу 2 = " + list1.getValue(2));

        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));
        System.out.println("Значение по индексу 3 = " + list.getValue(3));
        System.out.println("Значение по индексу 4 = " + list.getValue(4));
    }
}
