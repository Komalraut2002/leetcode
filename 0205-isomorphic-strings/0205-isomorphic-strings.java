class Solution {
    public boolean isIsomorphic(String s, String t) {
                Map<Character, Character> mapChars = new HashMap<>(26);
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(int i=0;i<s.length();i++){
            if(mapChars.containsKey(sChars[i])){
                if(mapChars.get(sChars[i]) != tChars[i])
                    return false;
            } else{
                    if(mapChars.containsValue(tChars[i]))
                        return false;
                    mapChars.put(sChars[i], tChars[i]);      
            }               
        }
        return true;
    }
}