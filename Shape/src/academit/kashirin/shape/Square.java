package academit.kashirin.shape;

public class Square implements Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return width;
    }

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + width);
    }

    @Override
    public String toString() {
        return "Квадрат площадь = " + getArea() + " периметр = " + getPerimeter() + " ширина = " + getWidth();
    }

    @Override
    public int hashCode() {
        return Double.hashCode(width);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Square p = (Square) o;
        return width == p.width;
    }
}
