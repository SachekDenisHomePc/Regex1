package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexProcessing
{

    public ArrayList<String> ReplaceWords(String source)
    {
        ArrayList<String> words = new ArrayList<>();
        words = new ArrayList<>(Arrays.asList(source.split("_")));
        ArrayList<String> result = new ArrayList<>();
        ShowAllCombinations(words,result,"");
        return result;
    }

    public String DecodeString(String words)
    {
        Pattern pattern = Pattern.compile("[а-я,А-Я,a-z,A-Z]+");
        Matcher matcher = pattern.matcher(words);
        while(matcher.find())
        {
            String tmp = matcher.group();
            String tmpRev = new StringBuilder(tmp).reverse().toString();
            words = words.replaceFirst(tmp,tmpRev);
        }
        return words;
    }

    private static void ShowAllCombinations(ArrayList<String> arr, ArrayList<String> res, String current)
    {
        if (arr.size() == 0) //если все элементы использованы, выводим на консоль получившуюся строку и возвращаемся
        {
            current = current.substring(1);
            res.add(current);
            return;
        }
        for(int i=0;i<arr.size();i++) //в цикле для каждого элемента прибавляем его к итоговой строке, создаем новый список из оставшихся элементов, и вызываем эту же функцию рекурсивно с новыми параметрами.
        {
            ArrayList<String> lst = new ArrayList<String>(arr);
            lst.remove(i);
            ShowAllCombinations(lst, res , current +"_" +arr.get(i));
        }
    }

    public  ArrayList<StringBuilder> SentancesWithDate(String source)
    {
        String dateTempalte = "([0-3][0-9]\\.[0-3][0-2]\\.[0-9][0-9][0-9][0-9])|([0-3][0-9]/[0-3][0-2]/[0-9][0-9][0-9][0-9])|([0-3][0-9]\\.[0-3][0-2]\\.[0-9][0-9])";
        ArrayList<StringBuilder> result = new ArrayList<>();
        ArrayList<String> sentences = new ArrayList<>();
        sentences = new ArrayList<>(Arrays.asList(source.split("[.!?]\\s*")));
        Pattern pattern = Pattern.compile(dateTempalte);
        for (var sent:sentences)
        {
            Matcher matcher = pattern.matcher(sent);
            if(matcher.find())
                result.add(new StringBuilder(sent));
        }
        return result;
    }
}
