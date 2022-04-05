package programmers.c30l49189;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> vertex = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            vertex.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++){
            int start = edge[i][0];
            int end = edge[i][1];
            vertex.get(end).add(start);
            vertex.get(start).add(end);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        queue.add(1);
        visit[1] = true;
        int dist=0;
        while(!queue.isEmpty()){

            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                int cur = queue.poll();
                for(Integer next : vertex.get(cur)){
                    if(!visit[next]) {
                        queue.add(next);
                        visit[next] = true;
                    }
                }
            }
            if(queue.isEmpty()){
                return queueSize;
            }
            dist++;
        }
        return answer;
    }
}
