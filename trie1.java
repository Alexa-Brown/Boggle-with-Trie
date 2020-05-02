import java.util.ArrayList;


//will get actual class soon

public class trie1 {
    static class TrieNode{
        ArrayList<TrieNode> node;
        String nodevalue;
        TrieNode() { //constructor
            node = new ArrayList<TrieNode>(26);
            //now set each reference to null
            for (int i = 0; i < 26; i++) {
                node = null;
                nodevalue = null;
            }
            //setters and getters

            //most important node is the root
        }
    }
    private TrieNode root;
    void Trie(){
        root = new TrieNode();
    }
   // find (String x)
    //add (String)
    //not adding in this assignment

}
