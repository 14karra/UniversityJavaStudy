package Lab6;

public interface IStack<E> {
    void push(E item);

    E pop();

    boolean isEmpty();
}
