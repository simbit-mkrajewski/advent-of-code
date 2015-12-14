package pl.com.simbit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDoubleKey<K1, K2, V> {

    Map<K1, Map<K2, V>> mainMap = new HashMap<K1, Map<K2, V>>();

    public void put(K1 k1, K2 k2, V value) {

        Map<K2, V> mapValue = mainMap.get(k1);
        if (mapValue == null) {
            mapValue = new HashMap<K2, V>();
            mainMap.put(k1, mapValue);
        }
        mapValue.put(k2, value);
    }

    public V get(K1 k1, K2 k2) {
        Map<K2, V> mapValue = mainMap.get(k1);
        if (mapValue == null) {
            return null;
        }

        return mapValue.get(k2);
    }

    public Set<K1> k1Values() {
        return this.mainMap.keySet();
    }

    public Set<K2> k2ValuesForK1(K1 k1) {
        Map<K2, V> mapValue = mainMap.get(k1);
        if (mapValue == null) {
            return new HashSet<K2>();
        }
        return mapValue.keySet();
    }

    public int getCount() {
        return mainMap.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<K1, Map<K2, V>> entry : mainMap.entrySet()) {
            sb.append("K1: " + entry.getKey() + " : " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
