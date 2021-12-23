package com.epam.training;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache<K,V extends Integer> implements Cache<K,V> {

    private int volume;
    private Map map;
    private final float loadFactor = 1.0f;
    private final boolean accessOrder = true;


    public LRUCache(int volume) {
        this.volume = volume;
        this.map = new LinkedHashMap<K,V>(volume, loadFactor, accessOrder) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size() > volume;
            }
        };
    }

    @Override
    public V put(K key) {
        map.put(key, null);
        return null;
    }

    @Override
    public V get(K key) {
        return (V) map.get(key);
    }

    @Override
    public K[] getAll() {
        return (K[]) map.keySet().toArray(new String[map.size()]);
    }

    @Override
    public V remove(K key) {
        return (V) map.remove(key);

    }


    public Map<K, V> getMap() {
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LRUCache<?, ?> lruCache = (LRUCache<?, ?>) o;
        return volume == lruCache.volume &&
                Float.compare(lruCache.loadFactor, loadFactor) == 0 &&
                accessOrder == lruCache.accessOrder &&
                map.equals(lruCache.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, map, loadFactor, accessOrder);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "volume=" + volume +
                ", map=" + map +
                ", loadFactor=" + loadFactor +
                ", accessOrder=" + accessOrder +
                '}';
    }
}