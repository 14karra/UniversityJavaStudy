package Lab5;

import java.util.concurrent.locks.ReentrantLock;

public class AutoCloseableWithReentrantLock extends ReentrantLock implements AutoCloseable {
    @Override
    public void close() {
        this.unlock();
    }
}