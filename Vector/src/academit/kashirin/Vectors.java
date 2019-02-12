package academit.kashirin;

import academit.kashirin.vector.Vector;

public class Vectors {
    public static void main(String[] args) {
        Vector vec1 = new Vector(5);
        Vector vec2 = new Vector(vec1);
        Vector vec3 = new Vector(new double[]{1.5, 5, 54, 87, 4.7, 5.2});
        Vector vec4 = new Vector(vec3);
        Vector vec5 = new Vector(9, new double[]{5.4, 5, 2.6, 4, 8.2});

        System.out.println(vec1.toString());
        System.out.println(vec2.toString());
        System.out.println(vec3.toString());
        System.out.println(vec4.toString());
        System.out.println(vec5.toString());
    }
}
