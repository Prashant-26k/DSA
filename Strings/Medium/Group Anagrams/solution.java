class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();


        for(int i = 0; i < strs.length ; i++) {
            String key = sortChars(strs[i]);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }

        for (List<String> group : map.values()) {
            answer.add(group);
        }
        return answer;
            
    }

    private String sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
} 