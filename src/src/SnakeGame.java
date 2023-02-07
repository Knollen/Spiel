import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeGame {

    private static int count = 0;

    public static void main(String[] args) {
        Random rnNum = new Random();
        Random rnNum1 = new Random();
        Random rnNum2 = new Random();
        Random rnNum3 = new Random();
        int num = rnNum.nextInt(39);
        int num1 = rnNum1.nextInt(9);
        int num2 = rnNum2.nextInt(39);
        int num3 = rnNum3.nextInt(9);
        int num4 = rnNum3.nextInt(9);
        Point spielerPosition = new Point(num, 8);
        Point schlangenPosition = new Point(num1, num3);
        Point goldPosition = new Point(num2, num4);
        Point tuerPosition = new Point(num3, num1);
        boolean weiter = true;
        boolean goldSammeln = false;

        while(weiter) {
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (p.equals(spielerPosition)) {
                        System.out.print("P");
                    } else if (p.equals(schlangenPosition)) {
                        System.out.print("S");
                    } else if (p.equals(goldPosition)) {
                        System.out.print("G");
                    } else if (p.equals(tuerPosition)) {
                        System.out.print("T");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
            if(schlangenPosition.equals(spielerPosition)){
                weiter = false;
                System.out.println("Die Schlange hat dich gefressen!");
            }
            if(spielerPosition.equals(goldPosition)){
                goldSammeln = true;
                goldPosition = new Point(-1, -1);
            }

            if (spielerPosition.equals(tuerPosition)){
                weiter = false;
                System.out.println("Du hast Gewonnen!");
            }
            bewegeSpieler(spielerPosition);
            bewegeSchlange(schlangenPosition, spielerPosition);
        }
    }

    private static void bewegeSchlange(Point schlangenPosition, Point spielerPosition) {
        if (count % 2 == 0) {
            if (spielerPosition.x < schlangenPosition.x) {
                schlangenPosition.x--;
            } else if (spielerPosition.x > schlangenPosition.x) {
                schlangenPosition.x++;
            } else if (spielerPosition.y < schlangenPosition.y) {
                schlangenPosition.y--;
            } else if (spielerPosition.y > schlangenPosition.y) {
                schlangenPosition.y++;
            }
        } else {
            if (spielerPosition.y < schlangenPosition.y) {
                schlangenPosition.y--;
            } else if (spielerPosition.y > schlangenPosition.y) {
                schlangenPosition.y++;
            } else if (spielerPosition.x < schlangenPosition.x) {
                schlangenPosition.x--;
            } else if (spielerPosition.x > schlangenPosition.x) {
                schlangenPosition.x++;
            }
        }
    }


    private static void bewegeSpieler(Point spielerPosition) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equals("w")){
            if(spielerPosition.y > 0) {
                spielerPosition.y--;
            }
        } else if (input.equals("s")){
            if (spielerPosition.y < 9) {
                spielerPosition.y++;
            }
        } else if (input.equals("a")){
            if (spielerPosition.x > 0){
                spielerPosition.x--;
            }
        } else if (input.equals("d")){
            if (spielerPosition.x < 39){
                spielerPosition.x++;
            }
        } count++;
    }
}
