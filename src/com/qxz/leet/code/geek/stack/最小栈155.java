package com.qxz.leet.code.geek.stack;

import java.util.Stack;

public class 最小栈155 {

    public static void main(String[] args) {

    }

    class MinStack {
        // 解决方案是创建两个 stack
        // 一个存储的stack，一个minStack
        private Stack<Integer> stack;
        private Stack<Integer> minStack;


        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            // 当前的数 比最小栈中的要小，直接加入
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek()))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {

            return minStack.peek();
        }
    }

}
