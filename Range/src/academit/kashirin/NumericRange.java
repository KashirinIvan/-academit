package academit.kashirin;

import java.util.Scanner;

import academit.kashirin.range.Range;

public class NumericRange {
    public static void main(String[] args) {
        Range range1 = new Range(69, 901);
        System.out.println("Длина диапазона : " + range1.getLength());

        System.out.print("Введите число : ");
        Scanner scanner = new Scanner(System.in);
        double selectedNumber = scanner.nextInt();

        if (range1.isInside(selectedNumber)) {
            System.out.println("Число входит в диапозон");
        } else {
            System.out.println("Число не входит в диапозон");
        }

        System.out.println("Длинна диапазона = " + range1.getLength());

        Range range = new Range(70, 900);
        if (range1.getIntervalIntersection(range) == null) {
            System.out.println("Диапазон пересечения " + null);
        } else {
            System.out.println("Диапазон пересечения " + range1.getIntervalIntersection(range).getFrom() + " " + range1.getIntervalIntersection(range).getTo());
        }

        for (int i = 0; i < range1.getIntervalUnion(range).length; i++) {
            System.out.println("Диапазон объединеный " + range1.getIntervalUnion(range)[i].getFrom() + " " + range1.getIntervalUnion(range)[i].getTo());
        }

        for (int i = 0; i < range1.getIntervalDifference(range).length; i++) {
            System.out.println("Диапазон разности " + range1.getIntervalDifference(range)[i].getFrom() + " " + range1.getIntervalDifference(range)[i].getTo());
        }
    }
}

