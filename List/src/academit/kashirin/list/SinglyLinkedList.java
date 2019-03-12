package academit.kashirin.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getListSize() {
        return count;
    }

    public T getHead() {
        if (head == null) {
            throw new IllegalArgumentException("Список пуст");
        }
        return head.getData();
    }

    public T getValue(int index) {
        if (count < index) {
            throw new IllegalArgumentException("Элемента с данным индексом не существует");
        }
        return getNode(index).getData();
    }

    public T setValue(int index, T data) {
        if (count < index) {
            throw new IllegalArgumentException("Элемента с данным индексом не существует");
        }
        T temp = getNode(index).getData();
        getNode(index).setData(data);
        return temp;
    }

    public T remove(int index) {
        if (count < index) {
            throw new IllegalArgumentException("Элемента с данным индексом не существует");
        }
        ListItem<T> p = head;
        ListItem<T> prev = null;
        for (int i = 0; i < index - 1; i++) {
            prev = p;
            p = p.getNext();
        }
        T temp;
        if (p == null) {
            prev.setNext(null);
        } else {
            prev.setNext(p.getNext());
        }
        temp = p.getData();
        count--;
        return temp;
    }

    public void setHead(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void insertAt(int index, T data) {
        if (count < index) {
            throw new IllegalArgumentException("Элемента с данным индексом не существует");
        }
        ListItem<T> p = head;
        ListItem<T> prev = null;
        for (int i = 0; i < index - 1; i++) {
            prev = p;
            p = p.getNext();
        }
        ListItem<T> temp = new ListItem<>(data, p);
        prev.setNext(temp);
        count++;
    }

    public boolean removeNode(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                if (p == null) {
                    prev.setNext(null);
                } else {
                    prev.setNext(p.getNext());
                }
                count--;
                return true;
            }
        }
        return false;
    }

    public T removeTop() {
        T temp = head.getData();
        head = head.getNext();
        count--;
        return temp;
    }

    public void invertList() {
        ListItem<T> p = head;
        ListItem<T> temp = null;
        ListItem<T> next;
        for (int i = 0; i < count; i++) {
            next = p.getNext();
            p.setNext(temp);
            temp = p;
            p = next;
        }
        head = temp;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> list1 = new SinglyLinkedList<>();
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            list1.setHead(p.getData());
        }
        list1.invertList();
        return list1;
    }

    private ListItem<T> getNode(int index) {
        ListItem<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        return p;
    }
}
