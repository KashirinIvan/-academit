import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder stringInFile = new StringBuilder();
        StringBuilder stringOutFile = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileInputStream("CSV\\src\\file_csv.csv"));
             PrintWriter writer = new PrintWriter("CSV\\src\\index.html")) {

            stringInFile.append("<table>");
            stringInFile.append("<style> table { border-collapse: collapse} td {border: 1px solid black;}  </style>");
            stringInFile.append("<tr>");
            stringInFile.append("<td >");
            while (scanner.hasNext()) {
                stringInFile.append(scanner.nextLine());
                stringInFile.append("<br/>");
            }
            boolean isCell = false;
            for (int i = 0; i < stringInFile.length(); i++) {
                if (stringInFile.charAt(i) == '"' || isCell ) {
                    isCell = true;
                    if (stringInFile.charAt(i + 1) == '"' && stringInFile.charAt(i + 2) == '"') {
                        stringOutFile.append('"');
                        i += 2;
                    } else if (stringInFile.charAt(i) == '"' && stringInFile.charAt(i + 1) == ',') {
                        stringOutFile.append("</td><td>");
                        i++;
                        isCell = false;
                    } else if (stringInFile.charAt(i) == '"') {
                        stringOutFile.append(" ");
                    } else {
                        stringOutFile.append(stringInFile.charAt(i));
                    }
                    if (i == stringInFile.length() - 2) {
                        isCell = false;
                    }
                } else if (stringInFile.charAt(i) == ',') {
                    stringOutFile.append("</td><td>");
                } else if (stringInFile.charAt(i) == '<' && stringInFile.charAt(i + 1) == 'b' && stringInFile.charAt(i + 2) == 'r' && stringInFile.charAt(i + 3) == '/' && stringInFile.charAt(i + 4) == '>') {
                    stringOutFile.append("</td></tr><tr><td>");
                    i += 4;
                } else {
                    stringOutFile.append(stringInFile.charAt(i));
                }
            }
            stringOutFile.append("</td>");
            stringOutFile.append("</tr>");
            stringOutFile.append("</table>");
            writer.println(stringOutFile);
        }
    }
}

