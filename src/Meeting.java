/**
 * 会议类，需实现Comparable接口
 */
public class Meeting implements Comparable<Meeting> {
    //定义会议属性
    private int number;
    private int starTime;
    private int endTime;

    //get set方法
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStarTime() {
        return starTime;
    }

    public void setStarTime(int starTime) {
        this.starTime = starTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    //构造方法
    public Meeting(int number, int starTime, int endTime) {
        this.number = number;
        this.starTime = starTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "number=" + number +
                ", starTime=" + starTime +
                ", endTime=" + endTime +
                '}';
    }

    //需要重写接口的方法
    @Override
    public int compareTo(Meeting o) {
        //按照会议结束时间升序排列
        if (this.endTime > o.endTime) {
            return 1;
        }
        if (this.endTime < o.endTime) {
            return -1;
        }
        return 0;
    }
}