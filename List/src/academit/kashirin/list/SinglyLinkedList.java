package academit.kashirin.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getListSize() {
        return count;
    }

    public T getTop() {
        return head.getData();
    }

    public T getValueByIndex(int index) {
        ListItem<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        return p.getData();
    }

    public T updateValueByIndex(int index, T data) {
        ListItem<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        T temp = p.getData();
        p.setData(data);
        return temp;
    }

    public T removeByIndex(int index) {
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

    public void setTop(T data) {
        ListItem<T> p = new ListItem<>(data, head);
        head = p;
        count++;
    }

    public void setValueByIndex(int index, T data) {
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

    public boolean removeNodeByValue(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData() == data) {
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
        int i = 2;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            setTop(p.getData());
            removeByIndex(i);
            i++;
        }
    }

    public void copy(SinglyLinkedList<T> list) {
        for (ListItem<T> p = list.head; p != null; p = p.getNext()) {
            ListItem<T> copy = new ListItem<>(p.getData(), head);
            head = copy;
            count++;
        }
    }
}
