package leet_code;

class Item292_Nim游戏_自顶向下 {

    public boolean canWinNim(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return canWinNim(memo, n);
    }

    public boolean canWinNim(Boolean[] memo, int n) {
        if (n <= 3) return true;

        if (memo[n] != null) return memo[n];

        boolean canWin = !canWinNim(memo, n - 1) || !canWinNim(memo, n - 2) || !canWinNim(memo, n - 3);

        memo[n] = canWin;

        return canWin;
    }

}
