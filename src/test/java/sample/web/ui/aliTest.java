package sample.web.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class aliTest {
	public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        Stack<String> stk = new Stack<>();
        
        String[] input = expr.split(" +");
        for(int i = 0; i < input.length; i++) {
        	if(input[i].equals("*")) {
        		if(stk.isEmpty()) return -1;
        		int first = Integer.valueOf(stk.pop());
        		if(stk.isEmpty()) return -1;
        		int second = Integer.valueOf(stk.pop());
        		stk.push(String.valueOf(first * second));
        	}
        	else if(input[i].equals("+")) {
        		if(stk.isEmpty()) return -1;
        		int first = Integer.valueOf(stk.pop());
        		if(stk.isEmpty()) return -1;
        		int second = Integer.valueOf(stk.pop());
        		stk.push(String.valueOf(first + second));
        	}
        	else if(input[i].equals("^")) {
        		if(stk.isEmpty()) return -1;
        		stk.push(String.valueOf(Integer.valueOf(stk.pop()+1)));
        	}
        	else {
        		if(stk.size() == 16) return -2;
        		stk.push(input[i]);
        	}
        }
        return Integer.valueOf(stk.peek());
    }
}
