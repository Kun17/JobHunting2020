/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> q1 = new LinkedList<List<String>>();
        Queue<List<String>> q2 = new LinkedList<List<String>>();
        Set<String> words = new HashSet<String>(wordList);
        if (!words.contains(endWord)) return new ArrayList<List<String>>();
        Set<String> visited = new HashSet<String>();
        Map<String, List<List<String>>> cur = new HashMap<String, List<List<String>>>();
        q1.add(new ArrayList<String>(Arrays.asList(beginWord)));
        q2.add(new ArrayList<String>(Arrays.asList(endWord)));

        List<String> endlist = new ArrayList<String>(Arrays.asList(endWord));
        cur.put(endWord, new ArrayList<List<String>>(Arrays.asList(endlist)));
        List<List<String>> ret = new ArrayList<List<String>>();
        while (ret.size() == 0 && q1.size() > 0 && q2.size() > 0) {
            Queue<List<String>> nextQ = new LinkedList<List<String>>();
            Map<String, List<List<String>>> nextCur = new HashMap<String, List<List<String>>>();
            while (q1.size() > 0) {
                List<String> list = q1.poll();
                String str = list.get(list.size() - 1);
                visited.add(str);
                List<String> nexts = getNext(str, words);
                for (String next: nexts) {
                    if (cur.containsKey(next)) {
                        for (List<String> nextList: cur.get(next)) {
                            List<String> subret = new ArrayList<String>(list);
                            // System.out.println(nextList);
                            List<String> nextListReverse = new ArrayList<String>(nextList);
                            Collections.reverse(nextListReverse);
                            subret.addAll(nextListReverse);
                            if (!subret.get(0).equals(beginWord)) {
                                Collections.reverse(subret);
                            }
                            ret.add(subret);
                        }
                    } else if (!visited.contains(next)) {
                        List<String> listcopy = new ArrayList<String>(list);
                        listcopy.add(next);
                        nextQ.add(listcopy);
                        List<List<String>> nextList = nextCur.getOrDefault(next, new ArrayList<List<String>>());
                        nextList.add(listcopy);
                        nextCur.put(next, nextList);
                    }
                }
            }

            q1 = q2;
            q2 = nextQ;
            cur = nextCur;
        }

        return ret;
    }

    public List<String> getNext(String str, Set<String> words) {
        // System.out.println(str + " -----------------------");
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (c == str.charAt(i)) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, i));
                sb.append(c);
                sb.append(str.substring(i + 1, str.length()));
                String next = sb.toString();
                if (words.contains(next)) {
                    ret.add(next);
                    // System.out.println(next);
                }
            }
        }

        return ret;
    }
}
// @lc code=end

