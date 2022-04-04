package sol5582;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [][] dp = new int[4001][4001];
        Scanner scan = new Scanner(System.in);
        String str1= scan.nextLine();
        String str2 = scan.nextLine();
        int maxValue = 0;
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                int y=i+1;int x=j+1;
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[y][x] = dp[y-1][x-1] +1;
                    maxValue = Math.max(dp[y][x],maxValue);
                }
            }
        }
        System.out.println(maxValue);
    }
}
