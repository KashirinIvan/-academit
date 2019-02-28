import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        String stringInFile = new String();
        String stringOutFile = new String();
        try (Scanner scanner = new Scanner(new FileInputStream("CSV\\src\\file_csv.csv"));
             PrintWriter writer = new PrintWriter("CSV\\src\\index.html")) {
            stringOutFile="<!DOCTYPE html><html><head><meta charset=\"utf-8\"/><title>CSV->HTML</title><table><style> table{border-collapse: collapse} td {border: 1px solid black;} </style></head>";
            stringOutFile+="<table><tr><td>";

            while (scanner.hasNext()) {
                stringInFile=(scanner.nextLine());


            }
            stringOutFile+="</td></tr></table>";
            writer.println(stringOutFile);
        }
    }
}

