import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        String stringInFile = "";
        String stringOutFile = "";
        try (Scanner scanner = new Scanner(new FileInputStream("CSV\\src\\file_csv.csv"));
             PrintWriter writer = new PrintWriter("CSV\\src\\index.html")) {

            stringInFile += "<table border=1>";
            stringInFile += "<tr>";
            stringInFile += "<td>";
            while (scanner.hasNext()) {
                stringInFile += scanner.nextLine();
                stringInFile += "<br/>";
            }
            for (int i = 0; i < stringInFile.length(); i++) {
                if (stringInFile.charAt(i) == '"') {
                    while ((stringInFile.charAt(i - 1) != '"' && stringInFile.charAt(i) == '"' && stringInFile.charAt(i + 1) != '"') != false) {
                        i++;
                        stringOutFile += stringInFile.charAt(i);
                    }

            }else if (stringInFile.charAt(i) == ',') {
                stringOutFile += "</td><td>";
            } else {
                stringOutFile += stringInFile.charAt(i);
            }
        }

        stringOutFile += "</td>";
        stringOutFile += "</tr>";
        stringOutFile += "</table>";
        writer.println(stringOutFile);
    }
}
}

