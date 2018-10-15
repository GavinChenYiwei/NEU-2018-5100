public class Main {
//score 1/2
//you have a extra space in the end. 
    public static void main(String[] args) {
        String s = "     I     have    a    pencil     ";
        System.out.println(reverse(s));
    }

    public static String reverse(String s){
        String[] words;
        String reverseSentence = "";
        words = s.trim().split("\\s++");
        for (int i = words.length-1; i >=0; i--){
            reverseSentence = reverseSentence +words[i] +" ";
        }
        return reverseSentence;
    }
}
