import java.util.Scanner;
//関数化した方　計測済　こっちで行く
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String[][] answer = new String[s][s];

        // 入力文字列をs行s列の2次元配列に格納
        for (int i = 0; i < s; i++) {
            for (int a = 0; a < s; a++) {
                answer[i][a] = sc.next();
            }
        }
        
        int n = sc.nextInt();
        // 配列を更新する関数
        updateArray(answer, s, n, sc);
        sc.close();

        // 勝利条件を満たすかどうかをチェック
        if (naname(answer, s) || yoko(answer, s) || tate(answer, s)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
    // 配列を更新する関数
    // 入力された文字列が存在すれば末尾に印として「○」をつける
    private static void updateArray(String[][] answer, int s, int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            for (int a = 0; a < s; a++) {
                for (int b = 0; b < s; b++) {
                    if (answer[a][b].equals(word)) {
                        answer[a][b] += "○";
                    }
                }
            }
        }
    }
    //勝利条件を満たすのは1.ナナメ(2通り)、2.ヨコ(s通り)、3.タテ(s通り)
    // 1.ナナメの勝利条件をチェックする関数
    private static boolean naname(String[][] answer, int s) {
        boolean leftToRight = true;
        boolean rightToLeft = true;

        for (int i = 0; i < s; i++) {
        	//左上から右下↘︎へ⚪︎がついているか調べていく
            if (!answer[i][i].endsWith("○")) {
                leftToRight = false;
            }
            //右上から左下↙︎へ⚪︎がついているか調べていく
            if (!answer[i][s - 1 - i].endsWith("○")) {
                rightToLeft = false;
            }
        }
        return leftToRight || rightToLeft;
    }

    // 2.ヨコの勝利条件をチェックする関数
    private static boolean yoko(String[][] answer, int s) {
        for (int i = 0; i < s; i++) {
            boolean row = true;
            for (int a = 0; a < s; a++) {
            	//１行目から、左から右へ⚪︎がついているか
                if (!answer[i][a].endsWith("○")) {
                    row = false;
                    break;
                }
            }
            if (row) {
                return true;
            }
        }
        return false;
    }

    // 3.タテの勝利条件をチェックする関数
    private static boolean tate(String[][] answer, int s) {
        for (int i = 0; i < s; i++) {
            boolean column = true;
            for (int a = 0; a < s; a++) {
            	//一列目から、上から下へ
                if (!answer[a][i].endsWith("○")) {
                    column = false;
                    break;
                }
            }
            if (column) {
                return true;
            }
        }
        return false;
    }
}