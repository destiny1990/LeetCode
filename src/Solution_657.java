class Solution_657 {
    public static void main(String[] args) {
        String moves = "RRDD";
        System.out.println(judgeCircle(moves));
    }

    public static boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        //0-R,1-L,2-U,3-D
        int[] res = new int[]{0, 0, 0, 0};
        for (char zimu : chars) {
            switch (zimu) {
                case 'R':
                    res[0]++;
                    break;
                case 'L':
                    res[1]++;
                    break;
                case 'U':
                    res[2]++;
                    break;
                case 'D':
                    res[3]++;
                    break;
            }
        }
        return res[0] == res[1] && res[2] == res[3];
    }
}