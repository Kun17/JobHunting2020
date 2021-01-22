import javax.print.attribute.standard.NumberUpSupported;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Solution {
    public String convert(String s, int numRows) {
        // This is a simple math problem, if numRows is n, s.length() is l
        // We create n int[], each arr has a max length of l/n + 1
        // Thus it is a int[n][l/n+1]
        // To save more space, we can use arrayList

        if (numRows == 1) return s;
        
        List<List<Character>> matrix = new ArrayList<List<Character>>(numRows);
        for (int i = 0; i < numRows; i++){
            List<Character> neo = new ArrayList<Character>();
            matrix.add(neo);
        }

        // Creating a sense of zigzag
        int j = 0;
        boolean down = true;
        for(int i = 0; i < s.length(); i++){
            if (down) {
                matrix.get(j).add(s.charAt(i));
                j++;
            } else {
                matrix.get(j).add(s.charAt(i));
                j--;
            }
            // When j goes up and hits top
            if (j == -1) {
                down = true;
                j += 2;
            }
            // When j goes down and hits bottom
            if (j == numRows) {
                down = false;
                j -= 2;
            }
        }
        char[] resCharArr = new char[s.length()];
        int count = 0;
        for (int i = 0; i < numRows; i ++) {
            Iterator<Character> it = matrix.get(i).iterator();
            while( it.hasNext()) {
                resCharArr[count] = it.next();
                count++;
            }
        }
        return String.valueOf(resCharArr);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }
}