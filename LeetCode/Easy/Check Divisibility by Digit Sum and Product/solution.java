class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1, num = n;

        while(num != 0) {
            sum += num % 10;
            product *= num % 10;
            num = num/10;
        }

        sum += product;
        if(n % sum == 0)return true;
        else return false;
    }
}