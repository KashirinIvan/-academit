import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome\\src\\file.txt"))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            System.out.println(list.toString());

            for (int i = 0; i < list.size(); i++) {
                Integer x = Integer.valueOf(list.get(i));
                if (x % 2 == 0) {
                    list.remove(i);
                    i--;
                } else {
                    list.set(i, String.valueOf(x));
                }
            }
            System.out.println(list.toString());

            ArrayList<String> list1 = new ArrayList<>();
            Integer x = Integer.valueOf(list.get(0));
            list1.add(String.valueOf(x));

            for (int i = 1; i < list.size(); i++) {
                Integer y = Integer.valueOf(list.get(i));
                boolean isRepeat = true;
                for (int j = 0; j < list1.size(); j++) {
                    if (Integer.valueOf(list1.get(j)) == y) {
                        isRepeat= false;
                        break;
                    }
                }
                if (isRepeat){
                    list1.add(String.valueOf(y));
                }
            }
            System.out.println(list1.toString());
        }
    }
}
