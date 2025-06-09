 import java.util.*;
 import java.util.Set;
public class AllienDictionary {
    


    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words)
            for (char c : word.toCharArray()) inDegree.put(c, 0);

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.putIfAbsent(c1, new HashSet<>());
                    if (graph.get(c1).add(c2)) inDegree.put(c2, inDegree.get(c2)+1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet())
            if (inDegree.get(c) == 0) queue.offer(c);

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            if (graph.containsKey(c)) {
                for (char nei : graph.get(c)) {
                    inDegree.put(nei, inDegree.get(nei)-1);
                    if (inDegree.get(nei) == 0) queue.offer(nei);
                }
            }
        }

        return result.length() == inDegree.size() ? result.toString() : "";
    }


    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Order: " + alienOrder(words));
    }

}
