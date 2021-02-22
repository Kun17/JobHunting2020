# BFS

### Bidirectional BFS

[Leetcode 127 word-ladder](https://leetcode.com/problems/word-ladder/)

3 tips:

- use `set` instead of queue since need the check the intersection
- add to `visited` when `poll` instead of `add` to `queue` , otherwise never meet in the middle until all nodes have been visited
- remember to compare two queues size, always pick the smallest `q` to find `next`: this would save a lot of time



```java
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
}
```

