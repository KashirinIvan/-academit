package academit.kashirin.range;

public class Range {
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

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double selectedNumber) {
        return selectedNumber >= from && selectedNumber <= to;
    }

    public Range getIntervalIntersection(Range range2) {
        if ((range2.from >= to) || (range2.to <= from)) {
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
        if ((range2.from >= to) || (range2.to <= from)) {
            return new Range[]{new Range(from, to)};
        } else if (from >= range2.from) {
            if (to >= range2.to) {
                return new Range[]{new Range(range2.to, to)};
            } else {
                return new Range[]{};
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