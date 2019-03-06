package academit.kashirin;

import academit.kashirin.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.setTop(6);
        list.setTop(5);
        list.setTop(1);
        list.setTop(2);
        list.invertList();
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));
        System.out.println("Значение по индексу 4 = " + list.getValueByIndex(4));
        System.out.println("Значение по индексу 1 = " + list.getTop());
        System.out.println("Старое значение по индексу 2 = " + list.updateValueByIndex(2, 10));
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));
        System.out.println("Значение по индексу 4 = " + list.getValueByIndex(4));
        System.out.println("Удаленное значение по индексу 2 = " + list.removeByIndex(2));
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));

        list.setValueByIndex(2, 9);
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));
        System.out.println("Значение по индексу 4 = " + list.getValueByIndex(4));
        if (list.removeNodeByValue(5)) {
            System.out.println("Элемент найден и удачен");
        } else {
            System.out.println("Элемент не найден и не удачен");
        }
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));
        System.out.println("Значение по индексу 4 = " + list.getValueByIndex(4));
        list.removeTop();
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(3));

        list.invertList();
        System.out.println("Разворот списка");
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.copy(list);
        System.out.println("Копирование списка");
        System.out.println("Размерность списка = " + list1.getListSize());
        System.out.println("Значение по индексу 1 = " + list1.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list1.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list1.getValueByIndex(3));

        list.setValueByIndex(2, 55);
        System.out.println("Значение по индексу 1 = " + list1.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list1.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list1.getValueByIndex(3));

        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));
    }
}
