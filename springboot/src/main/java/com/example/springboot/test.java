package com.example.springboot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/11 19:54
 */
public class test {
    public static void main(String[] args) {
//        String receiveMsg = "你好! >< 12";
//        String[] strings = receiveMsg.split(" >< ");
//        String msg = strings[0];
//        System.out.println(strings[0]);
//        System.out.println(strings[1]);
//        long nowTime = System.currentTimeMillis();
//        System.out.println(nowTime);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
//        String s = dateFormat.format(new Date());
//        System.out.println(s);
//        try {
//            Date date = dateFormat.parse("2020-11-20 13:12:12");
//            long time1 = date.getTime();
//            System.out.println(time1);
//            Date date2 = dateFormat.parse("2020-11-20 12:12:12");
//            long time2 = date2.getTime();
//            System.out.println(time2);
//            System.out.println(time1-time2);
//            System.out.println(" s"+24*46800000);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        String a = "1233321123";
//        System.out.println("subString: "+a.substring(0,a.length()));
//        String s = longestPalindrome(a);
//
//        System.out.println("最长的回文数为: "+s);

//        String a = "abc";
//        String b ="cabcabca";
////        String a = "a";
////        String b ="aa";
//        int i = repeatedStringMatch(a, b);
//        System.out.println(i+"次后a包含b");

//        String[][] board1= {{"1", "d"},{"", ""}};
//        int [] a= {1, 2, 1, 2};
//        String[][] board = {{"5","3",".",".","7",".",".",".","."}
//    ,{"6",".",".","1","9","5",".",".","."}
//    ,{".","9","8",".",".",".",".","6","."}
//    ,{"8",".",".",".","6",".",".",".","3"}
//    ,{"4",".",".","8",".","3",".",".","1"}
//    ,{"7",".",".",".","2",".",".",".","6"}
//    ,{".","6",".",".",".",".","2","8","."}
//    ,{".",".",".","4","1","9",".",".","5"}
//    ,{".",".",".",".","8",".",".","7","9"}};

//        String s = "PAYPALISHIRING";
//        int numRows = 4;
//        String convert = convert(s, numRows);


//        String s = "?";
//        String s1 = modifyString(s);
//        System.out.println(
//                s1
//        );

//        给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
//
//        输入为三个整数：day、month 和 year，分别表示日、月、年。
//
//        您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
//        w=y+[y/4]+[c/4]-2c+[26(m+1)/10]+d-1
        String s = dayOfTheWeek(29, 2, 2000);
        System.out.println(s);
    }
    public static String dayOfTheWeek(int day, int month, int year) {
        String [] rs = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        int c = year/100;
        int y = year-c*100;
        int m = month;
        int d = day;
        if (month==1){
            y-=1;
            m=13;
        }
        if (month==2){
            y-=1;
            m=14;
        }
        System.out.println(c+" "+y+" "+m+" "+d);
        int w=y+(y/4)+(c/4)-2*c+(26*(m+1)/10)+d-1;
        System.out.println(w);
        return rs[w%7];
    }

    //返回不重复字符串
//    public static String modifyString(String s) {
//        char[] chars = s.toCharArray();
//        String s1 = "";
//        String[] split = s.split(s);
//        return s1;
//    }
    //返回不重复字符串
//    public static String modifyString(String s) {
//        if ("?".equals(s))
//            return "a";
//        char[] chars = s.toCharArray();
//        String s1 = "";
//        for (int i = 0; i < chars.length; i++) {
//            if ('?'==chars[i]){//将?替换为字母,且不能与前后相同
//                if (i == 0){
//                    chars[i] = get('0', chars[i + 1]);
//                }
//                else if (i == chars.length - 1)
//                    chars[i] = get(chars[i - 1], '0');
//                else
//                    chars[i] = get(chars[i - 1], chars[i + 1]);
//            }
//                s1 += chars[i];
//        }
//        return s1;
//    }
//    public static char get(char a,char b) {
//        char[] chars = {'a','b','c','d','e','f','g','h','i','j',
//                        'k','l','m','n','o','p','q','r','s','t',
//                        'u','v','w','x','y','z'};
//        char rs = ' ';
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i]!=a && chars[i]!=b){
//                rs = chars[i];
//                break;
//            }
//
//        }
//        return rs;
//    }

//    输入：s = "PAYPALISHIRING", numRows = 4
//    输出："PINALSIGYAHRPI"
//    解释：
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I

//    1P 7I I  13N
//    2A 6L 8S 12I
//    3Y 5A 9H 11R
//    4P P  10I I
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        for (char b:chars) {
            System.out.println(b);
        }
//        for (int i = 1; i <= numRows; i++) {
//
//        }
//        System.out.print(chars[0/4=0]);6/4=2
        System.out.print(chars[0+2*(numRows-1)*1]);
        System.out.print(chars[0+2*(numRows-1)*2]);
        System.out.print(chars[1]);
        System.out.print(chars[1+2*(numRows-1)*2]);
        System.out.print(chars[1+2*(numRows-1)*1]);
//        System.out.print(chars[0]);
//        System.out.print(chars[0]);
//        System.out.print(chars[0]);
//        System.out.print(chars[0]);
//        System.out.print(chars[0]);
//        System.out.print(chars[0]);
        return "";
    }

    //判断数独是否有效
    public boolean isValidSudoku(char[][] board) {
        return false;
    }

    //a重复叠加几次后包含b
    public static int repeatedStringMatch(String a, String b) {
        if (a==b)
            return 1;
        String ra = a;
        int res = 1;

        while(!ra.contains(b)){
            ra+= a;
            res++;
            System.out.println(ra);
            System.out.println(res);

            if (ra.length()>b.length()+2*a.length()){
                return -1;
            }
        }
        return res;
    }

    //切割字符串然后判断是否回文
    public static String longestPalindrome(String s) {
        System.out.println(s+"的个数为: "+s.length());
        for (int i = s.length(); i >= 0; i--) {//分割的长度
            for (int j = 0; j < s.length()-i; j++) {//分的位置
                //切出来的数组
                String substring = s.substring(j, j+i+1);
                System.out.println(substring);
                if (isPalindrome(substring)){
                    return substring;
                }
            }
        }
        return null;
    }

    //判断回文数,先转字符串
    public static boolean isPalindrome(String x) {
        char[] chars = x.toCharArray();
//        System.out.println(x+"的个数为: "+chars.length);
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i]!=chars[chars.length-1-i])
                return false;
        }
        return true;
    }

}
