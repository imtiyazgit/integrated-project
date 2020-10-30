package algos.array.facebook.webforum;

import java.util.*;

public class WebForum {
    Map<Integer, Integer> frequencyMap;

    public WebForum() {
        this.frequencyMap = new HashMap<>();
        this.frequencyMap.put(3, 342);
        this.frequencyMap.put(1, 23);
        this.frequencyMap.put(4, 2);
        this.frequencyMap.put(2, 55);
        this.frequencyMap.put(9, 66);
        this.frequencyMap.put(10, 100);
        this.frequencyMap.put(8, 80);
        this.frequencyMap.put(7, 69);
        this.frequencyMap.put(21, 555);
        this.frequencyMap.put(15, 1000);
        this.frequencyMap.put(19, 122);
        this.frequencyMap.put(17, 81);
        this.frequencyMap.put(14, 50);
    }


    public void addThread(Integer threadId) {
        if(threadId == null) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        frequencyMap.put(threadId, 0);
    }

    public Integer upVote(Integer threadId) {
        if(threadId == null) {
            throw new IllegalArgumentException("Invalid thread id");
        }
        Integer votes = frequencyMap.get(threadId);
        frequencyMap.put(threadId, votes + 1);
        return votes+1;
    }

    public List<Integer> getTopTenThreadIds() {
        List<Integer> results = new ArrayList<>();
        if(frequencyMap == null) {
            return results;
        }

        List<Integer> list = new ArrayList(frequencyMap.values());
        Collections.sort(list, (a, b) -> b-a);

        int index=0;
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() == list.get(index)) {
                results.add(entry.getKey());
            }
        }

        return list.subList(0,10);
    }


    public static void main(String[] args) {
        WebForum webForum = new WebForum();
        System.out.println(webForum.getTopTenThreadIds());
    }



}
