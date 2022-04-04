package sol9205;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T-- > 0) {
            LinkedList<Point> prevList = new LinkedList<>();
            LinkedList<Point> nextList = new LinkedList<>();
            LinkedList<Point> unknownList = new LinkedList<>();
            int N = scan.nextInt();

            int x = scan.nextInt();
            int y = scan.nextInt();
            nextList.add(new Point(x, y));
            for (int i = 0; i < N; i++) {
                x = scan.nextInt();
                y = scan.nextInt();
                unknownList.add(new Point(x, y));
            }
            x = scan.nextInt();
            y = scan.nextInt();
            Point dest = new Point(x, y);

            boolean isEnd = false;
            while(!nextList.isEmpty()) {
                prevList.addAll(nextList);
                nextList.clear();
                while (!prevList.isEmpty()) {
                    Point cur = prevList.poll();
                    if (isPossibleGo(cur, dest)) {
                        System.out.println("happy");
                        isEnd = true;
                        break;
                    }
                    for (int i = 0; i < unknownList.size(); i++) {
                        if (isPossibleGo(cur, unknownList.get(i))) {
                            nextList.add(unknownList.get(i));
                            unknownList.remove(i);
                            i--;
                        }
                    }
                }
                if(isEnd)
                    break;
            }
            if(!isEnd)
                System.out.println("sad");
        }
    }
    public static boolean isPossibleGo(Point from, Point to){
        int gapX = Math.abs(from.x- to.x);
        int gapY = Math.abs(from.y- to.y);
        if(gapX + gapY <= 1000){
            return true;
        }
        return false;
    }
}
