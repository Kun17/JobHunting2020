class AutocompleteSystem {
    
    Map<String, Sentence> sentences;
    Node root;
    Node cur;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new Node();
        this.sentences = new HashMap<>();
        this.cur = root;
        this.sb = new StringBuilder();
        
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i], null);
        }
    }
    
    // time: O(n^2 logm) where n = s.length(), m = number of sentences in the tree
    public void insert(String s, int t, Sentence old) {
        Sentence sentence = new Sentence(s, t);
        sentences.put(s, sentence);
        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            Node next;
            if (node.nexts.containsKey(s.charAt(i))) {
                next = node.nexts.get(s.charAt(i));
            } else {
                next = new Node();
                node.nexts.put(s.charAt(i), next);
            }
            next.top.add(sentence);
            if (old != null) {
                next.top.remove(old);
            }
            // System.out.println(next.top.size());
            node = next;
        }
    }
    
    // time: O(nlogm) for not-'#', O(insert) for '#'
    public List<String> input(char c) {
        List<String> list = new ArrayList<>();
        if (c == '#') {
            String sentence = sb.toString();
            if (sentences.containsKey(sentence)) {
                insert(sentence, sentences.get(sentence).freq + 1, sentences.get(sentence));
            } else {
                insert(sentence, 1, null);
            }
            sb = new StringBuilder();
            cur = root;
        } else {
            sb.append(c);
            Node next = null;
            if (cur != null && cur.nexts.containsKey(c)) {
                next = cur.nexts.get(c);
                int count = 0;
                Iterator i = next.top.iterator();
                // System.out.println(next.top.size());
                while (count < 3 && i.hasNext()) {
                    Sentence sentence = (Sentence) i.next();
                    list.add(sentence.sentence);
                    // System.out.println(sentence);
                    count++;
                }
            }
            cur = next;
        }
        
        return list;
    }
    
    class Node {
        TreeSet<Sentence> top;
        Map<Character, Node> nexts;
        public Node() {
            nexts = new HashMap<>();
            top = new TreeSet<>(new Comparator<Sentence>() {
                public int compare(Sentence a, Sentence b) {
                    if (a.freq == b.freq) {
                        return a.sentence.compareTo(b.sentence);
                    }
                    return b.freq - a.freq;
                }
            });
        }
    }
    
    class Sentence {
        String sentence;
        int freq;
        public Sentence(String sentence, int freq) {
            this.sentence = sentence;
            this.freq = freq;
        }
    }
    
    
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
