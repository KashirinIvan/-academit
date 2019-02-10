package academit.kashirin.shape.square;

import academit.kashirin.shape.Shape;

public class Square extends Shape {
    private double width;

    public Square(double width) {
        super(width, width);
    }

    public double getArea() {
        return width * width;
    }

    public double getPerimeter() {
        return 2 * (width + width);
    }
}
