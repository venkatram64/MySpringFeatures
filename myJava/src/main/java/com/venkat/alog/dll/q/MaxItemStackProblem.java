package com.venkat.alog.dll.q;

public class MaxItemStackProblem {

    private java.util.Stack<Integer> mainStack;
    private java.util.Stack<Integer> maxStack;

    public MaxItemStackProblem(){
        this.mainStack = new java.util.Stack<>();
        this.maxStack = new java.util.Stack<>();
    }

    public void push(int item){
        //push the new item into the stack
        mainStack.push(item);
        //first item is the same in both stacks
        if(mainStack.size() == 1){
            maxStack.push(item);
            return;
        }
        //if the item is the largest one so far, we insert it onto the stack
        if(item > maxStack.peek()){
            maxStack.push(item);
        }else{
            //if not the largest one then we duplicate the largest one on the maxStack
            maxStack.push(maxStack.peek());
        }
    }

    //when removing an item we remove it from both stacks
    public int pop(){
        maxStack.pop();
        return maxStack.pop();
    }

    //max item is the last item we have inserted into the maxStack O(1)
    public int getMaxItem(){
        return maxStack.peek();
    }

    public static void main(String[] args) {
        
        MaxItemStackProblem maxItemStackProblem = new MaxItemStackProblem();
        maxItemStackProblem.push(10);
        maxItemStackProblem.push(5);
        maxItemStackProblem.push(1);
        maxItemStackProblem.push(12);
        maxItemStackProblem.push(11);

        System.out.println(maxItemStackProblem.getMaxItem());
    }
}
