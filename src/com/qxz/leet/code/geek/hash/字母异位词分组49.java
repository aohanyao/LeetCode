package com.qxz.leet.code.geek.hash;


import java.util.*;

//https://leetcode-cn.com/problems/group-anagrams/
public class 字母异位词分组49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupAnagrams = groupAnagrams(strs);

        for (List<String> groupAnagram : groupAnagrams) {
            for (String s : groupAnagram) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 1.边界条件
        if (strs.length == 0) return new ArrayList();

        // 2.创建map
        Map<String, List<String>> ans = new HashMap<>();

        // 3.遍历字符串
        for (String str : strs) {
            // 4.获取字符数组
            char[] chars = str.toCharArray();
            // 5.字符数组排序
            Arrays.sort(chars);
            // 6.转回字符串
            String key = String.valueOf(chars);
            // 7.判断map
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }
        // 8.返回数组
        return new ArrayList(ans.values());
    }
}
