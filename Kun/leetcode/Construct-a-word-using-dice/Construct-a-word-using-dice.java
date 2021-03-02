// Given a word of length n and n six-sided dice with a character in each side. Find out if this word can be constructed by the set of given dice.

// Example 1:

// Input:
// word = "hello"
// dice = [[a, l, c, d, e, f], [a, b, c, d, e, f], [a, b, c, h, e, f], [a, b, c, d, o, f], [a, b, c, l, e, f]]
// Output: true
// Explanation: dice[2][3] + dice[1][4] + dice[0][1] + dice[4][3] + dice[3][4]
// Example 2:

// Input:
// word = "hello"
// dice = [[a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f]]
// Output: false
// Example 3:

// Input:
// word = "aaaa"
// dice = [[a, a, a, a, a, a], [b, b, b, b, b, b], [a, b, c, d, e, f], [a, b, c, d, e, f]]
// Output: false

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    int n;
    Set<Character>[] diceSet;
    boolean res;
    public boolean canConstructWord(String word, char[][] dice){
        //brutal force using backtracking
        //time complexity: O(n!)
        //space complexity: O(n)
        n = dice.length;
        diceSet = new Set[n];
        for(int i = 0; i < n; i++){
            diceSet[i] = new HashSet<Character>();
            for(int j = 0; j < 6; j++){
                diceSet[i].add(dice[i][j]);
            }
        }

        Set<Integer> path = new HashSet<>();
        Set<Integer> remains = new HashSet<>();
        for(int i = 0; i < n; i++){
            remains.add(i);
        }
        backtracking(word,0,remains,path);
        return res;
    }

    private void backtracking(String word, int s, Set<Integer> remains, Set<Integer> path){
        if(s == n) {
            res = true;
            return;
        }
        List<Integer> rl = new ArrayList<>(remains);
        for(int i: rl){
            if(!path.contains(i) && diceSet[i].contains(word.charAt(s))){
                path.add(i);
                remains.remove(i);
                backtracking(word, s+1, remains, path);
                path.remove(i);
                remains.add(i);
            }
        }
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        char[][] dice = new char[][]{
            {'a', 'l', 'c', 'd', 'e', 'f'}, 
            {'a', 'b', 'c', 'd', 'e', 'f'}, 
            {'a', 'b', 'c', 'h', 'e', 'f'}, 
            {'a', 'b', 'c', 'd', 'o', 'f'}, 
            {'a', 'b', 'c', 'l', 'e', 'f'}
        };
        String word = "hello";
        System.out.println(s.canConstructWord(word, dice));
        s = new Solution();
        dice = new char[][]{
            {'a', 'a', 'a', 'a', 'a', 'a'}, 
            {'b', 'b', 'b', 'b', 'b', 'b'}, 
            {'a', 'b', 'c', 'd', 'e', 'f'}, 
            {'a', 'b', 'c', 'd', 'e', 'f'}
        };
        word = "aaaa";
        System.out.println(s.canConstructWord(word, dice));
    }
}
