import java.util.HashMap;

public class DupCount <E>{
    private HashMap<E, Integer> map;

    public DupCount(){
        map = new HashMap<>();
    }

    public void add (E key){
        if (map.containsKey(key)) {
            map.put(key, map.get(key)+1);
        }
        else map.put(key, 1);
    }

    public int remove(E key){
        if (!map.containsKey(key)) return 0;
        if (map.get(key)>1) {
            map.put(key, map.get(key)-1);
            return (map.get(key));
        }
        else map.remove(key);
        return 0;
    }

    public E getMaxDup(){
        if (map.isEmpty()) return null;
        int max = 0;
        E result = null;
        for (HashMap.Entry<E, Integer> entry : map.entrySet()){
            if (entry.getValue()>max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }






}
