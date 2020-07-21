import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 贪心算法，用来解决会议安排问题
 */
public class Greedy {

    public static void main(String[] args) {
        //得到会议信息
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入会议数量");
        int count = scan.nextInt();
        List<Meeting> list = new ArrayList<Meeting>();
        for (int i = 0; i < count; i++) {
            int starTime = scan.nextInt();
            int endTime = scan.nextInt();
            Meeting m = new Meeting(i, starTime, endTime);
            list.add(m);
        }
        System.out.println("会议信息");
        for (Meeting meeting : list) {
            System.out.println(meeting);
        }
        //贪心策略：按照会议结束时间排序，优先安排最先结束的
        //然后接下来从后面的会议里，寻找会议开始时间在当前会议结束时间之后的
        Collections.sort(list);
        int currentMeetingEndTime = 0;
        System.out.println("贪心算法后会议安排");
        for (int i = 0; i < count; i++) {
            //判断会议结束时间
            Meeting m = list.get(i);
            if (m.getStarTime() >= currentMeetingEndTime) {
                System.out.println(m);
                //更新当前会议结束时间
                currentMeetingEndTime = m.getEndTime();
            }
        }
    }
}