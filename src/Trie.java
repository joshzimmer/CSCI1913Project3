public class Trie <T> {
    private TrieNode <T> root;

    /**
     * initializes tree with empty root node
     */
    public Trie(){
        root = new TrieNode<T>();
    }

    /**
     * returns node associated with string param
     */
    private TrieNode<T> getNode(String word){
        TrieNode<T> node = root;
        for(int i = 0; i < word.length(); i++){
            node = node.getChild(word.charAt(i));
        }
        return node;
    }

    /**
     * get data stored in node associated with word
     */
    public T get(String word){
        TrieNode<T> node = getNode(word);
        return node.getData();
    }

    /**
     * set data of node associated with word
     */
    public void put(String word, T data){
       TrieNode<T> node = getNode(word);
       node.setData(data);
    }
}
