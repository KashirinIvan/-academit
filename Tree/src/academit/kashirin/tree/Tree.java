package academit.kashirin.tree;

import java.util.Stack;

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
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode<T> currentNode = stack.pop();
            if (data.hashCode() < currentNode.getData().hashCode()) {
                if (currentNode.getLeft() != null) {
                    stack.push(currentNode.getLeft());
                } else {
                    currentNode.setLeft(new TreeNode<>(data, null, null));
                    count++;
                }
            } else {
                if (currentNode.getRight() != null) {
                    stack.push(currentNode.getRight());

                } else {
                    currentNode.setRight(new TreeNode<>(data, null, null));
                    count++;
                }
            }
        }
    }

    public boolean search(T data) {
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode<T> currentNode = stack.pop();
            if (data.hashCode() == currentNode.getData().hashCode()) {
                break;
            }
            if (data.hashCode() < currentNode.getData().hashCode()) {
                if (currentNode.getLeft() != null) {
                    stack.push(currentNode.getLeft());
                } else {
                    return false;
                }
            } else {
                if (currentNode.getRight() != null) {
                    stack.push(currentNode.getRight());
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean remove(T data) {
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        TreeNode<T> prevNode = null;
        while (!stack.empty()) {
            TreeNode<T> currentNode = stack.pop();
            if (data.hashCode() == currentNode.getData().hashCode()) {
                if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                    if (prevNode.getLeft() == currentNode) {
                        prevNode.setLeft(null);
                    } else {
                        prevNode.setRight(null);
                    }
                    count--;
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
                    count--;
                    break;
                } else {
                    Stack<TreeNode<T>> stackLeft = new Stack<>();
                    stackLeft.push(currentNode.getRight());
                    TreeNode<T> currentNodeLeftTemp = null;
                    while (!stackLeft.empty()) {
                        TreeNode<T> currentNodeLeft = stackLeft.pop();
                        if (currentNodeLeft.getLeft() != null) {
                            currentNodeLeftTemp = currentNodeLeft;
                            stackLeft.push(currentNodeLeft.getLeft());
                        } else {
                            if (currentNodeLeft.getRight() != null) {
                                currentNodeLeftTemp.setRight(currentNodeLeft.getRight());
                                prevNode.setLeft(currentNodeLeft);
                                currentNodeLeft.setLeft(currentNode.getLeft());
                                currentNodeLeft.setRight(currentNode.getRight());
                            } else {
                              //  currentNodeLeftTemp.setLeft(null);
                                prevNode.setLeft(currentNodeLeft);
                                currentNodeLeft.setLeft(currentNode.getLeft());
                                currentNodeLeft.setRight(currentNode.getRight());
                            }
                        }
                    }
                    count--;
                    break;
                }
            }
            if (data.hashCode() < currentNode.getData().hashCode()) {
                if (currentNode.getLeft() != null) {
                    prevNode = currentNode;
                    stack.push(currentNode.getLeft());
                } else {
                    return false;
                }
            } else {
                if (currentNode.getRight() != null) {
                    prevNode = currentNode;
                    stack.push(currentNode.getRight());
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
