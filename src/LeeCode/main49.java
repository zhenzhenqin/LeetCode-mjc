package LeeCode;

import java.util.*;

public class main49 {
    /**
     * leetcode 49 字母异位词分组
     */
    class Solution {

        //将字符串进行遍历排序 如：eat ate eta排序后都是aet
        //将排序后的字符串做为key  原来的字符做为value 存入hashmap中 那么排序过后的一样的字符串回归为一组
        //                           |||此时如果map不存在这个key， 则说明之前没有相同的 则插入一个新的包含这个key的value数组
        //                           |||如果map中存在这个key，则说明已经有相同的（aet） 则获取到对应的value并插入（归为一组）
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String , List<String>> map = new HashMap<>();
            //遍历数组 将每一个字符进行排序 如bac 和 cab 都变成abc 存入map中
            for (String str : strs) {
                char[] ns = str.toCharArray();
                Arrays.sort(ns); //将字符进行排序
                String s = new String(ns);
                //排序后的作为key
                if(map.get(s) == null){
                    // 如果key不存在 就新建一个数组去存
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(s, list);
                } else {
                    //map中存在key, 则获取到对应的value并插入
                    List<String> l = map.get(s);
                    l.add(str);
                    map.put(s, l);
                }

            }
            return new ArrayList<>(map.values());
        }
    }
}
