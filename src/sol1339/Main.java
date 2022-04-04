package sol1339;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] count;
        String[] str;
        int curPoint = 7;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        count = new int[26];
        str = new String[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String cur = st.nextToken();
            StringBuffer sbuffer = new StringBuffer(cur);
            str[i]=sbuffer.toString();//뒤집어서 저장

            for(int j=0;j<str[i].length();j++){
                char c = str[i].charAt(j);
                count[c-'A'] += Math.pow(10,str[i].length()-(j+1));
            }
        }
        Arrays.sort(count);
        int result = 0;
        int num = 9;
        for(int i=25;i>=0;i--){
            if(count[i]>0){
                result += count[i]*num;
                num--;
            }
        }
        sb.append(result+"\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    public static int[] reset(int[] arr){
        return Arrays.stream(arr).map((e) -> 0).toArray();
    }
}
