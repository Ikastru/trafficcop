package com.example.trafficcop.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RandomUtil {

    private final String appendix = " 116 RUS";
    private List<String> list = new ArrayList(Arrays.asList("А", "Е", "Т", "О", "Р", "Н", "У", "К", "Х", "С", "В", "М"));
    private boolean original;
    private String result;
    private List<String> allNumbers= new LinkedList<>();

    //Функция получения случайной буквы из списка
    public String getRandomElement(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public String getNumber(){
        StringBuilder numberAuto = new StringBuilder();
        String symbol1 = getRandomElement(list);
        String symbol2 = getRandomElement(list);
        String symbol3 = getRandomElement(list);

        int number1 = (int) Math.round(Math.random()*9);
        int number2 = (int) Math.round(Math.random()*9);
        int number3 = (int) Math.round(Math.random()*9);

        numberAuto.append(symbol1);
        numberAuto.append(number1);
        numberAuto.append(number2);
        numberAuto.append(number3);
        numberAuto.append(symbol2);
        numberAuto.append(symbol3);
        numberAuto.append(appendix);

        String data = numberAuto.toString();
        return data;
    }

    public boolean check(String checkString){
        if (allNumbers.isEmpty()){
            return true;
        }
        for (String el: allNumbers) {
            if (!checkString.equals(el)){
                original = true;
            } else {
                original = false;
            }
        }
        return original;
    }

    public String getContents()  {
        String str = getNumber();
        if (check(str)){
            allNumbers.add(str);
            return str;
        } else {
            result = getContents();
        }
        return result;
    }
}