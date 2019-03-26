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
        TreeNode<T> currentNode = root;
        int tempCount = count;
        while (tempCount == count) {
            if (data.hashCode() < currentNode.getData().hashCode()) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode.setLeft(new TreeNode<>(data, null, null));
                    count++;
                }
            } else {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();

                } else {
                    currentNode.setRight(new TreeNode<>(data, null, null));
                    count++;
                }
            }
        }
    }

    public boolean search(T data) {
        TreeNode<T> currentNode = root;
        while (count != 0) {
            if (data.hashCode() == currentNode.getData().hashCode()) {
                break;
            }
            if (data.hashCode() < currentNode.getData().hashCode()) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    return false;
                }
            } else {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean remove(T data) {
        TreeNode<T> currentNode = root;
        TreeNode<T> prevNode = null;
        while (count != 0) {
            if (data.hashCode() == currentNode.getData().hashCode()) {
                if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                    if (prevNode.getLeft() == currentNode) {
                        prevNode.setLeft(null);
                    } else {
                        prevNode.setRight(null);
                    }
                    break;
                } else if (currentNode.getLeft() == null || currentNode.getRight() == null) {
                    if (prevNode.getLeft() == currentNode) {
                        if (currentNode.getLeft() != null) {
                            prevNode.setLeft(currentNode.getLeft());
                        } else {
                            prevNode.setLeft(currentNode.getRight());
                        }
                    } else {
                        if (currentNode.getLeft() != null) {
                            prevNode.setRight(currentNode.getLeft());
                        } else {
                            prevNode.setRight(currentNode.getRight());
                        }
                    }
                    break;
                } else {

                    break;
                }
            }
            if (data.hashCode() < currentNode.getData().hashCode()) {
                if (currentNode.getLeft() != null) {
                    prevNode = currentNode;
                    currentNode = currentNode.getLeft();
                } else {
                    return false;
                }
            } else {
                if (currentNode.getRight() != null) {
                    prevNode = currentNode;
                    currentNode = currentNode.getRight();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
