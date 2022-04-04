package programmers.openchat;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] ex1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(ex1)));;
    }
}
