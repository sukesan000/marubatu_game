import java.util.Random;
import java.util.Scanner;

public class marubatu {
    static boolean game = true;
    public static int ban[][] = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };
    public static int jugCnt = 0;
    public static Boolean zeroChk = true;
    public static int ver = 0;
    public static int hor = 0;

    public static void main(String[] args) {
        System.out.println("これよりマルバツゲームを開始します");
        while(game){
            Scanner scan = new Scanner(System.in);
            while(true) {
                System.out.println("縦の数字を入力してください(0~2)");
                ver = scan.nextInt();
                System.out.println("横の数字を入力してください(0~2)");
                hor = scan.nextInt();
                if(false == chkZero(ver, hor)){
                    System.out.println("失敗しました。もう一度入力してください");
                }else{
                    setMark(ver, hor);
                    break;
                }
            }
            judge();
            //もしマルを入れたい場所が0でなかったら繰り返しにゅうりょくさせる
            if(marubatu.game = true){
                System.out.println("コンピュータのターンです");
                cpPlay();
                judge();
            }
        }
    }

    public static void setMark(int ver, int hor){
        int ban[][] = marubatu.ban;
        int x = ver;
        int y = hor;
        marubatu.ban[x][y] = 1;
        show_board();
    }

    public static void cpPlay(){
        int ban[][] = marubatu.ban;
        Random r = new Random();
        int x = 0;
        int y = 0;
        do{
            x = r.nextInt(3);
            y = r.nextInt(3);
        }while((marubatu.ban[x][y] == 1) || (marubatu.ban[x][y] == 2));
        marubatu.ban[x][y] = 2;
        show_board();
    }

    public static void show_board(){
        int ban[][] = marubatu.ban;
        for(int[] num: ban) {
            for(int value : num){
                if(value == 0){
                    System.out.print(".  ");
                }else if(value == 1){
                    System.out.print("◯  ");
                }else if(value == 2) {
                    System.out.print("×  ");
                }
            }
            System.out.println("");
        }
    }

    public static void judge(){
        int ban[][] = marubatu.ban;
        if((ban[0][0] == 1 & ban[0][1] == 1 & ban[0][2] == 1) ||
                (ban[1][0] == 1 & ban[1][1] == 1 & ban[1][2] == 1) ||
                (ban[2][0] == 1 & ban[2][1] == 1 & ban[2][2] == 1) ||
                (ban[0][0] == 1 & ban[1][0] == 1 & ban[2][0] == 1) ||
                (ban[0][1] == 1 & ban[1][1] == 1 & ban[2][1] == 1) ||
                (ban[0][2] == 1 & ban[1][2] == 1 & ban[2][2] == 1) ||
                (ban[0][0] == 1 & ban[1][1] == 1 & ban[2][2] == 1) ||
                (ban[0][2] == 1 & ban[1][1] == 1 & ban[2][0] == 1)){
            System.out.println("あなたの勝利です！");
            marubatu.game = false;
        }else if((ban[0][0] == 2 & ban[0][1] == 2 & ban[0][2] == 2) ||
                (ban[1][0] == 2 & ban[1][1] == 2 & ban[1][2] == 2) ||
                (ban[2][0] == 2 & ban[2][1] == 2 & ban[2][2] == 2) ||
                (ban[0][0] == 2 & ban[1][0] == 2 & ban[2][0] == 2) ||
                (ban[0][1] == 2 & ban[1][1] == 2 & ban[2][1] == 2) ||
                (ban[0][2] == 2 & ban[1][2] == 2 & ban[2][2] == 2) ||
                (ban[0][0] == 2 & ban[1][1] == 2 & ban[2][2] == 2) ||
                (ban[0][2] == 2 & ban[1][1] == 2 & ban[2][0] == 2)){
            System.out.println("コンピュータの勝利です");
            marubatu.game = false;
        }
        marubatu.jugCnt++;

        if(jugCnt == 9) {
            Boolean contains = false;
            for (int[] num : ban) {
                for (int value : num) {
                    if (value == 0) {
                        contains = true;
                        break;
                    }
                }
            }
            if(contains == false){
                System.out.println("引き分けです");
                marubatu.game = false;
            }
        }
    }
    public static Boolean chkZero(int x, int y){
        int ban[][] = marubatu.ban;
        if(ban[x][y] == 0){
            return true;
        }else{
            return false;
        }
    }
}
