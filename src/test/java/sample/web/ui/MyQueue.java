package sample.web.ui;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
    	
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if(output != null) return output.pop();
    	else {
    		while(input != null)
    			output.push(input.pop());
    		return output.pop();
    	}
    }
    
    /** Get the front element. */
    public int peek() {
    	if(output != null) return output.peek();
    	else {
    		while(input != null)
    			output.push(input.pop());
    		return output.peek();
    	}
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
		return output == null && input == null;
    }
    
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */