import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    // class hold{
    //     String word,
    //     int cnt,
    //     hold(String w, int c){this.word = w; this.cnt = c;}
    // }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int L = beginWord.length();

        Map<String, List<String>> transToWordMap = new HashMap<>();
        Map<String, List<String>> wordToTransMap = new HashMap<>();
        List<String> wholeWordList = new LinkedList<>(wordList);
        if(!wholeWordList.contains(beginWord)) wholeWordList.add(beginWord);
        //wholeWordList.add(endWord);

        wordList.forEach(
            word -> {
                for (int i = 0; i < L; i++){
                    String newWord = word.substring(0, i) + '*' + word.substring(i+1,L);
                    List<String> originals = transToWordMap.getOrDefault(newWord, new ArrayList<>());
                    originals.add(word);
                    transToWordMap.put(newWord, originals);
                }
            }
        );

        wholeWordList.forEach(
            word -> {
                List<String> transformations = new LinkedList<>();
                for (int i = 0; i < L; i++){
                    String newWord = word.substring(0, i) + '*' + word.substring(i+1,L);
                    transformations.add(newWord);
                }
                wordToTransMap.put(word, transformations);
            }
        );


        Queue<String> q = new LinkedList<>();
        int count = 0;
        q.add(beginWord);
        Set<String> endCheck = new HashSet<>(wordToTransMap.get(endWord));
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curWord = q.poll();
                List<String> transformations = wordToTransMap.get(curWord);
                for (String trs: transformations){
                    List<String> nexts = transToWordMap.get(trs);
                    if (nexts != null) nexts.remove(curWord);
                }
                for (String trs: transformations){
                    if(endCheck.contains(trs)) return count+1;
                    List<String> nexts = transToWordMap.get(trs);
                    if (nexts != null){
                        for (String next: nexts){
                            q.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int ladderLength_OneDirBFS(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();

        Map<String , List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
            word -> {
                for (int i = 0; i < L; i++){
                    String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
                    List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                    transformations.add(word);
                    allComboDict.put(newWord, transformations);
                }
            }
        );

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        q.add(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int res = 1;

        while(!q.isEmpty()){
            String curWord = q.poll();
            if (curWord == null) {
                res++;
                if(!q.isEmpty()) q.add(null);
                continue;
            }
            for(int i = 0; i < L; i++){
                String newWord = curWord.substring(0, i) + '*' + curWord.substring(i+1, L);
                for(String next: allComboDict.getOrDefault(newWord, new ArrayList<>())){
                    if(next.equals(endWord)){
                        return res + 1;
                    }
                    if(!visited.contains(next)) q.add(next);
                    visited.add(next);
                }
            }
        }
        return 0;
    }

    int L;
    Map<String , List<String>> trsToOriginalMap;
    public int ladderLength_TwoDirBFS(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        this.L = beginWord.length();

        this.trsToOriginalMap = new HashMap<>();

        wordList.forEach(
            word -> {
                for (int i = 0; i < L; i++){
                    String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
                    List<String> transformations = trsToOriginalMap.getOrDefault(newWord, new ArrayList<>());
                    transformations.add(word);
                    trsToOriginalMap.put(newWord, transformations);
                }
            }
        );

        Queue<String> qFwd = new LinkedList<>();
        qFwd.add(beginWord);
        qFwd.add(null);

        Queue<String> qBwd = new LinkedList<>();
        qBwd.add(endWord);
        qBwd.add(null);

        Map<String, Integer> fwdLevel = new HashMap<>();
        fwdLevel.put(beginWord, 0);

        Map<String, Integer> bwdLevel = new HashMap<>();
        bwdLevel.put(endWord, 1);

        while(!qFwd.isEmpty() || !qBwd.isEmpty()){
            int ans = visitWord(qFwd, fwdLevel, bwdLevel);
            if(ans > -1) return ans;

            ans = visitWord(qBwd, bwdLevel, fwdLevel);
            if(ans > -1) return ans;
        }
        return 0;
    }

    int visitWord(Queue<String> q, Map<String, Integer> Level, Map<String, Integer> OtherLevel){
        while(!q.isEmpty()){
            String curWord = q.poll();
            if(curWord == null) {
                if(!q.isEmpty()) q.add(null);
                return -1;
            }
            int curLevel = Level.get(curWord);

            for (int i = 0; i < L; i++){
                String newWord = curWord.substring(0, i) + "*" + curWord.substring(i+1, L);
                for(String next: trsToOriginalMap.getOrDefault(newWord, new ArrayList<>())){
                    if(OtherLevel.containsKey(next)) {
                        return OtherLevel.get(next) + curLevel;
                    }
                    if(!Level.containsKey(next)) {
                        q.add(next);
                        Level.put(next, curLevel+1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        List<String> wordList = Arrays.asList(new String[]{"hit", "hat"});
        System.out.println(s.ladderLength_TwoDirBFS("hit", "hat", wordList));
    }
}