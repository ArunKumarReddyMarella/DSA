public class longestPalindromicSubstring {
    static String lps(String s){
        if(s==null)
            return s;
        int p1=0,p2=0,m=0,si=0;
        for(int i=0;i<s.length()-1;i++){
            p1=i;
            p2=i+1;
            while(p1>=0 && p2<s.length()){
                if(s.charAt(p1)!=(s.charAt(p2))){
                    break;
                }
                if(m<(p2-p1+1)){
                    m=p2-p1+1;
                    si=p1;
                }
                p1--;
                p2++;
            }
            p1=i-1;
            p2=i+1;
            while(p1>=0 && p2<s.length()){
                if(s.charAt(p1)!=(s.charAt(p2))){
                    break;
                }
                if(m<(p2-p1+1)){
                    m=p2-p1+1;
                    si=p1;
                }
                p1--;
                p2++;
            }

        }
        System.out.println(si+" "+m);
        return s.substring(si, si+m);
    }
    public static void main(String[] args) {
        String s="abbaabbba";
        System.out.println(lps(s));
    }
}
