package academit.kashirin.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public void setTop(T data) {
        ListItem<T> p = new ListItem<>(data, head);
        head = p;
        count++;
    }

    public int getListSize() {
        return count;
    }

    public T getTop() {
        return head.getData();
    }

    public T getValueByIndex(int index) {
        ListItem<T> p = head;
        for (int i = 0; i < index-1; i++) {
            p = p.getNext();
        }
        return p.getData();
    }

    public void setValueByIndex(int index, T data) {
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        head.setData(data);
        head.setNext(p);
        count++;
    }
}
 