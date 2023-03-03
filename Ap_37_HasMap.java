package com.krushnaDSA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ap_37_HasMap {

    public static  boolean anagram(String s , String t){
        if (s.length()!= t.length()){
            return false ;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        for (int i= 0 ; i< s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0)+1);
        }
        for (int i=0 ; i<t.length() ; i++){
            char ch = t.charAt(i);
            if (map.containsKey(ch)){
                if (map.get(ch)==1){
                    map.remove(ch);
                }
                else{
                    map.put(ch , map.get(ch)-1);
                }
            }else{
                return  false ;
            }
        }
        return map.isEmpty();
    }
 // get Start
    public static  String  getStart(HashMap<String  , String > tickets){
        HashMap<String  , String> revMap = new HashMap<>();
        for (String key : tickets.keySet()){
            revMap.put(tickets.get(key) , key);
        }
        for (String  key : tickets.keySet()){
            if (!revMap.containsKey(key)){
                return  key ;
            }
        }
        return null ;
    }



    public static void main(String[] args) {
        //find Itinerary from Ticket
        HashMap<String , String > ticket = new HashMap<>();
        ticket.put("chennai", "bengaluru");
        ticket.put("mumbai", "delhi");
        ticket.put("goa", "chennai");
        ticket.put("delhi", "goa");

        String  start= getStart(ticket);
        for (String  key : ticket.keySet()){
            System.out.println(ticket.get(start));
            start=ticket.get(start);

        }




//        // Count Distinct Element
//
//        int num[] = {4,3,2,5,6,7,3,4,2,1};
//        HashSet<Integer> set = new HashSet<>();
//        for (int i= 0 ; i< num.length ; i++){
//            set.add(num[i]);
//        }
//        System.out.println(set.size());
//
//        System.out.println(anagram("knee" , "pneek"));
////
//        HashMap<String, Integer> hM = new HashMap<>();
//        hM.put("India" , 143);
//        hM.put("China",140);
//        hM.put("USA",50);
//        hM.put("Eng", 42);
//        hM.put("Pakistan", 50);
//        hM.put("Russia" , 80);
//        System.out.println(hM);
//        Set<String > keys = hM.keySet();
//        System.out.println(keys);
//
//        // Majority of element
//        int nums[]={1,3,2,5,1,3,1,5,1};
//        HashMap<Integer , Integer> maps = new HashMap<>();
//        for (int i=0 ; i< nums.length ; i++){
//            int num= nums[i];
//            if (maps.containsKey(num)){
//                maps.put(num , maps.get(num)+1);
//            }
//            else {
//                maps.put(num , 1);
//            }
//        }
//
//        Set<Integer> key1= maps.keySet();
//        System.out.println(key1);



    }
}
