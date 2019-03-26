package academit.kashirin.tree;

public class Tree<T> {
    private TreeNode<T> root;
    private int count;

    public Tree() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void add(T data) {
        if (root == null) {
            root = new TreeNode<>(data, null, null);
            count++;
            return;
        }
    }
}
