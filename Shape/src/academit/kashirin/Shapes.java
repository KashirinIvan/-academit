package academit.kashirin;

import academit.kashirin.comparator.AreaComparator;
import academit.kashirin.comparator.PerimeterComparator;
import academit.kashirin.shape.Shape;
import academit.kashirin.shape.Circle;
import academit.kashirin.shape.Rectangle;
import academit.kashirin.shape.Square;
import academit.kashirin.shape.Triangle;

import java.util.Arrays;

public class Shapes {
    public static void main(String[] args) {
        Square s1 = new Square(5.5);
        Triangle s2 = new Triangle(1.1, 1.4, 3.2, 5.6, 5.4, 3.9);
        Rectangle s3 = new Rectangle(5.1, 4.9);
        Circle s4 = new Circle(4.7);
        Square s5 = new Square(2.5);
        Triangle s6 = new Triangle(2.1, 2.4, 4.9, 5.6, 5.4, 1.9);
        Rectangle s7 = new Rectangle(2.1, 3.9);
        Circle s8 = new Circle(3.7);

        Shape[] shapes = new Shape[]{s1, s2, s3, s4, s5, s6, s7, s8};

        System.out.println("Фигура с максимальной площадью: " + getShapeMaxArea(shapes));
        System.out.println("Фигура со вторым по величине периметром: " + getShapeSecondPerimeter(shapes));
    }

    public static Shape getShapeMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());
        return shapes[shapes.length - 1];
    }

    public static Shape getShapeSecondPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[shapes.length - 2];
    }
}
