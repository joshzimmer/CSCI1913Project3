// @Author Josh Zimmer
public class Gibberisher {
    private Trie<CharBag> model;
    private int segmentLength;
    private int numberOfSegments;

    /**
     * constructor that sets segment length to setLength
     * and initializes model and number of segments
     */
    public Gibberisher(int setLength) {
        segmentLength = setLength;
        model = new Trie<>();
        numberOfSegments = 0;
    }

    /**
     * helper function
     * Takes segment string and updates nodes for that segment
     */
    private void updateNodes(LetterSample sample) {
        String segment = sample.getSegment();
        char nextChar = sample.getNextLetter();
        CharBag currentCharBag = model.get(segment);
        // if no node for this current segment
        if (currentCharBag == null) {
            currentCharBag = new CharBag();
            model.put(segment, currentCharBag);
            }
        currentCharBag.add(nextChar);


    }

    /**
     * takes LetterSamples array and calls updateNodes for each
     * sample
     */
    private void importSegments(LetterSample[] samples){
        for(int i = 0; i < samples.length; i++){
            updateNodes(samples[i]);
        }
    }

    /**
     * Takes words array and imports sample arrays for each word
     */
    public void train(String[] words) {
        for(int i = 0; i < words.length; i++) {
            numberOfSegments += words[i].length() + 1;
            LetterSample[] samples = LetterSample.toSamples(words[i], segmentLength);
            importSegments(samples);
        }
    }

    /**
     * returns number of distinct segments imported
     */
    public int getSampleCount(){
        return numberOfSegments;
    }

    /**
     * Generates new random word from model
     */
    public String generate(){
        String output = "";
        char nextChar = ' ';
        CharBag nextCharBag = null;
        int currentLength = 0;
        // loop until end of word
        while(nextChar != LetterSample.STOP){
            // if shorter than segment use only current length
            if(currentLength < segmentLength) {
                nextCharBag = model.get(output);
            }
            // getNode for each current segment
            else{
                nextCharBag = model.get(output.substring(currentLength - segmentLength
                        ,currentLength));
            }
            nextChar = nextCharBag.getRandomChar();
            output += nextChar;
            currentLength++;
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }
}




