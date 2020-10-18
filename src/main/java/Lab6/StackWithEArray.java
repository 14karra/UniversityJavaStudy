package Lab6;

import java.util.Arrays;

/**
 * Preferred form since type replacement is operated during compilation instead of type cast at runtime,
 * as in the other case. It's better to detect errors during compilation, instead of during runtime.
 *
 * @param <E>
 */
// Solution to exercise 2 - partly
class StackWithEArray<E> implements IStack<E> {
    private E[] items;
    private int firstEmptyPos = 0;

    StackWithEArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        this.items = (E[]) new Object[size];
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
        return this.items[--firstEmptyPos];
    }

    @Override
    public boolean isEmpty() {
        return this.firstEmptyPos == 0;
    }
}