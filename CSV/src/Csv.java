import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Количество файлов не верное, нужно передать 2 файла : 1 файл .csv и 2 файл .html");
            return;
        }
        try (Scanner scanner = new Scanner(new FileInputStream(args[0]));
             PrintWriter writer = new PrintWriter(args[1])) {
            writer.print("<!DOCTYPE html><html><head><meta charset=\"utf-8\"/><title>CSV->HTML</title><style> table{border-collapse: collapse} td {border: 1px solid black;} </style></head><body><table><tr><td>");
            boolean isCell = false;
            while (scanner.hasNext()) {
                String stringInFile = scanner.nextLine();
                if (isCell) {
                    writer.print("<br/>");
                }
                for (int i = 0; i < stringInFile.length(); i++) {
                    if ((stringInFile.charAt(i) == '"' || isCell) && (i < stringInFile.length() - 1)) {
                        if (stringInFile.charAt(i) == '"' && !isCell) {
                            i++;
                        }
                        isCell = true;
                        if (stringInFile.charAt(i) == '"' && stringInFile.charAt(i + 1) == '"') {
                            writer.print('"');
                            i++;
                        } else if (stringInFile.charAt(i) == '"' && stringInFile.charAt(i + 1) == ',') {
                            writer.print("</td><td>");
                            i++;
                            isCell = false;
                        } else {
                            writer.print(replaceCharacter(stringInFile.charAt(i)));
                        }
                    } else if (stringInFile.charAt(i) == ',') {
                        writer.print("</td><td>");
                    } else if (stringInFile.charAt(i) == '"') {
                        writer.print("");
                    } else {
                        writer.print(replaceCharacter(stringInFile.charAt(i)));
                    }
                }
                if (!isCell) {
                    writer.print("</td></tr><tr><td>");
                }
            }
            writer.print("</td></tr></table></body></html>");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    private static String replaceCharacter(char x) {
        if (x == '<') {
            return "&lt;";
        } else if (x == '>') {
            return "&gt;";
        } else if (x == '&') {
            return "&amp;";
        } else {
            return String.valueOf(x);
        }

    }
}

