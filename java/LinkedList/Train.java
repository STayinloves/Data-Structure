package LinkedList;

import java.util.Objects;
import java.util.Scanner;

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

    public Train(String a) {
        TNumber = a;
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
        tList.push_back(new Train("K817", "08:00", "12:30", "Beijing West", "Chengdu"));
        tList.push_front(new Train("Z21", "20:00", "12:10", "Beijing West", "Lhasa"));
        tList.insert(2, new Train("G57", "07:20", "05:44", "Beijing South", "Hangzhou East"), 1);
        while (true) {
            int temp = printINFO();
            if (temp == -1) {
                System.out.println("input error, please input number between 1 and 6!");
                continue;
            }
            switch (temp) {
                case 1: {
                    System.out.println("请输入车次信息 格式：车次,开点,到点,始发站,终点站");
                    Scanner in = new Scanner(System.in);
                    String info = in.next();
                    String[] infoArray = info.split(",");
                    tList.push_back(new Train(infoArray[0], infoArray[1], infoArray[2], infoArray[3], infoArray[4]));
                    System.out.println("车次 " + infoArray[0] + " 已添加");
                    break;
                }
                case 2: {
                    System.out.println("请输入车次 格式：车次");
                    int pos = getValidTrain(tList);

                    Train train = tList.getNthElement(pos);
                    tList.deleteIthElement(pos);
                    System.out.println("车次 " + train.TNumber + " 已被删除");
                    break;
                }
                case 3: {
                    System.out.println("请输入车次 格式：车次");
                    int pos = getValidTrain(tList);

                    System.out.println(tList.getNthElement(pos));
                    break;
                }
                case 4: {
                    System.out.println("请输入车次 格式：车次");
                    int pos = getValidTrain(tList);

                    System.out.println("请输入信息 格式：开点,到点,始发站,终点站 不改动信息用 $ 占位");
                    Scanner in = new Scanner(System.in);
                    String info = in.next();
                    String[] infoArray = info.split(",");

                    Train train = tList.getNthElement(pos);
                    tList.deleteIthElement(pos);
                    infoArray[0] = infoArray[0].equals("$") ? train.LeaveTime : infoArray[0];
                    infoArray[1] = infoArray[1].equals("$") ? train.ArriveTime : infoArray[1];
                    infoArray[2] = infoArray[2].equals("$") ? train.DepartureStation : infoArray[2];
                    infoArray[3] = infoArray[3].equals("$") ? train.DestinationStation : infoArray[3];
                    Train newTrain = new Train(train.TNumber, infoArray[0], infoArray[1], infoArray[2], infoArray[3]);
                    System.out.println(newTrain);
                    tList.insert(pos, newTrain, 1);
                    break;
                }
                case 5: {
                    System.out.println(tList);
                    break;
                }
                case 6: {
                    System.out.println("系统退出，再见");
                    return;
                }
            }
        }
    }

    private static int getValidTrain(List<Train> tList) {
        int pos;
        String s;
        Scanner in = new Scanner(System.in);
        while (true) {
            s = in.next();
            pos = tList.getPositionByValue(new Train(s));
            if (pos == -1) System.out.println("找不到输入的车次，请重试 格式：车次");
            else break;
        }
        return pos;
    }

    private static int printINFO() {
        System.out.println("请输入 1 - 6 以选择以下任意选项：");
        System.out.println("1. 增加车次信息");
        System.out.println("2. 删除车次信息");
        System.out.println("3. 查询车次信息");
        System.out.println("4. 修改车次信息");
        System.out.println("5. 列出所有车次信息");
        System.out.println("6. 退出");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input < 1 || input > 6) return -1;
        return input;
    }
}
