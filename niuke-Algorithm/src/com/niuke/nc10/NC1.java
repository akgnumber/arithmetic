package com.niuke.nc10;

public class NC1 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0,i = s.length() - 1,j = t.length() -1;
        while ( i >= 0|| j >= 0 || carry !=0) {
            int x = i < 0 ? 0 : s.charAt(i --) - '0';
            int y = j < 0 ? 0 : t.charAt(j --) - '0';
            int sum = x + y + carry;
            stringBuilder.insert(0, sum% 10);
            carry = sum / 10;
        }
        return stringBuilder.toString();
    }

    public String solve1 (String s, String t) {
        // write code here
        if (s == null || t == null) {
            return "0";
        }
        long[] array1,array2,array_res,larger,little;
        array1 = getLongArray(s);
        array2 = getLongArray(t);
        if (array1.length >= array2.length) {
            larger = array1;
            little = array2;
        } else {
            larger = array2;
            little = array1;
        }

        boolean carry = false;
        array_res = new long[larger.length];
        for (int i = 0; i < larger.length; i++) {
            long temp ;
            if ( i < little.length) {
                if (carry) {
                    temp = array1[i] + array2[i] + 1;
                } else {
                    temp= array1[i] + array2[i];
                }
                if (temp >= 1000000000000000000l) {
                    carry = true;
                    array_res[i] = temp - 1000000000000000000l;
                }else {
                    carry = false;
                    array_res[i] = temp;
                }
            } else {
                if (carry) {
                    temp = larger[i] + 1;
                } else {
                    temp= larger[i];
                }
                if (temp >= 1000000000000000000l) {
                    carry = true;
                    array_res[i] = temp - 1000000000000000000l;
                }else {
                    carry = false;
                    array_res[i] = temp;
                }
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = larger.length-1; i >=0 ; i--) {
            if (i == larger.length -1 ){
                stringBuilder.append(array_res[i]);
            } else {
                stringBuilder.append(String.format("%018d",array_res[i]));
            }
        }

        return stringBuilder.toString();
    }

    public long[] getLongArray(String number) {
        long[] res;
        if (number.length() <= 18) {
            res = new long[]{Long.parseLong(number)};
        } else {
            int count = (number.length()% 18 ==0) ? number.length()/18: number.length()/18 +1;
            res = new long[count];
            long[] temp = new long[count];
            for (int i = 0; i < count; i++) {
                res[i] = Long.parseLong( number.substring((i==count-1)?0:(number.length() - (i+1)*18),number.length() - i*18));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NC1 nc1 = new NC1();
//        System.out.println(nc1.solve("9","99999999999999999999999999999999999999999999999999999999999994"));
//[275942378416703768, 258888307221656691, 258994789086810959, 1]758574079559248265
//        System.out.println(Long.parseLong("275942378416703768") + Long.parseLong("258888307221656691"));
        System.out.println(Long.MAX_VALUE);
        long temp = 758574079559248265l;
        System.out.println(temp>=1000000000000000000L);
        System.out.println(nc1.solve("1258994789086810959258888307221656691275942378416703768","7007001981958278066472683068554254815482631701142544497"));
    }


}
