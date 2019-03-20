package academit.kashirin.list;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return count;
    }

    public T getHead() {
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }
        return head.getData();
    }

    public T getValue(int index) {
        if (count <= index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        return getNode(index).getData();
    }

    public T setValue(int index, T data) {
        if (count <= index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        ListItem<T> tempNode = getNode(index);
        T temp = tempNode.getData();
        tempNode.setData(data);
        return temp;
    }

    public T remove(int index) {
        if (count <= index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        T temp;
        if (index == 0) {
            temp = removeTop();
        } else {
            ListItem<T> tempNode = getNode(index - 1);
            temp = tempNode.getNext().getData();
            tempNode.setNext(tempNode.getNext().getNext());
            count--;
        }
        return temp;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void insertAt(int index, T data) {
        if (count < index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        ListItem<T> temp;
        if (index == 0) {
            temp = new ListItem<>(data, head);
            head = temp;
        } else {
            ListItem<T> tempNode = getNode(index - 1);
            temp = new ListItem<>(data, tempNode.getNext());
            tempNode.setNext(temp);
        }
        count++;
    }

    public boolean removeNode(T data) {
        if (head == null) {
            return false;
        }
        if (Objects.equals(data, getHead())) {
            removeTop();
            return true;
        }
        for (ListItem<T> p = head.getNext(), prev = head; p != null; prev = p, p = p.getNext()) {
            if (Objects.equals(data, p.getData())) {
                assert prev != null;
                prev.setNext(p.getNext());
                count--;
                return true;
            }
        }
        return false;
    }

    public T removeTop() {
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }
        T temp = head.getData();
        head = head.getNext();
        count--;
        return temp;
    }

    public void invert() {
        ListItem<T> p = head;
        ListItem<T> temp = null;
        for (int i = 0; i < count; i++) {
            ListItem<T> next = p.getNext();
            p.setNext(temp);
            temp = p;
            p = next;
        }
        head = temp;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        if (head == null) {
            return copy;
        }
        ListItem<T> firstNode = new ListItem<>(getHead(), null);
        ListItem<T> temp = firstNode;
        ListItem<T> node = head.getNext();
        while (node != null) {
            temp.setNext(new ListItem<>(node.getData()));
            temp = temp.getNext();
            node = node.getNext();
        }
        copy.head = firstNode;
        copy.count = count;
        return copy;
    }

    private ListItem<T> getNode(int index) {
        ListItem<T> p = head;
        for (int i = 1; i <= index; i++) {
            p = p.getNext();
        }
        return p;
    }
}
