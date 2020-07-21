public class Offer_05 {
    public static void main(String[] args) {
        String s = "     ";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        String res = s.replaceAll(" ", "%20");
        return res;
    }
}
