class Solution {
   public int findTheWinner(int n, int k) {
       return help(n,k)+1;
    }
    int help(int n,int k){
       if(n==1) 
     return 0;
    
        int x=help(n-1,k);
        int y=(x+k)%n;
        return y;
     
    }
}
