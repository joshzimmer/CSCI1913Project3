public class Testing {
    public static int letterTest(char newChar){
        return (int)newChar;
    }
    public static void main(String[] args) {
        String[] words = {"apples", "banana", "grape", "orange", "peel"};
        for(int i = 0; i<5; i++) {
            LetterSample[] samples = LetterSample.toSamples(words[i], 3);
            for(int j = 3; j<samples.length; j++) {
                System.out.println(samples[j].getSegment());
                System.out.println(samples[j].getSegment().length());
                if(j == samples.length - 1)
                    System.out.println('.');
            }
        }
    }
}
