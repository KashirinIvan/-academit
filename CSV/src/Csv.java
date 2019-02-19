import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        String stringInFile = "";
        try (Scanner scanner = new Scanner(new FileInputStream("CSV\\src\\file_csv.csv"));
             PrintWriter writer = new PrintWriter("CSV\\src\\index.html")) {
            stringInFile += "<table>";
            stringInFile += "<tr>";
            stringInFile += "<td>";
            while (scanner.hasNext()) {
                stringInFile += scanner.nextLine();
                stringInFile += System.lineSeparator();

            }

            for(int i=0;i<stringInFile.length();i++)
            {
                char simbol=stringInFile.charAt(i);

            }
            stringInFile += " ";
            stringInFile = stringInFile.replace(",", "</td><td>");
            //stringInFile = stringInFile.replace("\r\n", "</td><td>");
            //stringInFile = stringInFile.replace(",", "</td><td>");


            stringInFile += "</td>";
            stringInFile += "</tr>";
            stringInFile += "</table>";

            writer.println(stringInFile);

        }
    }
}
