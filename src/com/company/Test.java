package com.company;

import java.util.Scanner;

public class Test
{
    Input input = new Input();
    RegexProcessing regexProcessing = new RegexProcessing();

    void MenuTest()
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("Первое задание");
            System.out.println("Второе задание");
            System.out.println("Третье задание");
            System.out.println("Четвертое задание");
            int select = in.nextInt();
            switch(select)
            {
                case 1: FirstQuest();
                    break;
                case 2:SecondQuest();
                    break;
                case 3: ThirdQuest();
                    break;
            }
        }
    }

    void FirstQuest()
    {
        System.out.println("Введите изначальную строку");
        String string = input.InputLine();
        var strings = regexProcessing.ReplaceWords(string);
        for(var curString:strings)
        {
            System.out.println(curString);
        }
    }

    void SecondQuest()
    {
        String words = input.InputLine();
        words = regexProcessing.DecodeString(words);
        System.out.println(words);
        words = regexProcessing.DecodeString(words);
        System.out.println(words);
    }

    void ThirdQuest()
    {
        System.out.println("Введите изначальную строку");
        String words = input.InputLine();
        var result = regexProcessing.SentancesWithDate(words);
    }




}
