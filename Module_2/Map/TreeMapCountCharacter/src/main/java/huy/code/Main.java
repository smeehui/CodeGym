package huy.code;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String str = "Debet omittantur Debet aenean usu fabellas sanctus." +
                " Graeco falli Debet lorem nunc quo nunc velit. Eum eget" +
                " orci dicit dicit dicit nihil non nunc fames bibendum bibendum ." +
                " Graeco falli Debet lorem nunc quo nunc velit. Eum eget" +
                " orci dicit dicit dicit nihil non nunc fames bibendum bibendum ." +
                " Graeco falli Debet lorem nunc quo nunc velit. Eum eget" +
                " orci dicit dicit dicit nihil non nunc fames bibendum bibendum .";
        Map<String, Integer> charMap = new TreeMap<>();
        String[] words = str.split(" ");
        for (String word : words) {
            if (!charMap.containsKey(word)) {
                charMap.put(word.toLowerCase(), 1);
            } else charMap.put(word, charMap.get(word) + 1);
        }
        System.out.println(charMap);
    }
}