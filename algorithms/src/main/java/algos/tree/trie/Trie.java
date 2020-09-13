package algos.tree.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }

}

public class Trie {
    private TrieNode root = new TrieNode();

    // iterative
    public void addString(String word) {
        TrieNode current = root;

        for (char c:word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }

        current.endOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }


    public boolean searchInNode(String word, TrieNode node) {
        TrieNode current = node;
        for(int i=0; i<word.length(); i++) {
            if(!current.children.containsKey(word.charAt(i))) {
                if(word.charAt(i) == '.') {
                    // continue search excluding . and post characters in subchilds
                    for(char c:current.children.keySet()) {
                        return searchInNode(word.substring(i+1), current.children.get(c));
                    }
                }
            }
            // character exist
            current = current.children.get(word.charAt(i));
        }

        return current.endOfWord;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addString("bad");
        trie.addString("dad");
        trie.addString("mad");

        System.out.println(trie.search("d.d"));
    }


}
