import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        String stringInFile = "";
        String stringOutFile = "";
        try (Scanner scanner = new Scanner(new FileInputStream("CSV\\src\\file_csv.csv"));
             PrintWriter writer = new PrintWriter("CSV\\src\\index.html")) {
            stringInFile += "<table border=\"1\">";
            stringInFile += "<tr>";
            stringInFile += "<td>";
            while (scanner.hasNext()) {
                stringInFile += scanner.nextLine();
                char[] simbol = new char[stringInFile.length()];
                for (int i = 0; i < stringInFile.length(); i++) {
                    simbol[i] = stringInFile.charAt(i);
                }
                for (int i = 0; i < stringInFile.length(); i++) {
                    if (simbol[i] == ',') {
                        stringOutFile += "</td><td>";
                    } else if (simbol[i] == '"') {
                        stringOutFile += "";
                    } else {
                        stringOutFile += simbol[i];
                    }
                }
                stringOutFile += "<br/>";
            }
            stringOutFile += "</td>";
            stringOutFile += "</tr>";
            stringOutFile += "</table>";
            writer.println(stringOutFile);
        }
    }
}