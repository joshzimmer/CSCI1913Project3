import java.util.Random;
public class CharBag {
    private int[] charCounts = new int[27];
    private int size;

    /**
     * constructor to initialize storage array to 0
     * and size to 0
     */
    public CharBag(){
        for(int i = 0; i < 27; i++){
            charCounts[i] = 0;
        }
        size = 0;
    }

    /**
     * helper function that converts newChar to associated array index
     * any non english letters converted to -1
     */
    public int charToIndex(char newChar){
        newChar = Character.toLowerCase(newChar);
        if(newChar >= 'a' && newChar <= 'z') {
            return (int)newChar - 97;
        }
        return 26;
    }

    /**
     * Increments newChar place in charCounts
     */
    public void add(char newChar){
        int charIndex = charToIndex(newChar);
        charCounts[charIndex]++;
        size++;
    }

    /**
     * decrements newChar place in charCounts
     */
    public void remove(char newChar){
        int charIndex = charToIndex(newChar);
        if(charCounts[charIndex] > 0) {
            charCounts[charIndex]--;
            size--;
        }
    }

    /**
     * returns count of newChar in charCounts
     */
    public int getCount(char newChar){
        int charIndex = charToIndex(newChar);
        if(charCounts[charIndex] > 0)
            return charCounts[charIndex];
        return 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * returns string with count for each letter in charCounts
     */
    public String toString(){
        String returnString = "";
        returnString += "CharBag{";
        for(char c = 'a'; c <= 'z'; c++){
            returnString += c + ":" + charCounts[charToIndex(c)] + ", ";
        }
        returnString += LetterSample.STOP + ":" + charCounts[26] + "}";
        return returnString;
    }

    /**
     * return randomly chosen char from charBag in proportion to
     * number of times each char is in charCounts
     */
    public char getRandomChar() {
        // empty return '.'
        if (getSize() == 0)
            return LetterSample.STOP;
        Random random = new Random();
        int randomCount = random.nextInt(getSize());
        // return letter based on letter count proportion
        for (int i = 0; i < 26; i++) {
            randomCount -= charCounts[i];
            if (randomCount < 0)
                return (char) (i + 97);
        }
        return LetterSample.STOP;
    }

}

