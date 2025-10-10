package com.dava.DSA.hashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HapMapUsingChains<K,V> {
    private class Entity {
        String key;
        String value;
        public Entity(K key, V value) {
            this.key = (String) key;
            this.value = (String) value;
        }
    }
    ArrayList<LinkedList<Entity>> list;
    private int size = 0;
    private float lf = 0.5f;
    public HapMapUsingChains() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
    }
    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        for (Entity entity : entities) {
            if(entity.key.equals(key)) {
                entity.value = (String) value;
            }
        }
        if((float)(size) / list.size() > lf) {
            reHash();
        }
        entities.add(new Entity(key, value));
        size++;
    }
    private void reHash() {
        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();
        size = 0;
        for (int i = 0; i < old.size() * 2; i++) {
            list.add(new LinkedList<>());
        }
        for (LinkedList<Entity> entities : old) {
            for(Entity entity : entities) {
                put((K) entity.key, (V) entity.value);
            }
        }
    }
    public V get(K key) {
        int hash = Math.abs(key.hashCode() & list.size());
        LinkedList<Entity> entities = list.get(hash);
        for (Entity entity : entities) {
            if(entity.key.equals(key)) {
                return (V) entity.value;
            }
        }
        return null;
    }
    public void remove(K key) {
        int hash = Math.abs(key.hashCode() & list.size());
        LinkedList<Entity> entities = list.get(hash);
        Entity target = null;
        for (Entity entity : entities) {
            if(entity.key.equals(key)) {
                target= entity;
                break;
            }
        }
        entities.remove(target);
        size--;
    }
    public boolean containKey(K key) {
        return get(key) != null;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (LinkedList<Entity> entities : list) {
            for (Entity entity : entities) {
                builder.append(entity.key);
                builder.append(" = ");
                builder.append(entity.value);
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
