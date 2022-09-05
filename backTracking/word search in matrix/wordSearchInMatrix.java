import java.util.*;
public class wordSearchInMatrix
{
    static class Result {
          static boolean solve(char board[][],int[][] vis, String word, int m, int n,int si,int r,int c){
          if(si==word.length())
            return true;
          if(r<0 ||c<0 || r>=m || c>=n)
            return false;
          if(word.charAt(si)!=board[r][c] || vis[r][c]==1)
            return false;
          vis[r][c]=1;
          if(solve(board,vis,word,m,n,si+1,r+1,c))
            return true;
          if(solve(board,vis,word,m,n,si+1,r-1,c))
            return true;
          if(solve(board,vis,word,m,n,si+1,r,c+1))
            return true;
          if(solve(board,vis,word,m,n,si+1,r,c-1))
            return true;
          vis[r][c]=0;
          return false;
        }
        static int isFound(char board[][], String word, int m, int n){
          int[][] vis=new int[m][n];
          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if(board[i][j]==word.charAt(0) && solve(board,vis,word,m,n,0,i,j))
                return 1;
            }
          }
          return 0;
        }
    }
    public static void main(String args[])
    {
        int m, n;
        String str;
        Result o1 = new Result();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        
        char[][] board = new char[m][n+1];
        for (int i = 0; i < m; i++) {
            String temp = sc.next();
            board[i] = temp.toCharArray();
        }
    
        String word = sc.next();
    
        if (o1.isFound(board, word, m, n) == 1)
            System.out.print("Found");
        else
            System.out.print("Not Found");
    }
}