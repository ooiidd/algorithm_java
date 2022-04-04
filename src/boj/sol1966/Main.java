package boj.sol1966;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        class Print implements Comparable<Print>{
            public int priority;
            boolean find;

            public Print(int priority) {
                this.priority = priority;
                find=false;
            }

            public Print(int priority, boolean find) {
                this(priority);
                this.find = find;
            }

            @Override
            public int compareTo(Print o) {
                return Integer.compare(o.priority,priority);
            }
        }
        Scanner scan = new Scanner(System.in);
        int TC = scan.nextInt();
        while(TC-- > 0){
            PriorityQueue<Print> pq = new PriorityQueue<>();
            Deque<Print> dq = new LinkedList<>();
            int N = scan.nextInt();
            int M = scan.nextInt();
            for(int i=0;i<N;i++){
                Print cur = null;
                if(M == i) {
                    cur = new Print(scan.nextInt(), true);
                }
                else{
                    cur = new Print(scan.nextInt());
                }
                    dq.addLast(cur);
                    pq.add(cur);
            }
            for(int i=0;true;){
                if(pq.peek().priority == dq.peekFirst().priority){
                    i++;
                    pq.poll();
                    Print cur = dq.pollFirst();
                    if(cur.find){
                        System.out.println(i);
                        break;
                    }
                }
                else{
                    dq.add(dq.pollFirst());
                }
            }
        }
    }
}
