import academit.kashirin.hashtable.MyHashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Первый");
        hashTable.add("Второй");
        hashTable.add("Третий");
        hashTable.add("Четверный");
        hashTable.add("Пятый");
        hashTable.add("Шестой");
        hashTable.add("Седьмой");
        hashTable.add("Восьмой");
        hashTable.add("Девятый");
        hashTable.add("Десятый");
        hashTable.add("Одиннадцатый");
        System.out.println("Количество элементов в таблице = " + hashTable.size());
        System.out.println("Проверка пустой ли список = " + hashTable.isEmpty());
        System.out.println("Проверка есть ли Первый = " + hashTable.contains("Первый"));
        System.out.println("Проверка есть ли Двенадцатый = " + hashTable.contains("Двенадцатый"));
        System.out.println(Arrays.toString(hashTable.toArray()));
        System.out.println("Удалить Третий = " + hashTable.remove("Третий"));
        System.out.println("Количество элементов в таблице = " + hashTable.size());
        System.out.println(Arrays.toString(hashTable.toArray()));

        for (String element : hashTable) {
            System.out.println(element);
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("Второй");
        list.add("Двенадцатый");
        list.add("Шестой");
        System.out.println("Входит ли list в hashTable = " + hashTable.containsAll(list));

        System.out.println("addAll = " + hashTable.addAll(list));
        System.out.println(Arrays.toString(hashTable.toArray()));

        System.out.println("removeAll = " + hashTable.removeAll(list));
         System.out.println(Arrays.toString(hashTable.toArray()));

        System.out.println("addAll = " + hashTable.addAll(list));
        System.out.println(Arrays.toString(hashTable.toArray()));

        System.out.println("retainAll = " + hashTable.retainAll(list));
        System.out.println(Arrays.toString(hashTable.toArray()));

        Object[] array = new Object[hashTable.size()+2];
        array = hashTable.toArray(array);
        System.out.println("Hash массив = " + Arrays.toString(array));

        System.out.println("clear");
        hashTable.clear();
        System.out.println(Arrays.toString(hashTable.toArray()));
    }
}
