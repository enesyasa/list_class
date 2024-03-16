import java.util.Arrays;

public class MyList<T> {

    private T[] array;
    private int initialCapacity = 10;
    private int currentSize = 0;

    public MyList() {
        this.array = (T[]) new Object[initialCapacity];
    }

    public MyList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    public int size() {
        return currentSize;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public void add(T element) {
        if (currentSize == (array != null ? array.length : 0)) {
            int updatedCapacity = (array != null && array.length != 0) ? array.length * 2 : initialCapacity;
            array = Arrays.copyOf(array, updatedCapacity);
        }
        array[currentSize] = element;
        currentSize++;
    }

    public T get(int index) {
        if (index < 0 || index >= currentSize) {
            return null;
        }
        return array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= currentSize) {
            return null;
        }
        T removedElement = array[index];

        for (int i = index; i < currentSize - 1; i++) {
            array[i] = array[i + 1];
        }

        array[currentSize - 1] = null;
        currentSize--;

        return removedElement;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= currentSize) {
            return null;
        }
        T replacedElement = array[index];
        array[index] = data;
        return replacedElement;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, currentSize));
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int indexOf(T data) {
        for (int i = 0; i < currentSize; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = currentSize - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public T[] toArray() {
        return Arrays.copyOf(array, currentSize);
    }

    public void clear() {
        Arrays.fill(array, null);
        currentSize = 0;
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> sublist = new MyList<>();
        for (int i = start; i <= finish; i++) {
            sublist.add(array[i]);
        }
        return sublist;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
}