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
                    if (hashItems[countListItems] == null || hashItems[countListItems].size() == 0) {
                        while (hashItems[countListItems] == null || hashItems[countListItems].size() == 0) {
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
        int i = 0;
        for (T hashItem : this) {
            temp[i] = hashItem;
            i++;
        }
        return temp;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length >= length) {
            int i = 0;
            for (T hashItem : this) {
                //noinspection unchecked
                a[i] = (T1) hashItem;
                i++;
            }
            if (a.length > length) {
                a[length] = null;
            }
        } else {
            //noinspection unchecked
            a = (T1[]) Arrays.copyOf(hashItems, hashItems.length, a.getClass());
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        int hash = getHashCode(t);
        if (hashItems[hash] == null) {
            hashItems[hash] = new ArrayList<>();
        }
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
        if (isRemove) {
            length--;
            modCount++;
        }
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
        if (c.isEmpty()) {
            return false;
        }
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemove = false;
        for (ArrayList<T> hashItem : hashItems) {
            if (hashItem != null) {
                int tempSize = hashItem.size();
                if (hashItem.removeAll(c)) {
                    length -= tempSize - hashItem.size();
                    isRemove = true;
                }
            }
        }
        modCount++;
        return isRemove;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetain = false;
        for (ArrayList<T> hashItem : hashItems) {
            if (hashItem != null) {
                int tempSize = hashItem.size();
                if (hashItem.retainAll(c)) {
                    length -= tempSize - hashItem.size();
                    isRetain = true;
                }
            }
        }
        modCount++;
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
