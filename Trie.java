// Java implementation of search and insert operations on Trie
// This code is contributed by Sumit Ghosh
// Modified by David John, March 2020
// Modified by Alexa Brown for Lab 3, March 2020
//Most modifications made by Alexa Brown are indicated with a //*

public class Trie {

    // class variables
    static final int ALPHABET_SIZE = 26; //each node may have 26 nodes coming off of it
    static TrieNode root; //where to start each time

    // trie node internal class
    private static class TrieNode
    {
        // reference to next child
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; //array of size 26

        // isEndOfWord is true if the node represents end of a word
        boolean isEndOfWord; //like colored circle in animation

        // default constructor for node, not a terminal and set all references to null
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    //default constructor for root
    public Trie() {
        root = new TrieNode(); //root declared as a TrieNode
    }


    // If not present, inserts key into trie
    // If the key is prefix of trie node, just marks leaf node
    public static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null){
                pCrawl.children[index] = new TrieNode();}
            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Check str to see if it is either a word in the lexicon or the prefix of a word
    // If neither, move on to next word
    // This method is used in the Main method, under the FindWordsUtil method
    // Returns:
    //   -1 if str is not a word or a prefix of any word in the word list
    //    0 if str is a prefix of a word but not a complete word
    //    1 if str is a complete word in the word list
    public static int prefix(String key) //*added prefix method
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) //cycle through the entire word to ensure all letters are looked for
        {
            index = key.charAt(level) - 'a'; //subtract an 'a' from the current character

            if (pCrawl.children[index] == null) {
                return -1; //*it is not in the Trie
            }

            else if (search(key)){ //*use the search method in Trie to see if the prefix is the whole word
                return 1;
                //*prefix is the whole word
            }

            pCrawl = pCrawl.children[index];
        }

        return 0;
        //*if it is there but not a whole word, it is a prefix for a word
    }

    // Returns true if key is present in trie, else false
    public static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a'; //subtract an a from the current character

            if (pCrawl.children[index] == null)
                return false; //it is not there

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

}

