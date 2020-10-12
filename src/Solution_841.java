import java.util.*;

public class Solution_841 {
    public static void main(String[] args) {
        Integer[] room_0 = {1, 3};
        Integer[] room_1 = {1, 4};
        Integer[] room_2 = {2, 3, 2, 4, 1};
        Integer[] room_3 = {};
        Integer[] room_4 = {4, 3, 2};
        //数组转List，方法1：[只支持查、改，不支持增删]
        //原因：Arrays.asList(strArray)返回值是java.util.Arrays类中一个私有静态内部类java.util.Arrays.ArrayList，
        // 它并非java.util.ArrayList类。java.util.Arrays.ArrayList类具有 set()，get()，contains()等方法，
        // 但是不具有添加add()或删除remove()方法,所以调用add()方法会报错。
        /*
        List<Integer> test=new ArrayList<>();
        test=Arrays.asList(room_0);
        test.add(1);
         */

        //数组转List，方法2：
        //List<Integer> room0 = new ArrayList<Integer>(Arrays.asList(room_0));

        //数组转List，方法3：[高效]
        List<Integer> room0 = new ArrayList<>(room_0.length);
        List<Integer> room1 = new ArrayList<>(room_1.length);
        List<Integer> room2 = new ArrayList<>(room_2.length);
        List<Integer> room3 = new ArrayList<>(room_3.length);
        List<Integer> room4 = new ArrayList<>(room_4.length);

        List<List<Integer>> rooms = new ArrayList<List<Integer>>();

        Collections.addAll(room0, room_0);
        Collections.addAll(room1, room_1);
        Collections.addAll(room2, room_2);
        Collections.addAll(room3, room_3);
        Collections.addAll(room3, room_4);

        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        System.out.println(rooms);
        System.out.println(rooms.size());
        boolean res = canVisitAllRooms(rooms);
        System.out.println(res);
    }

    static int roomnum;
    static Map<Integer, Boolean> rv = new HashMap<Integer, Boolean>();

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        roomnum = rooms.size();

        for (int i = 0; i < rooms.size(); i++) {
            rv.put(i, false);
        }
        DFS(rooms, 0);
        return !rv.containsValue(false);
    }

    public static void DFS(List<List<Integer>> rooms, Integer roomNO) {
        //设定停止条件
        boolean stopsign = false;
        //标记房间号roomNO已被访问
        rv.put(roomNO, true);
        List<Integer> keys = rooms.get(roomNO);
        for (Integer haoma : keys) {
            //未访问
            if (!rv.get(haoma))
                DFS(rooms, haoma);
            else
                continue;
        }
    }
}
