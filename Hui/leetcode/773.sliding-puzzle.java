/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(getKey(board));
        visited.add(getKey(board));

        int dist = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals("123450")) return dist;
                int index = -1;
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) == '0') {
                        index = j;
                        break;
                    }
                }

                StringBuilder sb = new StringBuilder(cur);
                int swap = (index + 3) % 6;
                sb = swap(sb, index, swap);
                if (!visited.contains(sb.toString())) {
                    queue.add(new String(sb));
                    visited.add(new String(sb));
                }
                sb = swap(sb, index, swap);

                if (index % 3 == 0 || index % 3 == 1) {
                    swap = index + 1;
                    swap(sb, index, swap);
                    if (!visited.contains(sb.toString())) {
                        queue.add(new String(sb));
                        visited.add(new String(sb));
                    }
                    swap(sb, index, swap);
                }

                if (index % 3 == 1 || index % 3 == 2) {
                    swap = index - 1;
                    swap(sb, index, swap);
                    if (!visited.contains(sb.toString())) {
                        queue.add(new String(sb));
                        visited.add(new String(sb));
                    }
                    swap(sb, index, swap);
                }
            }
            dist++;
        }
        return -1;
    }

    public String getKey(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    public StringBuilder swap(StringBuilder sb, int i, int j) {
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
        return sb;
    }
}
// @lc code=end

