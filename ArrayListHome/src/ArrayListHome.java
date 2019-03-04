import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome\\src\\file.txt"))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            System.out.println(list.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(10);
        list1.add(112);
        list1.add(3);
        list1.add(5);
        list1.add(16);

        for (int i = 0; i < list1.size(); i++) {
            Integer x = list1.get(i);
            if (x % 2 == 0) {
                list1.remove(i);
                i--;
            }
        }
        System.out.println(list1.toString());

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(10);
        list2.add(112);
        list2.add(1);
        list2.add(16);
        list2.add(5);
        list2.add(10);
        list2.add(16);
        list2.add(3);
        list2.add(10);

        ArrayList<Integer> list3 = new ArrayList<>();

        for (Integer element : list2) {
            boolean hasTest = list3.contains(element);
            if (!hasTest) {
                list3.add(element);
            }
        }
        System.out.println(list3.toString());
    }
}
