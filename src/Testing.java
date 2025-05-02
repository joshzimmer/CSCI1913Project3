public class Testing {
    public static int letterTest(char newChar){
        return (int)newChar;
    }
    public static void main(String[] args) {
        String[] words = {"apples", "banana", "grape", "orange", "peel"};
        for(int i = 0; i<5; i++) {
            LetterSample[] samples = LetterSample.toSamples(words[i], 3);
            for(int j = 0; j<samples.length; j++) {
                System.out.println(samples[j].getSegment());
                System.out.println(samples[j].getNextLetter());
                System.out.println(samples[j].getSegment().length());
                if(j == samples.length - 1)
                    System.out.println('.');
            }

        }
        String segment = "test";
        for(int i = 0; i<segment.length() + 1; i++) {
            System.out.println(segment.substring(0,1));
        }
    }
}


/**
"Test"

i = 0
 Test[0] = T
adds T to root
 i = 1
 Test[1] = e
 adds e to T
 i = 2
 Test[2] = s
 adds s to Te
 i = 3
 Test[3] = t
 adds t to Tes
 i = 4
 Test[4] = outofbounds
 adds STOP to est
 */