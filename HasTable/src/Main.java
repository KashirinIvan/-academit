import academit.kashirin.hastable.MyHashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
        System.out.println("Удалить Первый = " + hashTable.remove("Третий"));
        System.out.println("Количество элементов в таблице = " + hashTable.size());
        System.out.println(Arrays.toString(hashTable.toArray()));

       /* Iterator<String> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        ArrayList<String> list = new ArrayList();
        list.add("Второй");
        list.add("Шестой");
        System.out.println("Входит ли list в hashTable = " + hashTable.containsAll(list));
        System.out.println(hashTable.toString());
    }
}
