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
        int hash = getHasCode((T) o);
        return hashItems[hash].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int modCountSave = modCount;

        private int currentIndex = -1;
        private int countListItems = 0;
        private int countItems = -1;

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
            if (hashItems[countListItems] != null) {
                ++currentIndex;
                ++countItems;
                if (hashItems[countListItems].size() == countItems) {
                    ++countListItems;
                    countItems = 0;
                    if (hashItems[countListItems] == null) {
                        while (hashItems[countListItems] == null && countListItems < hashItems.length) {
                            ++countListItems;
                        }
                    }
                }
            }
            return hashItems[countListItems].get(countItems);
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
        int hash = getHasCode((T) o);
        for (T element : hashItems[hash]) {
            if (Objects.equals(element, o)) {
                hashItems[hash].remove(o);
                length--;
                return true;
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
        for (Object element : c) {
            add((T) element);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRetain = false;
        for (int i = 0; i < size(); i++) {
            if (hashItems[i] != null) {
                for (int j = 0; j < hashItems[i].size(); j++) {
                    if (c.contains(hashItems[i].get(j))) {
                        remove(hashItems[i].get(j));
                        j--;
                        isRetain = true;
                    }
                }
            }
        }
        return isRetain;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetain = false;
        for (int i = 0; i < size(); i++) {
            if (hashItems[i] != null) {
                for (int j = 0; j < hashItems[i].size(); j++) {
                    if (!c.contains(hashItems[i].get(j))) {
                        remove(hashItems[i].get(j));
                        j--;
                        isRetain = true;
                    }
                }
            }
        }
        return isRetain;
    }

    @Override
    public void clear() {

    }

    public String toString() {
        return Arrays.toString(hashItems);
    }
}
