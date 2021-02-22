/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Solution {
    String[] names = new String[] {"Billion", "Million", "Thousand"};
    String[] digits = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens2 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int n = 0;
        int pos = 1000000000;
        while (pos >= 1000) {
            int cur = num / pos;
            if (cur != 0) {
                sb.append(numberToWords(cur));
                sb.append(" ");
                sb.append(names[n]);
                sb.append(" ");
            }
            num %= pos;
            pos /= 1000;
            n++;
        }

        if (num == 0) return sb.substring(0, sb.length() - 1);

        int hundred = num / 100;
        if (hundred != 0) {
            sb.append(digits[hundred]);
            sb.append(" ");
            sb.append("Hundred ");
        }

        num %= 100;
        if (10 <= num && num < 20) {
            sb.append(tens[num % 10]);
            return sb.toString();
        }

        int ten = num / 10;
        if (ten >= 2) {
            sb.append(tens2[ten]);
            sb.append(" ");
        }
        num %= 10;

        if (num == 0) return sb.substring(0, sb.length() - 1);

        sb.append(digits[num]);
        sb.append(" ");

        return sb.substring(0, sb.length() - 1);
    }
}
// @lc code=end

