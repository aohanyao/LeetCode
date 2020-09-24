package com.qxz.leet.code.geek.stack;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 有效的括号20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    /**
     * https://leetcode-cn.com/problems/valid-parentheses/
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public static boolean isValid(String s) {
        // 解法2，暴力遍历字符串
        while (s.contains("[]") || s.contains("{}") || s.contains("()")) {
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            s = s.replace("()", "");
        }
        return s.equals("");
    }

    /**
     * 解法一：
     * 将对应的键值对存放到map中，每轮循环首选判断是否左闭合的字符串，是，则添加到stack中
     * 二次遍历以当前char为key，然后从map中取出value进行对比，对不上则直接返回false
     *
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        // 极限情况的处理
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        // 创建map规则来做判断
        HashMap<Character, Character> role = new HashMap<>();
        role.put('?', '?');
        role.put('[', ']');
        role.put('{', '}');
        role.put('(', ')');
        //创建栈
        LinkedList<Character> stack = new LinkedList<>();
        stack.add('?');

        for (char c : s.toCharArray()) {
            if (role.containsKey(c)) stack.addLast(c);// 添加 (
            else if (role.get(stack.removeLast()) != c) return false;// remove (，取出 )和当前C进行对比
        }
        return stack.size() == 1;
    }
}
