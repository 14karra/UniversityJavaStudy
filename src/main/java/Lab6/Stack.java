package Lab6;

import java.util.ArrayList;
import java.util.List;

// Solution to exercise 1
class Stack<E> implements IStack<E> {
    private List<E> items;

    Stack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        this.items = new ArrayList<>(size);
    }

    @Override
    public void push(E item) {
        this.items.add(item);
    }

    @Override
    public E pop() {
        if (this.items.isEmpty()) {
            throw new IndexOutOfBoundsException("The stack is empty!");
        }
        return this.items.remove(this.items.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }
}
