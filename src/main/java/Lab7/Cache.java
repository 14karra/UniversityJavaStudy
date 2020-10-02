package Lab7;

import java.util.LinkedHashMap;
import java.util.Map;

class Cache<K, V> extends LinkedHashMap<K, V> {
    private final int maxCapacity;

    Cache(int maxCapacity) {
        super(maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this.maxCapacity;
    }
}