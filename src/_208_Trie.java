class TrieNode{
	
	private TrieNode[] links;
	
	private boolean isEnd;

	private final int R = 26;
	
	public TrieNode() {
		links = new TrieNode[R];
	}
	
	public boolean contains(char c) {
		return links[c - 'a'] != null;
	}
	
	public TrieNode get(char c) {
		return links[c - 'a'];
	}
	
	public void put(char c, TrieNode node) {
		links[c - 'a'] = node;
	}
	
	public void setEnd() {
		isEnd = true;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
}
public class _208_Trie {
	
	private TrieNode root;
	
    /** Initialize your data structure here. */
    public _208_Trie() {
    	root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode node = root;
    	for(int i = 0; i < word.length(); i++) {
    		char curchar = word.charAt(i);
    		if(!node.contains(curchar)) {
    			node.put(curchar, new TrieNode());
    		}
    		node = node.get(curchar);
    	}
    	node.setEnd();
    }
    
    public TrieNode searchPrefix(String word) {
    	TrieNode node = root;
    	for(int i = 0; i < word.length(); i++) {
    		char curchar = word.charAt(i);
    		if(node.contains(curchar)) {
    			node = node.get(curchar);
    		}else {
    			return null;
    		}
    	}
    	return node;
    }
    /** Returns if the word is inv v  the trie. */
    public boolean search(String word) {
    	
    	TrieNode node = searchPrefix(word);
    	return node != null && node.isEnd();
    	
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	
    	TrieNode node = searchPrefix(prefix);
    	return node != null;
    }

}
