package tries;

import java.util.Set;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        
        
        System.out.println(trie.prefixValid("tr"));
        System.out.println(trie.prefixValid("hi"));
        System.out.println(trie.isWordValid("card"));
        System.out.println(trie.isWordValid("carp"));
        
        trie.printAllKeys();
        
    }
}
