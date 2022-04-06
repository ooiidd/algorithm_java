package programmers.c30l12927;

import java.util.Collections;
import java.util.Optional;
import java.util.PriorityQueue;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
        for(int i : works){
            pq.add((long)i);
        }
        for(int i=0;i<n;i++){
            pq.add(pq.poll()-1);
        }
        answer = pq.stream().map((cur)->{
            if(cur < 0)
                return (long)0;
            else {
                return (long) Math.pow(cur, 2);
            }
        }).reduce((a,b)->a+b).get();
        return answer;
    }
}
