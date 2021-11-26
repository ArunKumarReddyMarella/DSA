import java.util.*;
public class NoDistinctSubStrings {
    static class Node{
        Node[] links=new Node[26];
        boolean flag=false;
    }
    static int distinctSubStrings(String s){
        Node root=new Node();
        int n=s.length(),c=0;

        for(int i=0;i<n;i++){
            Node temp=root;
            for(int j=i;j<n;j++){
                if(temp.links[s.charAt(j)-'a']==null){
                    temp.links[s.charAt(j)-'a']=new Node();
                    c++;
                }
                temp=temp.links[s.charAt(j)-'a'];
            }
        }

        return c+1;

    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(distinctSubStrings(str));
    }

}
