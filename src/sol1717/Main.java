package sol1717;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node{
    int cnt;

    public Node(int cnt) {
        this.cnt = cnt;
    }

    Node parent = null;
}
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Node[] nodes = new Node[N+1];
        for(int i=0;i<=N;i++){
            nodes[i] = new Node(i);
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(op == 0 ){
                set(nodes[first],nodes[second]);
            }
            else if(op== 1){
                if(isSet(nodes[first],nodes[second])){
                    sb.append("YES\n");
                }
                else{
                    sb.append("NO\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static Node findGrand(Node node){
        if(node.parent == null){
            return node;
        }
        return node.parent = findGrand(node.parent);
    }
    public static boolean isSet(Node n1, Node n2){
        if(findGrand(n1).cnt == findGrand(n2).cnt){
            return true;
        }
        else{
            return false;
        }
    }
    public static void set(Node n1, Node n2){
        Node x = findGrand(n1);
        Node y = findGrand(n2);
        if(x.cnt != y.cnt){
            if(x.cnt < y.cnt){
                y.parent = x;
            }
            else{
                x.parent = y;
            }
        }
    }
}
