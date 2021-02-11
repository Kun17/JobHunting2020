import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    class history {
        int timestamp;
        String website;
        history(int t, String w){
            this.timestamp = t;
            this.website = w;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<history>> userHistory = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for(int i = 0; i < username.length; i++){
            List<history> record = userHistory.getOrDefault(username[i], new ArrayList<>());
            record.add(new history(timestamp[i], website[i]));
            userHistory.put(username[i], record);
        }

        for(Map.Entry<String, List<history>> entry: userHistory.entrySet()){
            List<history> record = entry.getValue();
            record.sort((x, y) -> Integer.compare(x.timestamp, y.timestamp));
            for(int i = 0; i < record.size() - 2; i++){
                for(int j = i + 1; j < record.size() - 1; j++){
                    for(int k = j + 1; k < record.size(); k++){
                        StringBuilder sb =  new StringBuilder();
                        sb.append(record.get(i).website);
                        sb.append(",");
                        sb.append(record.get(j).website);
                        sb.append(",");
                        sb.append(record.get(k).website);
                        String key = sb.toString();
                        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }

        Map<Integer, String> countSequenceMap = new HashMap<>();
        int max = 0;
        for(Map.Entry<String, Integer> entry: countMap.entrySet()){
            int count = entry.getValue();
            max = Math.max(count, max);
            String sequence = entry.getKey();
            if(countSequenceMap.containsKey(count)){
                sequence = countSequenceMap.get(count).compareTo(sequence) < 0 ? countSequenceMap.get(count):sequence;
            }
            countSequenceMap.put(count, sequence);
        }

        String[] resArr = countSequenceMap.get(max).split(",");
        return Arrays.asList(resArr);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        String[] username = new String[]{"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] timestamp = new int[]{527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] website = new String[]{"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        System.out.println(s.mostVisitedPattern(username, timestamp, website));
    }
}