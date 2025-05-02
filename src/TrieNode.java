// @Author Josh Zimmer
public class TrieNode <T> {
    private T data;
    private TrieNode<T>[] children = new TrieNode[26];

    /**
     * Constructor that initializes data and children array to null
     */
    public TrieNode(){
        data = null;
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
    }

    public T getData(){
        return data;
    }

    public void setData(T newData){
        data = newData;
    }

    /**
     * returns child node associated with letter or creates node
     */
    public TrieNode<T> getChild(char letter){
        if(letter < 'a' || letter > 'z'){
            return null;
        }
        if(children[letter - 'a'] == null) {
            children[letter - 'a'] = new TrieNode<T>();
        }
        return children[letter - 'a'];
    }

    /**
     * returns how many nodes in tree
     */
    public int getTreeSize(){
        int sizeSum = 0;
        for(int i = 0; i < 26; i++) {
            if (children[i] != null)
                sizeSum += children[i].getTreeSize();
        }
        return 1 + sizeSum;
    }
}
