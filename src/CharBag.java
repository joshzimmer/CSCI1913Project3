public class CharBag {
    private int[] charCounts = new int[27];

    public CharBag(){
        for(int i = 0; i < 27; i++){
            charCounts[i] = 0;
        }
    }

    public int charToIndex(char newChar){
        if(int(newChar) == 0 )
        return (int)newChar - 97;
    }



}
