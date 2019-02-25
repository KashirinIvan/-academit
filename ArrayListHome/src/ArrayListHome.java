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
                if (x % 2 == 0){
                    list.remove(i);
                }else{
                    list.set(i,String.valueOf(x));
                }
            }
            System.out.println(list.toString());



        }
    }
}
