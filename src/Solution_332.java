import java.util.*;

public class Solution_332 {
    public static class Ticket {
        private String depart;
        private String destination;
        boolean used;

        public Ticket(String depart, String destination, boolean used) {
            this.depart = depart;
            this.destination = destination;
            this.used = used;
        }

        public Ticket() {
        }

        public String getDepart() {
            return depart;
        }

        public void setDepart(String depart) {
            this.depart = depart;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }
    }

    public static void main(String[] args) {
        List<String> init = new ArrayList<String>();
        List<List<String>> tickets = new ArrayList<List<String>>();
        /*
        init.add("JFK");
        init.add("SFO");
        tickets.add(new ArrayList<String>(init));
        init.clear();
        init.add("JFK");
        init.add("ATL");
        tickets.add(new ArrayList<String>(init));
        init.clear();
        init.add("SFO");
        init.add("ATL");
        tickets.add(new ArrayList<String>(init));
        init.clear();
        init.add("ATL");
        init.add("JFK");
        tickets.add(new ArrayList<String>(init));
        init.clear();
        init.add("ATL");
        init.add("SFO");
        tickets.add(new ArrayList<String>(init));
        init.clear();

         */
        init.add("JFK");
        init.add("KUL");
        tickets.add(new ArrayList<String>(init));
        init.clear();
        init.add("JFK");
        init.add("NRT");
        tickets.add(new ArrayList<String>(init));
        init.clear();
        init.add("NRT");
        init.add("JFK");
        tickets.add(new ArrayList<String>(init));
        init.clear();
        System.out.println(findItinerary(tickets));

    }

    static Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    static List<String> itinerary = new LinkedList<String>();

    public static List<String> findItinerary(List<List<String>> tickets) {
        //遍历所有机票【src&dst】
        for (List<String> ticket : tickets) {
            //出发地
            String src = ticket.get(0);
            //目的地
            String dst = ticket.get(1);
            //不在map中的目的地，以src作为key，加入到map中
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            //再将所有目的地插入到队列中，并自动排序【PriorityQueue特性！！！】
            map.get(src).offer(dst);//将对应的目的地插入到队列
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;

    }

    public static void dfs(String curr) {
        //深度优先遍历curr节点，且节点的队列大小不为空
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
//            Hierholzer 算法：
//            从起点出发，进行深度优先搜索。
//            每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
//            如果没有可移动的路径，则将所在节点加入到栈中，并返回。
//            检索或获取和删除队列的第一个元素或队列头部的元素
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        //一直寻找到最后一个节点，没有回头路时，将节点放入结果表并在最后的结果中翻转
        itinerary.add(curr);
    }

}
