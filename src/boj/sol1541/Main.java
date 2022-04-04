package boj.sol1541;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
//        String input = "55-50+40";
        Deque<Integer> number_stack = new LinkedList<>();
        Deque<Integer> number_stack2 = new LinkedList<>();
        Deque<Character> op_stack = new LinkedList<>();

        String[] num = input.split("\\+|-");
        for(String s : num){
            number_stack.add(Integer.parseInt(s));
        }
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c == '+' || c=='-'){
                op_stack.add((c));
            }
        }

        while(!op_stack.isEmpty()){
            char c = op_stack.pollLast();
            if(c=='+'){
                int firstNum = number_stack.pollLast();
                int secondNum = number_stack.pollLast();
                number_stack.add(firstNum+secondNum);
            }
            else{
                int firstNum = number_stack.pollLast();
                number_stack2.add(firstNum);
            }
        }
        if(!number_stack.isEmpty()){
            number_stack2.add(number_stack.pollLast());
        }

        while(number_stack2.size()>1){
            int firstNum = number_stack2.pollLast();
            int secondNum = number_stack2.pollLast();
            number_stack2.add(firstNum-secondNum);
        }
        int result = number_stack2.peek();
        System.out.println(result);
    }
}
