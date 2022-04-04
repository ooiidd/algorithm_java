package programmers.c30l43165;

class Solution {
    public int solve(int[] numbers, int pos, int sum, int target){
        if(pos >= numbers.length)
            if(sum == target)
                return 1;
            else
                return 0;
        int sumCount = 0;
        //덧셋
        sumCount += solve(numbers, pos+1, sum+ numbers[pos], target);
        //뺄셈
        sumCount += solve(numbers, pos+1, sum- numbers[pos], target);

        return sumCount;
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = solve(numbers,0,0,target);
        return answer;
    }
}
