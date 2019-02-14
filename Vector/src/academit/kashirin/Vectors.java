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

        System.out.println(vec1.getSize());
        System.out.println(vec3.getSize());
        System.out.println(vec5.getSize());

        vec3.sum(vec5);
        System.out.println(vec3.toString());

        vec4.difference(vec5);
        System.out.println(vec4.toString());

        vec5.multiplication(2);
        System.out.println(vec5.toString());

        vec5.reversal();
        System.out.println(vec5.toString());

        System.out.println(vec5.length());

        System.out.println(vec5.getComponent(4));

        vec5.setComponent(0, 55);
        System.out.println(vec5.toString());

        System.out.println(vec1.equals(vec3));

        Vector vec6 = Vector.sumVector(vec5, vec3);
        System.out.println(vec6.toString());

        Vector vec7 = Vector.differenceVector(vec5, vec3);
        System.out.println(vec7.toString());

        Vector vec8 = Vector.multiplicationVector(vec7, 5);
        System.out.println(vec8.toString());
    }
}
