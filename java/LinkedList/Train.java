package LinkedList;

import java.util.Objects;

/**
 * Created by STay on 17-5-5.
 */
public class Train implements Comparable<Train> {
    public String TNumber;
    public String LeaveTime;
    public String ArriveTime;
    public String DepartureStation;
    public String DestinationStation;

    public Train(String a, String b, String c, String d, String e) {
        TNumber = a;
        LeaveTime = b;
        ArriveTime = c;
        DepartureStation = d;
        DestinationStation = e;
    }

    @Override
    public int compareTo(Train o) {
        if (Objects.equals(o.TNumber, this.TNumber)) return 0;
        return -1;
    }

    @Override
    public String toString() {
        return TNumber + " departs from " + DepartureStation + " at " + LeaveTime + ", "
                + "and arrives at " + ArriveTime + " in " + DestinationStation;
    }

    public static void main(String[] arg) {
        List<Train> tList = new List<Train>(new Train("G101", "06:44", "12:38", "Beijing South", "Shanghai Hongqiao"));
        ;
        tList.push_back(new Train("K817", "08:00", "12:30", "Beijing West", "Chengdu"));
        tList.push_front(new Train("Z21", "20:00", "12:10", "Beijing West", "Lhasa"));
        tList.insert(2, new Train("G57", "07:20", "05:44", "Beijing South", "Hangzhou East"), 2);
        System.out.print(tList);

        int temp = tList.getPositionByValue(new Train("K817", "", "", "", ""));
        tList.deleteIthElement(temp);
        boolean s = tList.insert(temp, new Train("K817", "09:00", "12:30", "Beijing West", "Chengdu"), 1);
        System.out.println(s ? "Change successful" : "Change fail");
        System.out.print(tList);
    }
}
