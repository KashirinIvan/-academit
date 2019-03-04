import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) {
        String stringOutFile;
        try (Scanner scanner = new Scanner(new FileInputStream(args[0]));
             PrintWriter writer = new PrintWriter(args[1])) {
            stringOutFile = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"/><title>CSV->HTML</title><style> table{border-collapse: collapse} td {border: 1px solid black;} </style></head>";
            stringOutFile += "<table><tr><td>";

            while (scanner.hasNext()) {
                String stringInFile = scanner.nextLine();
                boolean isCell = false;
                boolean isFlag = false;
                for (int i = 0; i < stringInFile.length(); i++) {
                    if (stringInFile.charAt(i) == '"' || isCell) {
                        isCell = true;
                        isFlag = true;
                        if (stringInFile.charAt(i + 1) == '"' && stringInFile.charAt(i + 2) == '"') {
                            stringOutFile += ('"');
                            i += 2;
                        } else if (stringInFile.charAt(i) == '"' && stringInFile.charAt(i + 1) == ',') {
                            stringOutFile += ("</td><td>");
                            i++;
                            isCell = false;
                            isFlag = false;
                        } else if (stringInFile.charAt(i) == '"') {
                            stringOutFile += ("");
                        } else if (stringInFile.charAt(i) == '<') {
                            stringOutFile += ("&lt");
                        } else if (stringInFile.charAt(i) == '>') {
                            stringOutFile += ("&gt");
                        } else if (stringInFile.charAt(i) == '&') {
                            stringOutFile += ("&amp");
                        } else {
                            stringOutFile += (stringInFile.charAt(i));
                        }
                        if (i == stringInFile.length() - 2) {
                            break;
                        }
                    } else if (stringInFile.charAt(i) == ',') {
                        stringOutFile += ("</td><td>");
                    } else if (stringInFile.charAt(i) == '<') {
                        stringOutFile += ("&lt");
                    }else if (stringInFile.charAt(i) == '>') {
                        stringOutFile += ("&gt");
                    }else if (stringInFile.charAt(i) == '&') {
                        stringOutFile += ("&amp");
                    }else {
                        stringOutFile += (stringInFile.charAt(i));
                    }
                }
                if (isFlag) {
                    stringOutFile += ("<br/>");
                } else {
                    stringOutFile += ("</td></tr><tr><td>");
                }
            }
            stringOutFile += "</td></tr></table>";
            writer.println(stringOutFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}

