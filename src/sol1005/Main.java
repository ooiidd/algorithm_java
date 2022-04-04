package sol1005;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T-->0){

            st = new StringTokenizer(br.readLine());
            int N =  Integer.parseInt(st.nextToken());
            int K =  Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int cost[] = new int[N+1];
            int dist[] = new int[N+1];
            int indegSize[] = new int[N+1];
            List<List<Integer>> indeg = new ArrayList<>();
            for(int i=0;i<N+1;i++){
                indeg.add(new ArrayList<>());
            }
            for(int i=0;i<N;i++){
                int cur = Integer.parseInt(st.nextToken());
                cost[i+1] = cur;
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int from =  Integer.parseInt(st.nextToken());
                int to =  Integer.parseInt(st.nextToken());
                indegSize[to]++;
                indeg.get(from).add(to);
            }
            st = new StringTokenizer(br.readLine());
            int destNo = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            for(int i=1;i<N+1;i++){
                if(indegSize[i]==0){
                    queue.add(i);
                    dist[i]= cost[i];
                }
            }
            while(!queue.isEmpty()){
                int cur = queue.poll();
                if(cur == destNo) break;
                List<Integer> inList = indeg.get(cur);
                for(int i=0;i<inList.size();i++){
                    int next = inList.get(i);
                    indegSize[next]--;
                    if(indegSize[next] == 0){
                        queue.add(next);
                    }
                    if(dist[next]<dist[cur]+cost[next]){
                        dist[next]=dist[cur]+cost[next];
                    }
                }
            }
            System.out.println(dist[destNo]);
        }
    }
}
