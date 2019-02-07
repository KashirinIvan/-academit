package academit.kashirin;

import java.util.Scanner;

public class NumericRange {
    public static void main(String[] args) {
        Range range1 = new Range(54.1, 654.45);
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

        Range range2 = new Range(10, 900);
        if (range1.getIntervalIntersection(range2) == null) {
            System.out.println("Диапазон пересечения " + null);
        } else {
            System.out.println("Диапазон пересечения " + range1.getIntervalIntersection(range2).getFrom() + " " + range1.getIntervalIntersection(range2).getTo());
        }

        for (int i = 0; i < range1.getIntervalUnion(range2).length; i++) {
            System.out.println("Диапазон объединеный " + range1.getIntervalUnion(range2)[i].getFrom() + " " + range1.getIntervalUnion(range2)[i].getTo());
        }

        if (range1.getIntervalDifference(range2) == null) {
            System.out.println("Диапазон разности " + null);
        } else {
            for (int i = 0; i < range1.getIntervalDifference(range2).length; i++) {
                System.out.println("Диапазон разности " + range1.getIntervalDifference(range2)[i].getFrom() + " " + range1.getIntervalDifference(range2)[i].getTo());
            }
        }
    }
}

class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    double getLength() {
        return to - from;
    }

    boolean isInside(double selectedNumber) {
        return selectedNumber >= from && selectedNumber <= to;
    }

    public Range getIntervalIntersection(Range range2) {
        if ((range2.from > to) || (range2.to < from)) {
            return null;
        } else {
            return new Range(Math.max(from, range2.from), Math.min(to, range2.to));
        }
    }

    public Range[] getIntervalUnion(Range range2) {
        if ((range2.from > to) || (range2.to < from)) {
            return new Range[]{new Range(from, to), new Range(range2.from, range2.to)};
        } else {
            return new Range[]{new Range(Math.min(from, range2.from), Math.max(to, range2.to))};
        }
    }

    public Range[] getIntervalDifference(Range range2) {
        if ((range2.from > to) || (range2.to < from)) {
            return new Range[]{new Range(from, to)};
        } else if (from > range2.from) {
            if (to > range2.to) {
                return new Range[]{new Range(range2.to, to)};
            } else {
                return null;
            }
        } else {
            if (to <= range2.to) {
                return new Range[]{new Range(from, range2.from)};
            } else {
                return new Range[]{new Range(from, range2.from), new Range(range2.to, to)};
            }
        }
    }
}