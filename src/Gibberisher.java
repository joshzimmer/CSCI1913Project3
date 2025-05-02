public class Gibberisher {
    private Trie<CharBag> model;
    private int segmentLength;
    private int numberOfSegments;

    public Gibberisher(int setLength) {
        segmentLength = setLength;
        model = new Trie<>();
        numberOfSegments = 0;
    }

    public void train(String[] words){
        for(int i = 0; i < words.length; i++) {
            LetterSample[] samples = LetterSample.toSamples(words[i], segmentLength);
            for(int j = segmentLength; j <samples.length; j++) {
                for(int k = 0; k < numberOfSegments; k++) {
                    model.getNode(samples[j].getSegment().charAt(k));
                }
            }
        }
    }

    private



}
