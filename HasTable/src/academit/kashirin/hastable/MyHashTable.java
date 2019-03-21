package academit.kashirin.hastable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashItems;
    private int length;
    private int countList;
    private int modCount = 0;

    public MyHashTable() {
        hashItems = new ArrayList[10];
    }

    public int getHasCode(T value) {
        return Math.abs(value.hashCode() % hashItems.length);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < hashItems.length; i++) {
            if (hashItems[i] != null) {
                if (Objects.equals(hashItems[i].get(0), o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator()  {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int modCountSave = modCount;

        private int currentIndex = -1;

        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

        public T next() {
            if (modCountSave != modCount) {
                throw new ConcurrentModificationException("В коллекции добавились/удалились элементы за время обхода");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция закончилась");
            }
            ++currentIndex;
            return (T) hashItems[currentIndex];
        }
    }
    @Override
    public Object[] toArray() {
        Object[] temp = new Object[countList];
        int j = 0;
        for (int i = 0; i < hashItems.length; i++) {
            if (hashItems[i] != null) {
                temp[j] = hashItems[i];
                j++;
            }
        }
        return temp;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        int hash = getHasCode(t);
        while (hashItems[hash] != null) {
            hashItems[hash].add(t);
            length++;
            return true;
        }
        hashItems[hash] = new ArrayList<>();
        hashItems[hash].add(t);
        countList++;
        length++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < hashItems.length; i++) {
            if (hashItems[i] != null) {
                for (T element : hashItems[i]) {
                    if (Objects.equals(element, o)) {
                        hashItems[i].remove(o);
                        length--;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public String toString() {
        return Arrays.toString(hashItems);
    }
}
