package academit.kashirin.hashtable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashItems;
    private int length;
    private int modCount = 0;

    public MyHashTable() {
        //noinspection unchecked
        hashItems = new ArrayList[10];
    }

    private int getHashCode(Object value) {
        if (value == null) {
            return 0;
        }
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
        int hash = getHashCode(o);
        if (hashItems[hash] == null) {
            return false;
        }
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
                        while (hashItems[countListItems] == null) {
                            ++countListItems;
                        }
                    }
                }
            } else {
                while (hashItems[countListItems] == null) {
                    ++countListItems;
                    ++currentIndex;
                    countItems = 0;
                }
            }
            return hashItems[countListItems].get(countItems);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[length];
        int j = 0;
        for (T hashItem : this) {
            temp[j] = hashItem;
            j++;
        }
        return temp;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length >= length) {
            for (int i = 0; i < length; i++) {
                //noinspection unchecked
                a[i] = (T1) hashItems[i];
            }
            if (a.length>length) {
                a[length] = null;
            }
        } else
        {
            //noinspection unchecked
            a = (T1[]) Arrays.copyOf(hashItems, hashItems.length, a.getClass());
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        int hash = getHashCode(t);
        if (hashItems[hash] != null) {
            hashItems[hash].add(t);
            length++;
            modCount++;
            return true;
        }
        hashItems[hash] = new ArrayList<>();
        hashItems[hash].add(t);
        length++;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int hash = getHashCode(o);
        if (hashItems[hash] == null) {
            return false;
        }
        boolean isRemove = hashItems[hash].remove(o);
        length--;
        modCount++;
        return isRemove;
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
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemove = false;
        for (int i = 0; i < hashItems.length; i++) {
            if (hashItems[i] != null) {
                int tempSize = hashItems[i].size();
                if (hashItems[i].removeAll(c)) {
                    length -= tempSize - hashItems[i].size();
                    modCount++;
                    isRemove = true;
                    if (hashItems[i].size() == 0) {
                        hashItems[i] = null;
                    }
                }
            }
        }
        return isRemove;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetain = false;
        for (int i = 0; i < hashItems.length; i++) {
            if (hashItems[i] != null) {
                int tempSize = hashItems[i].size();
                if (hashItems[i].retainAll(c)) {
                    length -= tempSize - hashItems[i].size();
                    modCount++;
                    isRetain = true;
                    if (hashItems[i].size() == 0) {
                        hashItems[i] = null;
                    }
                }
            }
        }
        return isRetain;
    }

    @Override
    public void clear() {
        length = 0;
        Arrays.fill(hashItems, null);
        modCount++;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (ArrayList<T> element : hashItems) {
            if (element != null) {
                joiner.add(element.toString());
            }
        }
        return joiner.toString();
    }
}
