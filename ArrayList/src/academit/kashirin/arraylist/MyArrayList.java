package academit.kashirin.arraylist;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int length;
    private int modCount = 0;

    public MyArrayList() {
        //noinspection MoveFieldAssignmentToInitializer,unchecked
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
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
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
            return items[currentIndex];
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, length);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        System.arraycopy(items, 0, a, 0, length);
        return a;
    }

    @Override
    public boolean add(T t) {
        if (length >= items.length) {
            ensureCapacity();
        }
        items[length] = t;
        length++;
        modCount++;
        return true;
    }

    private void ensureCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(get(i), o)) {
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
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() != 0) {
            if ((items.length - length) < c.size()) {
                items = Arrays.copyOf(items, length + c.size());
            }
            for (T element : c) {
                add(element);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (length < index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        if (c.size() != 0) {
            if ((items.length - length) < c.size()) {
                items = Arrays.copyOf(items, length + c.size());
            }
            for (T element : c) {
                add(index, element);
                index++;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemove = false;
        for (int i = 0; i < size(); i++) {
            for (Object element : c) {
                if (Objects.equals(get(i), element)) {
                    remove(i);
                    isRemove = true;
                }
            }
        }
        return isRemove;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.size() == 0) {
            return false;
        }
        boolean isRemove = false;
        for (int i = 0; i < size(); i++) {
            Iterator<T> iterator = (Iterator<T>) c.iterator();
            while (iterator.hasNext()) {
                if (Objects.equals(iterator.next(), items[i])) {
                    isRemove = true;
                }
            }
            if (!isRemove) {
                remove(i);
                i--;
            }
            isRemove = false;
        }
        return true;
    }

    @Override
    public void clear() {
        length = 0;
        Arrays.fill(items, null);
    }

    @Override
    public T get(int index) {
        if (length < index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (length < index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        T temp = get(index);
        items[index] = element;
        return temp;
    }

    @Override
    public void add(int index, T element) {
        if (length < index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
        if (length >= items.length) {
            ensureCapacity();
        }
        if (index < length) {
            System.arraycopy(items, index, items, index + 1, length - index + 1);
            items[index] = element;
        }
        length++;
        modCount++;
    }

    @Override
    public T remove(int index) {
        if (length < index || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с данным индексом не существует");
        }
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
            if (Objects.equals(o, get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (Objects.equals(o, get(i))) {
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

    private void trimToSize() {
        if (length == 0) {
            return;
        }
        if (items.length - length == 10) {
            items = Arrays.copyOf(items, length);
        }
    }
}
