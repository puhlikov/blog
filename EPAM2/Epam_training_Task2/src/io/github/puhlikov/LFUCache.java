package com.epam.training;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LFUCache<K, V extends Integer> implements Cache<K, V> {
    private int volume;
    private Map<K, Integer> map;
    private final float loadFactor = 1.0f;
    private final boolean accessOrder = true;

    private boolean MapFullLoad() {
        if (map.size() == volume) {
            return true;
        }
        return false;
    }

    public LFUCache(int volume) {
        this.volume = volume;
        this.map = new LinkedHashMap<>(volume, loadFactor, accessOrder) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, Integer> eldest) {
                return size() > volume;
            }
        };
    }

    @Override
    public K[] getAll() {
        return (K[]) map.keySet().toArray(new String[map.size()]);
    }


    @Override
    public V put(K key) {
        if (MapFullLoad()) {
            K keyBelowValue = map.entrySet().stream()
                    .min(Comparator.comparingInt(Map.Entry::getValue))
                    .get()
                    .getKey();
            remove(keyBelowValue);
        }
        map.put(key,0);
        return (V) new Integer(0);
    }

    @Override
    public V get(K key) {
        Integer newValue = map.get(key) + 1;
        map.replace(key, newValue);
        return (V) map.get(key);
    }

    @Override
    public V remove(K key) {
        return (V) map.remove(key);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LFUCache<?, ?> lfuCache = (LFUCache<?, ?>) o;
        return volume == lfuCache.volume &&
                Float.compare(lfuCache.loadFactor, loadFactor) == 0 &&
                accessOrder == lfuCache.accessOrder &&
                map.equals(lfuCache.map);
    }

    @Override
    public int hashCode() {

        return Objects.hash(volume, map, loadFactor, accessOrder);
    }

    @Override
    public String toString() {
        return "LFUCache{" +
                "volume=" + volume +
                ", map=" + map +
                ", loadFactor=" + loadFactor +
                ", accessOrder=" + accessOrder +
                '}';
    }
}
