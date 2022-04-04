package boj.sol1926;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        int[] dy = {0,0,-1,1};
        int[] dx = {1,-1,0,0};

        //input
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        class Point {
            int y;
            int x;

            public Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }
        int maxValue = 0;
        Queue<Point> queue = new LinkedList<>();
        int partNum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 1 && visit[i][j]==false){
                    visit[i][j] = true;
                    queue.add(new Point(i,j));
                    partNum++;
                    int count = 0;
                    while(!queue.isEmpty()){
                        count++;
                        Point point = queue.poll();
//                        System.out.print("point : ");
//                        System.out.print(point.x +" ");
//                        System.out.println(point.y +" ");
                        for(int k=0;k<4;k++){
                            int toY = point.y+dy[k];
                            int toX = point.x+dx[k];
                            if(!isEndPos(toY,toX,N,M) && !visit[toY][toX] && arr[toY][toX]==1) {
                                visit[toY][toX] = true;
                                queue.add(new Point(toY, toX));
                            }
                        }
                    }
//                    System.out.println(count);
                    maxValue = Math.max(maxValue,count);
                }
            }
        }
        sb.append(partNum+"\n");
        sb.append(maxValue+"\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean isEndPos(int y, int x, int N, int M){
        if(y<0 || x<0 || y>=N || x>=M){
            return true;
        }
        return false;
    }
}
