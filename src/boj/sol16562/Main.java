package boj.sol16562;

import java.io.*;
import java.util.StringTokenizer;

class Friend{
    int no;
    int cost;
    Friend parent = null;

    public Friend(int no, int cost) {
        this.no = no;
        this.cost = cost;
    }
}
public class Main {
    public static Friend[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nodes = new Friend[N+1];
        for(int i=0;i<N;i++){
            int cost = Integer.parseInt(st.nextToken());
            nodes[i+1] = new Friend(i+1,cost);
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            union(nodes[first],nodes[second]);
        }
        nodes[0] = new Friend(0,1000000);
        StringBuilder sb = new StringBuilder();
        int total = 0;
        for(int i=1;i<=N;i++){
            if(!isSet(nodes[0],nodes[i] )){
                total += find(nodes[i]).cost;
                if(total>k){
                    sb.append("Oh no\n");
                    break;
                }
                union(nodes[0], nodes[i]);
            }
        }
        if(total <= k){
            sb.append(total+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    public static Friend find(Friend n1){
        if(n1.parent == null){
            return n1;
        }
        return n1.parent = find(n1.parent);
    }
    public static void union(Friend n1, Friend n2){
        Friend master1 = find(n1);
        Friend master2 = find(n2);
        if(master1.no != master2.no){
            if(master1.cost < master2.cost){
                master2.parent = master1;
            }
            else{
                master1.parent = master2;
            }
        }
    }
    public static boolean isSet(Friend n1, Friend n2){
        Friend master1 = find(n1);
        Friend master2 = find(n2);
        if(master1.no == master2.no){
            return true;
        }
        return false;
    }
}
