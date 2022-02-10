public class Solution {
    //O(n, 1)
    //idea is to add words into tries, storing freq, for qry(pref) go to the last word and return its freq
    static class TrieNode{
        //by default 1 freq of new node
        TrieNode children[];
        int frqOfthisChar;
        TrieNode(){
            this.children = new TrieNode[26];
            frqOfthisChar = 0;
        }
    }

    void insertInTrie(TrieNode root, String toInsert){
        //adding freq to the root node for every word added
        root.frqOfthisChar++;
        for(int i=0;i < toInsert.length();i++){
            if(root.children[toInsert.charAt(i)-'a'] == null){
                // first char
                root.children[toInsert.charAt(i)-'a'] = new TrieNode();
            }   //same char is being repeated for different word
            //moving to next node
            root = root.children[toInsert.charAt(i)-'a'];
            root.frqOfthisChar++;
        }
    }
    int searchInTrie(TrieNode root, String pref){
        //go to that last char in to find pref, return freq
        for(int i=0;i < pref.length();i++){
            if(root==null){
                return 0;
            }
            root = root.children[pref.charAt(i)-'a'];
        }
        //reached last char of pref
        if(root!=null){
            return root.frqOfthisChar;
        }else{
            return 0;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        TrieNode root = new TrieNode();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i < A.size();i++){
            if(A.get(i) == 0){
                //insert word
                insertInTrie(root, B.get(i));
            }else{
                //search count
                res.add(searchInTrie(root, B.get(i)));
            }
        }
        return res;
    }
}
