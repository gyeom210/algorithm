import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playsHap = new LinkedHashMap<>();
        HashMap<Integer, String> genresMap = new HashMap<>();
        HashMap<Integer, Integer> playsMap = new HashMap<>();
        ArrayList<Integer> nameSet = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            genresMap.put(i, genres[i]);  
            playsMap.put(i, plays[i]);
            playsHap.put(genres[i], playsHap.getOrDefault(genres[i], 0) + plays[i]);
        }
        Map<String, Integer> result = sortMapByValue(playsHap); //내림차순
         for(String name : result.keySet()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Map.Entry<Integer,String> entry : genresMap.entrySet()){
                if(entry.getValue().equals(name)){
                    temp.add(playsMap.get(entry.getKey()));
                }
                temp.sort(Comparator.reverseOrder()); //내림차순
            }

            nameSet.add(getKey(playsMap, temp.get(0)));
            if (temp.size() > 1) {
                playsMap.remove(getKey(playsMap, temp.get(0)));
                nameSet.add(getKey(playsMap, temp.get(1)));
            }
        }
        int[] answer = new int[nameSet.size()];
        for (int i = 0; i < nameSet.size(); i++) {
            answer[i] = nameSet.get(i);
        }
        
        return answer;
    }
    
    //value 기준 정렬
    public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
    List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
    Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue())); //내림차순

    LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
    for (Map.Entry<String, Integer> entry : entries) {
        result.put(entry.getKey(), entry.getValue());
    }
    return result;
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
