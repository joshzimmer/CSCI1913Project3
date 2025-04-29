public class Testing {
    public static int letterTest(char newChar){
        return (int)newChar;
    }
    public static void main(String[] args) {
        System.out.println(letterTest('a'));
        System.out.println(letterTest('z'));
        System.out.println(letterTest('.'));
        System.out.println(122-97);
    }
}
