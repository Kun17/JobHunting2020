/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Set<String> q1 = new HashSet<String>();
        Set<String> q2 = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        q1.add(beginWord);
        q2.add(endWord);

        int dist = 0;
        while (q1.size() > 0 && q2.size() > 0) {
            dist++;
            Set<String> nextq = new HashSet<String>();
            for (String cur: q1) {
                visited.add(cur);
                if (q2.contains(cur)) {
                    return dist;
                }

                List<String> nexts = getNext(cur, set);
                for (String next: nexts) {
                    if (!visited.contains(next)) {
                        nextq.add(next);
                    }
                }
            }
            if (nextq.size() < q2.size()) {
                q1 = nextq;
            } else {
                q1 = q2;
                q2 = nextq;
            }
        }

        return 0;
    }

    public List<String> getNext(String s, Set<String> set) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (s.charAt(i) == c) continue;
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, i));
                sb.append(c);
                sb.append(s.substring(i + 1, s.length()));
                String next = sb.toString();
                if (set.contains(next)) {
                    ret.add(next);
                }
            }
        }

        return ret;
    }

    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     Set<String> set = new HashSet<String>(wordList);
    //     Set<String> visited = new HashSet<String>();
    //     if(!set.contains(endWord)) return 0;
    //     if(beginWord.length() != endWord.length()) return 0;
    //     char[] ch = new char[26];
    //     for(int i = 0; i < 26; i++) {
    //         ch[i] = (char)('a' + i);
    //     }

    //     Set<String> beginQ = new HashSet<String>();
    //     Set<String> endQ = new HashSet<String>();
    //     beginQ.add(beginWord);
    //     endQ.add(endWord);

    //     int dist = 0;
    //     while(beginQ.size() > 0 && endQ.size() > 0) {
    //         dist++;
    //         if(beginQ.size() > endQ.size()) {
    //             Set<String> tmp = beginQ;
    //             beginQ = endQ;
    //             endQ = tmp;
    //         }
    //         Set<String> nextBeginQ = new HashSet<String>();
    //         for(String cur : beginQ)  {
    //             // add to visited at this point
    //             // add to visited when poll
    //             // this is important
    //             visited.add(cur);
    //             if(endQ.contains(cur)) {
    //                 return dist;
    //             }
    //             for(int j = 0; j < cur.length(); j++) {
    //                 String next = cur;
    //                 for(char c : ch) {
    //                     next = cur.substring(0, j) + c + cur.substring(j + 1);
    //                     if(set.contains(next) && !visited.contains(next) && !beginQ.contains(next)) {
    //                         nextBeginQ.add(next);
    //                         // if place it here, then the beginQ and endQ never get together in the middle.
    //                         // visited.add(next);
    //                     }
    //                 }
    //             }
    //         }
    //         beginQ = nextBeginQ;
            
    //     }

    //     return 0;
    // }
}
// @lc code=end

