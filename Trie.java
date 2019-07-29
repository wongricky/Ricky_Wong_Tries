package tries;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Trie {
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            
        	// currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
               child = new Node();
               currentNode.children.put(currentLetter, child); 
//               System.out.println("add: " + currentLetter);
            } 
            
            currentNode = child;
            
//            System.out.println("This is the child node: " + child + " value: " + currentLetter);
        }
        currentNode.isCompleteWord = true;
    }
    
    
    public boolean prefixValid(String prefix) {
    	Node currentNode = this.root;
    	for (int i = 0; i < prefix.length(); i++) {
    		Node child = currentNode.children.get(prefix.charAt(i));
    		if (child == null) {
    			return false;
    		}
    		currentNode = child;
    	}
    	return !currentNode.children.isEmpty();

    }
    
    public boolean isWordValid(String word) {
    	Node currentNode = this.root;
    	for (int i = 0; i < word.length(); i++) {
    		Node child = currentNode.children.get(word.charAt(i));
    		if (child == null) {
    			return false;
    		}
    		currentNode = child;
    	}
    	return !currentNode.children.isEmpty() || currentNode.isCompleteWord;

    }
    
    void printAllKeys() {
    	recursivePrinting(this.root);
    }
    
    private void recursivePrinting(Node current) {
    	for(Character key: current.children.keySet()) {
    		System.out.println(key);
    		Node child = current.children.get(key);
    		if(child == null) {
    			return;
    		}
    		recursivePrinting(child);
    	}
    }
    
    
}
