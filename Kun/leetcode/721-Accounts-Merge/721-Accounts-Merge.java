import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


class Solution {
    Map<Integer, String> nameMap;
    Map<Integer, Set<String>> sets;
    Map<String, Integer> parents;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        nameMap = new HashMap<>();
        sets = new HashMap<>();
        parents = new HashMap<>();
        
        //initialization
        for(int i = 0; i < n;i++){
            List<String> account = accounts.get(i);
            nameMap.put(i, account.remove(0));
            Set<Integer> roots = new HashSet<>();
            Set<String> set = new HashSet<>();
            for(String email: account){
                if(parents.containsKey(email)) roots.add(parents.get(email));
            }
            for(String email: account){
                parents.put(email, i);
                set.add(email);
            }
            sets.put(i, set);
            if(!roots.isEmpty()){
                int pre = i;
                for(Integer root: roots){
                    union(pre, root);
                    pre = root;
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(int root: sets.keySet()){
            String name = nameMap.get(root);
            List<String> emails = new ArrayList<>(sets.get(root));
            emails.sort((x,y) -> x.compareTo(y));
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }

    // x -> y
    private void union(int x, int y){
        if(sets.get(x).size() > sets.get(y).size()){
            int temp = x;
            x = y;
            y = temp;
        }
        Set<String> setX = sets.get(x);
        Set<String> setY = sets.get(y);
        for(String email: setX){
            parents.put(email, y);
            setY.add(email);
        }
        sets.remove(x);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        String[][] data = new String[][]{
            {"David","David0@m.co","David1@m.co"},
            {"David","David3@m.co","David4@m.co"},
            {"David","David4@m.co","David5@m.co"},
            {"David","David2@m.co","David3@m.co"},
            {"David","David1@m.co","David2@m.co"}
        };
        List<List<String>> accounts = new ArrayList<>();
        for(String[] account: data){
            List<String> ele = new ArrayList<>(Arrays.asList(account));
            accounts.add(ele);
        }
        System.out.println(s.accountsMerge(accounts));
    }
}