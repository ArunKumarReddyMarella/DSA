package generate_subsets;

public class GenerateSubsets {
    static void generate(String str,String cur,int i){
        if(i==str.length()){
            System.out.println(cur);
            return;
        }

        generate(str, cur, i+1);
        generate(str, cur+str.charAt(i), i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        generate(str,"", 0);
    }
}
