package academit.kashirin;

import academit.kashirin.list.SinglyLinkedList;

public class Main {
    public static void main(String [] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.setTop(6);
        list.setTop(5);
        list.setTop(1);
        list.setTop(2);
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));
        System.out.println("Значение по индексу 4 = " + list.getValueByIndex(4));
        System.out.println("Значение по индексу 1 = " + list.getTop());
        list.setValueByIndex(2,10);
        System.out.println("Размерность списка = " + list.getListSize());
        System.out.println("Значение по индексу 1 = " + list.getValueByIndex(1));
        System.out.println("Значение по индексу 2 = " + list.getValueByIndex(2));
        System.out.println("Значение по индексу 3 = " + list.getValueByIndex(3));
        System.out.println("Значение по индексу 4 = " + list.getValueByIndex(4));
        System.out.println("Значение по индексу 5 = " + list.getValueByIndex(5));
    }
}
