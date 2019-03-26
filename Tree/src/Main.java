import academit.kashirin.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.add(4);
        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(23);
        tree.add(3);
        tree.add(71);
        tree.add(16);
        tree.add(34);
        tree.add(13);
        tree.add(17);
        tree.add(37);

        System.out.println("Поиск элемента 34 в дереве: " + tree.search(34));
        System.out.println("Удаление элемента 1 : " + tree.remove(1));
        System.out.println("Удаление элемента 34 : " + tree.remove(34));
        System.out.println("Удаление элемента 16 : " + tree.remove(16));
        System.out.println("Число элементов в дереве: " + tree.getCount());
    }
}
