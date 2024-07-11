package N_Queens;

public class Main {
    public static void main(String[] args) {
        NQueens obj = new NQueens();
        System.out.println("All possible ways");
        obj.nQueens(4);
    }
}
