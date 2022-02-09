public class Solution {
    // O(n, 1) space is optimized and clost to 1 as constant char size
    //idea is to implement tries for words,
    // every trie node will have child Trienodes of 26 size, and a boolean val for marking end of word
    static TrieNode root;
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            this.isEndOfWord = false;
            this.children = new TrieNode[26];
        }
    }

    static void insert(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode rootTrav = root;
        //taking static global root as root, checking for char at every level
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            //if node for that char not present add new node
            if(rootTrav.children[index] == null){
                rootTrav.children[index] = new TrieNode();
            }
            //go ot new node
            rootTrav = rootTrav.children[index];
        }
        //mark end of word as true
        rootTrav.isEndOfWord = true;
    }

    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode rootTrav = root;
        //now checking if every char is present or not, if in middle found null return false
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (rootTrav.children[index] == null){
                //if null found, false
                return false;
            }
            //else go to the end
            rootTrav = rootTrav.children[index];
        }
        // if last node exist and having isEndOfWord true then only return found true
        return (rootTrav != null && rootTrav.isEndOfWord);
    }

    public int[] solve(String[] A, String[] B) {
        //putting new root value in global static root
        int[] res = new int[B.length];
        root = new TrieNode();
        //add all to trie
        for (String temp: A){
            insert(temp);
        }
        // check if work exist in trie or not, 0/1 from search function
        for (int i = 0; i < B.length; i++) {
            if (search(B[i])){
                res[i] = 1;
            }else{
                res[i] = 0;
            }
        }
        return res;
    }
}