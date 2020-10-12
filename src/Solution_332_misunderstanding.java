import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution_332_misunderstanding {
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

    public static List<String> findItinerary(List<List<String>> tickets) {
        //存储结果
        List<String> res = new ArrayList<String>();
        //迭代器，用来遍历List
        Iterator<List<String>> iterator = tickets.iterator();
        //ticks用来存储机票信息
        ArrayList<Ticket> ticks = new ArrayList<Ticket>();
        while (iterator.hasNext()) {
            List<String> tmp = iterator.next();
            Ticket tik = new Ticket(tmp.toArray()[0].toString(), tmp.toArray()[1].toString(), false);
            ticks.add(tik);
        }

        int index = findTicket(ticks, "JFK");
        if (index == -1)
            return res;
        ticks.get(index).used = true;
        res.add(ticks.get(index).depart);
        res.add(ticks.get(index).destination);
        for (int i = 0; i < ticks.size() - 1; i++) {
            if (index == -1)
                return res;
            index = findTicket(ticks, ticks.get(index).destination);
            if (index == -1)
                return res;
            else {
                res.add(ticks.get(index).destination);
                ticks.get(index).used = true;
            }
        }

        return res;
    }

    public static int findTicket(ArrayList<Ticket> ticks, String depart) {
        int index = Integer.MIN_VALUE;
        boolean isfind = false;
        //用于目的地比较
        String compareTmp = "ZZZ";
        //对象数组的正确用法
        Ticket[] tickets = new Ticket[ticks.size()];
        ticks.toArray(tickets);
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].used)
                continue;
            else {
                int compRes = compareTmp.compareTo(tickets[i].destination);
                //出发地匹配且目的地地址最小
                if (tickets[i].depart.equals(depart) && tickets[i].destination.compareTo(compareTmp) < 0) {
                    compareTmp = tickets[i].destination;
                    index = i;
                    isfind = true;
                }
            }
        }
        return isfind ? index : -1;
    }
}
