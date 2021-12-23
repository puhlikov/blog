package com.epam.training;

public interface Cache<K,V extends Integer> {

    K[] getAll();

    V put(K key);

    V get(K key);

    V remove(K key);
}