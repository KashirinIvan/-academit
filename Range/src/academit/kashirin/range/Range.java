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

    public Range getIntervalIntersection(Range range) {
        if ((range.from >= to) || (range.to <= from)) {
            return null;
        } else {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }
    }

    public Range[] getIntervalUnion(Range range) {
        if ((range.from > to) || (range.to < from)) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }
    }

    public Range[] getIntervalDifference(Range range) {
        if ((range.from >= to) || (range.to <= from)) {
            return new Range[]{new Range(from, to)};
        } else if (from >= range.from) {
            if (to > range.to) {
                return new Range[]{new Range(range.to, to)};
            } else {
                return new Range[]{};
            }
        } else {
            if (to <= range.to) {
                return new Range[]{new Range(from, range.from)};
            } else {
                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            }
        }
    }
}