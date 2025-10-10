package com.dava.DSA.hashMap;

import java.util.HashMap;
import java.util.HashSet;

class MapUsingHash {
    private class Entity {
        String key;
        String value;
        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    public Entity[] entities;
    MapUsingHash() {
        entities = new Entity[100];
    }
    public void put(String key, String value) {
        int hash = Math.abs(key.hashCode() & entities.length);
        entities[hash] = new Entity(key, value);
    }
    public String get(String key) {
        int hash = Math.abs(key.hashCode() & entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)) {
            return entities[hash].value;
        }
        return null;
    }
    public void remove(String key) {
        int hash = Math.abs(key.hashCode() & entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)) {
            entities[hash] = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        //hash map
        HashMap<String, Integer> map = new HashMap<>();
        map.put("suganthi", 99);
        map.put("saminathan", 95);
        map.put("davanesh", 85);

        System.out.println(map.get("davanesh"));
        System.out.println(map.getOrDefault("dava", 78));

        //hash set
        HashSet<Integer> set = new HashSet<>();
        set.add(45);
        set.add(44);
        set.add(43);
        set.add(42);
        set.add(41);
        set.add(45);
        set.add(44);
        System.out.println(set);

        //own hashMap
        MapUsingHash ownMap = new MapUsingHash();
        ownMap.put("dava", "nesh");
        ownMap.put("dava", "sami");
        System.out.println(ownMap.get("dava"));
        ownMap.remove("dava");
        System.out.println(ownMap.get("dava"));
    }
}
