public class Solution {
    //O(n, 1) using tries
    //idea is to store every char node with increasing freq, and then for word qry go to the last char node of pref,
    //and return its min substring
    static class TrieNode{
        TrieNode[] children;
        int freq;
        TrieNode(){
        // initilizing size of nodes(char)
            this.children = new TrieNode[26];
            this.freq = 0;
        }
    }
    static void insertInTrie(TrieNode rootNode, String toInsert){
        //for all char add frq in main root
        rootNode.freq++;
        for(int i=0;i < toInsert.length();i++){
            if(rootNode.children[toInsert.charAt(i)-'a'] == null){
                //new node added for that char index
                rootNode.children[toInsert.charAt(i)-'a'] = new TrieNode();
            }
            //go to that node of next char
            rootNode = rootNode.children[toInsert.charAt(i)-'a'];
            //after going to next node then add freq of that char
            rootNode.freq++;
        }
    }

    static String isUniqueInTrie(TrieNode root, String check){
        int prefOfCheck = 0;
        //to till we found node last node freq 1
        while(root.freq != 1 ){
            root=root.children[check.charAt(prefOfCheck)-'a'];
            prefOfCheck++;
        }
        // return substring, as prefOfCheck is being add at the last
        return check.substring(0, prefOfCheck);
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> res = new ArrayList<String>();
        TrieNode root = new TrieNode();
        //fill tries with strings
        for(int i=0;i < A.size();i++){
            insertInTrie(root, A.get(i));
        }

        // check for smallest till unique node
        for(int i=0;i < A.size();i++){
            String smallestUnique = isUniqueInTrie(root, A.get(i));
            res.add(smallestUnique);
        }

        return res;
    }
}
