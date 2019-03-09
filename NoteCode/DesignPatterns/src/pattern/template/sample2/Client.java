package pattern.template.sample2;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        System.out.println("-----H1型号的悍马-----");
        System.out.println("是否需要喇叭声响? 0-不需要    1-需要");
        String alarmFlag = new Scanner(System.in).nextLine();
        HummerH1Model h1 = new HummerH1Model();
        if (alarmFlag.equals("0")) {
            h1.setAlarm(false);
        }
        h1.run();
    }

}
