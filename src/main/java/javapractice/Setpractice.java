package javapractice;

import java.util.*;

public class Setpractice {

    public static void main(String[] args){
//        int[] array = {1, 2, 3, 4, 5, 1, 2, 3, 6, 7, 8, 9, 9};
//        System.out.println("Original Array: " + Arrays.toString(array));
//        int[] uniqueArray = removeDuplicatesSet(array);
//        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArray));

        //Reverse a string
        String input = "Hello, World!";
        String reversed = reverseString(input);
        System.out.println(reversed);
        String wordReverse = reverseWord(input);
        System.out.println(wordReverse);
    }

    private static String reverseWord(String input) {
        String[] i = input.split(" ");
        String ret = "";
        for(String j:i)
            ret = ret.concat(reverseString(j));
        return ret;
    }

    private static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }

    public static int[] removeDuplicates(int[] array) {

        return array;
    }

    public static int[] removeDuplicatesSet(int[] array){
        Set<Integer> s = new HashSet<>();
        for(int i:array){
            s.add(i);
        }
        int[] r = new int[s.size()];
        int index = 0;
        for(int i:s){
            r[index++]=i;
        }
        return r;
    }
//    public static String maxCount(int[] array){
//        Map<Integer, Integer> m = new HashMap<>();
//        for(int a: array){
//            if(m.containsKey(a))
//                m.get(a) = m.get(a)+1;
//        }
//    }


}

