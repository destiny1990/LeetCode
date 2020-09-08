public class Solution_459 {
    public static void main(String[] args) {
        String input = "zodwlwuxknpezmxxeksvyymlqyheptepjilxeiurxlvzasweerbcpnphnzmdssueahbhpvynivmiqioubqzqfqavpmaieumhbpqrkqgulsdbcryejzwrpwofioppkbylsoecekwrebvhvtleshxheloobdflgdxyrdcvobnsckbxdoexybgcnvsoaychbbfveksulhpnrqlwfptdsahfxbwxbyefbmafwsahcpwthjqmajrtlaykcwidwoixcifadfjfwgafrquscllpmlaoiktgacgdmlfpsrwozxvqppirbthphjfrtyxtadypogegxdwwasmpjxjmsqbzbgquhopjtqykwfqtippkjdbsakfvciudplzybphwfggblzwvqnfzqitttaoxjkbaxcyarfxynfzygxvwkaxdjtyetobeyeewheyamxzzdaajyvikyfnjalnubqaaxfyglwgxuhxzizkiussuaidavswxjxziezopvwnrgmsqndyjvsexahyyauxltwvxvlnshcmpqefdjdmhyqeaaeyczvnstksovfhehvuzzzclfqsdjwdjbelczawtmojhtslcnfdpffakysphqssrwfvyhsttgcacvngkvkzarbmpvbymvsfuxbsgvlzdpbfmroxmyyopachvfhjaapuzsognzhqrlwdekaqkzebbiiwnsgnsxktpybcajsrwquacxsmwyqzgaxtsfimcsgrthvtsqmqiislfkzdipcqqajkfuximdbhmxcfpoxxzqieckilbkdtmpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuzttitwnfmxgcqqejqllhbvwaufoqkkljfgtbchgqensufzdxmrenmdogiexurkfyqzzviglovgicfobrffhtivatbxnsjvrbwqweyisvocxvsyozgvtostjuszmdufeqybwwl";
        System.out.println(repeatedSubstringPattern(input));
        //System.out.println(input.substring(0, input.length()/2));
    }
/*
 * ！！！学习KMP算法！！！
 */
    //    暴力法
//    public static boolean repeatedSubstringPattern(String s) {
//        for (int i = 1; i <= s.length() / 2; i++) {
//            String tmp = s.substring(0, i);
//            //System.out.println("tmp=" + tmp);
//            String res = s.replaceAll(tmp, "");
//            //System.out.println(s + "的res=" + res);
//            if (res.equals(""))
//                return true;
//            else
//                continue;
//        }
//        return false;
//    }
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String tmp = s.substring(0, i);
            int x = tmp.indexOf(tmp, 1);

            //System.out.println("tmp=" + tmp);
            if (s.length() % i == 0) {
                String res = s.replaceAll(tmp, "");
                if (res.equals(""))
                    return true;
                else continue;
            } else continue;
        }
        return false;
    }
}