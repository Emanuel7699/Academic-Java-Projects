/**DupCount.
 * @author Emanuel Abraham
 * @version 28/04/2026 (2026b)
 */


package com.example.maman03;

import java.util.HashMap;

public class DupCount <E>{
    private HashMap <E, Integer> map;

    // Creates a HashMap.
    public DupCount(){
        map = new HashMap<>();
    }

    // Add a key to HashMap.
    public void add (E key){
        if (map.containsKey(key)) {
            map.put(key, map.get(key)+1);
        }
        else map.put(key, 1);
    }

    // Remove a key from HashMap.
    public int remove (E key){
        if (!map.containsKey(key)) return 0;
        if (map.get(key)>1) {
            map.put(key, map.get(key)-1);
            return (map.get(key));
        }
        else map.remove(key);
        return 0;
    }

    // Gets the Max number key.
    public E getMaxDup(){
        if (map.isEmpty()) return null;
        int max = 0;
        E result = null;
        for (HashMap.Entry<E, Integer> entry : map.entrySet()){
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    // Gets the HashMap.
    public HashMap<E, Integer> getMap() {
        return map;
    }
}

