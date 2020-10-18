package Lab6;

import java.util.Arrays;

// Solution to exercise 2 - partly
class StackWithObjectArray<E> implements IStack<E> {
    private Object[] items;
    private int firstEmptyPos = 0;

    StackWithObjectArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than 0");
        }
        this.items = new Object[size];
    }

    @Override
    public void push(E item) {
        if (firstEmptyPos == items.length) {
            this.items = Arrays.copyOf(this.items, this.items.length * 2);
        }
        this.items[firstEmptyPos++] = item;
    }

    @Override
    public E pop() {
        if (this.firstEmptyPos == 0) {
            throw new IllegalStateException("stack is empty");
        }
        return (E) this.items[--firstEmptyPos];
    }

    @Override
    public boolean isEmpty() {
        return this.firstEmptyPos == 0;
    }
}