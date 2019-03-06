import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) {
        if (args.length == 2) {
            try (Scanner scanner = new Scanner(new FileInputStream(args[0]));
                 PrintWriter writer = new PrintWriter(args[1])) {
                writer.print("<!DOCTYPE html><html><head><meta charset=\"utf-8\"/><title>CSV->HTML</title><style> table{border-collapse: collapse} td {border: 1px solid black;} </style></head><body><table><tr><td>");

                while (scanner.hasNext()) {
                    String stringInFile = scanner.nextLine();
                    boolean isCell = false;
                    int isLineBreak = 1;
                    for (int i = 0; i < stringInFile.length(); i++) {
                        if (stringInFile.charAt(i) == '"' || isCell) {
                            isCell = true;
                            isLineBreak = 2;
                            if (stringInFile.charAt(i + 1) == '"' && stringInFile.charAt(i + 2) == '"') {
                                writer.print(" \"");
                                i += 2;
                            } else if (stringInFile.charAt(i) == '"' && stringInFile.charAt(i + 1) == ',') {
                                writer.print("</td><td>");
                                i++;
                                isCell = false;
                                isLineBreak = 1;
                            } else if (stringInFile.charAt(i) == '"') {
                                writer.print("");
                            } else {
                                writer.print(processingCharacter(stringInFile.charAt(i)));
                            }
                            if (i == stringInFile.length() - 2) {
                                isLineBreak = 3;
                                break;
                            }
                        } else if (stringInFile.charAt(i) == ',') {
                            writer.print("</td><td>");
                        } else {
                            writer.print(processingCharacter(stringInFile.charAt(i)));
                        }
                    }
                    if (isLineBreak == 2) {
                        writer.print("<br/>");
                    } else if (isLineBreak == 1) {
                        writer.print("</td></tr><tr><td>");
                    } else if (isLineBreak == 3){
                        writer.print("");
                    }
                }
                writer.print("</td></tr></table></body></html>");
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }
        } else {
            System.out.println("Количество файлов не верное");
        }
    }

    private static String processingCharacter(char x) {
        if (x == '<') {
            return ("&lt;");
        } else if (x == '>') {
            return ("&gt;");
        } else if (x == '&') {
            return ("&amp;");
        } else {
            return String.valueOf(x);
        }
    }
}

