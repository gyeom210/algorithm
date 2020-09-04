import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // int[] answer = {};
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, Integer> mapKey = new HashMap<>();
        HashMap<String, Integer> key = new HashMap<>();
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        
        ArrayList<Integer> nameSet = new ArrayList<>();

        for(int i = 0; i < genres.length; i++){
            map.put(i, genres[i]);  
            mapKey.put(i, plays[i]);
            key.put(genres[i], key.getOrDefault(genres[i], 0)+plays[i]);
        }
        Collections.sort(keySetList, (o1, o2) -> (key.get(o2).compareTo(key.get(o1)))); //정렬
        
        for(String name : key.keySet()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Map.Entry<Integer,String> entry : map.entrySet()){
                if(entry.getValue().equals(name)){
                    temp.add(mapKey.get(entry.getKey()));
                }
                temp.sort(Comparator.reverseOrder()); //내림차순
            } 

            nameSet.add(getKey(mapKey,temp.get(0)));
            if (temp.size() > 1) {
                nameSet.add(getKey(mapKey,temp.get(1)));
            }
        }
        int[] answer = new int[nameSet.size()];
        for (int i = 0; i < nameSet.size(); i++) {
            answer[i] = nameSet.get(i);
        }
        return answer;
    }
    
    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
