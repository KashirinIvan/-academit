package academit.kashirin;

import java.util.Scanner;

public class NumericRange {
    public static void main(String[] args) {
        Range range1 = new Range( 54.1, 654.45 );
        System.out.println( "Длина диапазона : " + range1.getLength() );

        System.out.print( "Введите число : " );
        Scanner scanner = new Scanner( System.in );
        double selectedNumber = scanner.nextInt();

        if (range1.isInside( selectedNumber )) {
            System.out.print( "Число входит в диапозон" );
        } else {
            System.out.print( "Число не входит в диапозон" );
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
}