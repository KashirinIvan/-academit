package academit.kashirin;

import academit.kashirin.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.setHead(6);
        list.setHead(5);
        list.setHead(1);
        list.setHead(2);

        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));
        System.out.println("Значение по индексу 3 = " + list.getValue(3));

        System.out.println("Значение по индексу 0 = " + list.getHead());
        System.out.println("Старое значение по индексу 2 = " + list.setValue(2, 10));
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));
        System.out.println("Значение по индексу 3 = " + list.getValue(3));
        System.out.println("Удаленное значение по индексу 2 = " + list.remove(3));
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));

        list.insertAt(2, 9);
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));
        System.out.println("Значение по индексу 3 = " + list.getValue(3));
        if (list.removeNode(9)) {
            System.out.println("Элемент найден и удачен");
        } else {
            System.out.println("Элемент не найден и не удачен");
        }
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));

        list.removeTop();
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));

        list.invertList();
        System.out.println("Разворот списка");
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));

        list.setHead(65);
        SinglyLinkedList<Integer> list1;
        list1 = list.copy();
        System.out.println("Копирование списка");
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Размерность списка = " + list1.getListSize());
        System.out.println("Значение по индексу 0 = " + list1.getValue(0));
        System.out.println("Значение по индексу 1 = " + list1.getValue(1));
        System.out.println("Значение по индексу 2 = " + list1.getValue(2));

        System.out.println("Размерность списка = " + list.getListSize());
        list.insertAt(0, 55);
        System.out.println("Размерность списка = " + list.getListSize());
        list.insertAt(3, 52);
        System.out.println("Размерность списка = " + list.getListSize());
        list.insertAt(1, 30);
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 0 = " + list1.getValue(0));
        System.out.println("Значение по индексу 1 = " + list1.getValue(1));

        System.out.println("Значение по индексу 0 = " + list.getValue(0));
        System.out.println("Значение по индексу 1 = " + list.getValue(1));
        System.out.println("Значение по индексу 2 = " + list.getValue(2));
        System.out.println("Значение по индексу 3 = " + list.getValue(3));
        System.out.println("Значение по индексу 4 = " + list.getValue(4));
    }
}
