import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        String stringOutFile = new String();
        try (Scanner scanner = new Scanner(new FileInputStream("CSV\\src\\file_csv.csv"));
             PrintWriter writer = new PrintWriter("CSV\\src\\index.html")) {
            stringOutFile = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"/><title>CSV->HTML</title><table><style> table{border-collapse: collapse} td {border: 1px solid black;} </style></head>";
            stringOutFile += "<table><tr><td>";

            while (scanner.hasNext()) {
                String stringInFile = new String(scanner.nextLine());
                boolean isCell = false;
                for (int i = 0; i < stringInFile.length(); i++) {
                    if (stringInFile.charAt(i) == '"' || isCell) {
                        isCell = true;
                        if (stringInFile.charAt(i + 1) == '"' && stringInFile.charAt(i + 2) == '"') {
                            stringOutFile += ('"');
                            i += 2;
                        } else if (stringInFile.charAt(i) == '"' && stringInFile.charAt(i + 1) == ',') {
                            stringOutFile += ("</td><td>");
                            i++;
                            isCell = false;
                        } else if (stringInFile.charAt(i) == '"') {
                            stringOutFile += ("");
                        } else {
                            stringOutFile += (stringInFile.charAt(i));
                        }
                        if (i == stringInFile.length() - 2) {
                            isCell = false;
                        }
                    } else if (stringInFile.charAt(i) == ',') {
                        stringOutFile += ("</td><td>");
                    } else if (stringInFile.charAt(i) == '<' && stringInFile.charAt(i + 1) == 'b' && stringInFile.charAt(i + 2) == 'r' && stringInFile.charAt(i + 3) == '/' && stringInFile.charAt(i + 4) == '>') {
                        stringOutFile += ("</td></tr><tr><td>");
                        i += 4;
                    } else {
                        stringOutFile += (stringInFile.charAt(i));
                    }
                }
                stringOutFile += ("</td></tr><tr><td>");
            }

            stringOutFile += "</td></tr></table>";
            writer.println(stringOutFile);
        }
    }
}

