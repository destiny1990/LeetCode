public class Offer_20 {
    public static void main(String[] args) {
        String s = "-1";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //去空
        s = s.trim();
        try {
            double a = Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        char c = s.charAt(s.length() - 1);
        return (c >= '0' && c <= '9') || c == '.';
    }
}
