package academit.kashirin.arraylist;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int length;
    private int modCount = 0;

    public MyArrayList() {
        items = (T[]) new Object[10];
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
        for (int i = 0; i < length; i++) {
            if (get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        int temp = modCount;

        private int currentIndex = -1;

        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

        public T next() {
            if (temp != modCount) {
                throw new ConcurrentModificationException("В коллекции добавились/удалились элементы за время обхода");
            }
            if (currentIndex + 1 > length) {
                throw new NoSuchElementException("Коллекция кончилась");
            }
            ++currentIndex;
            return items[currentIndex];
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = get(i);
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = t;
        length++;
        modCount++;
        return true;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < length; i++) {
            if (get(i).equals(o)) {
                System.arraycopy(items, i + 1, items, i, length - i - 1);
                length--;
                modCount--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean isContain = false;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            if (c.contains(get(i))) {
                count++;
            }
        }
        if (count == c.size()) {
            isContain = true;
        }
        return isContain;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() != 0) {
            Iterator<Integer> iterator = (Iterator<Integer>) c.iterator();
            while (iterator.hasNext()) {
                add((T) iterator.next());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c.size() != 0) {
            Iterator<Integer> iterator = (Iterator<Integer>) c.iterator();
            while (iterator.hasNext()) {
                add(index, (T) iterator.next());
                index++;
            }
            return true;
        }
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
        length = 0;
    }

    @Override
    public T get(int index) {
        if (length < index) {
            throw new IllegalArgumentException("Элемента с данным индексом не существует");
        }
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (length < index) {
            throw new IllegalArgumentException("Элемента с данным индексом не существует");
        }
        items[index] = element;
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (length >= items.length) {
            increaseCapacity();
        }
        if (index < length - 1) {
            System.arraycopy(items, index, items, index + 1, length - index + 1);
            items[index] = element;
        }
        length++;
        modCount++;
    }

    @Override
    public T remove(int index) {
        T temp = items[index];
        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        length--;
        modCount--;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length - 1; i++) {
            if (get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
