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
            throw new NullPointerException("Список пуст");
        }
        return head.getData();
    }

    public T getValue(int index) {
        if (count < index && index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        return getNode(index).getData();
    }

    public T setValue(int index, T data) {
        if (count < index && index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        ListItem<T> tempNode = getNode(index);
        T temp = tempNode.getData();
        tempNode.setData(data);
        return temp;
    }

    public T remove(int index) {
        if (count < index && index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        T temp;
        ListItem<T> tempNode = getNode(index);
        if (index == count - 1) {
            index--;
            temp = tempNode.getData();
            tempNode.setNext(null);
        } else if (index == 0) {
            temp = tempNode.getData();
            head = tempNode.getNext();
        } else {
            index--;
            temp = tempNode.getNext().getData();
            tempNode.setNext(tempNode.getNext().getNext());
        }
        count--;
        return temp;
    }

    public void setHead(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void insertAt(int index, T data) {
        if (count < index && index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        ListItem<T> temp;
        ListItem<T> tempNode;
        if (index == count) {
            index--;
            tempNode = getNode(index);
            temp = new ListItem<>(data, null);
            tempNode.setNext(temp);
        } else if (index == 0) {
            temp = new ListItem<>(data, head);
            head = temp;
        } else {
            index--;
            tempNode = getNode(index);
            temp = new ListItem<>(data, tempNode.getNext());
            tempNode.setNext(temp);
        }
        count++;
    }

    public boolean removeNode(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (data.equals(p.getData())) {
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
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }
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
        ListItem<T> p = head;
        for (int i = 0; i < count; i++) {
            list1.setHead(p.getData());
            p = p.getNext();
        }
        ListItem<T> temp = list1.head;
        for (p = head; p != null; p = p.getNext()) {
            temp.setData(p.getData());
            temp = temp.getNext();
        }
        return list1;
    }

    private ListItem<T> getNode(int index) {
        ListItem<T> p = head;
        for (int i = 1; i <= index; i++) {
            p = p.getNext();
        }
        return p;
    }
}
