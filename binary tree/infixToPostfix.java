import java.util.*;
class infixToPostfix{
    public static boolean isOperand(Character ch){
        return ((ch <= 'z' && ch >= 'a') || (ch<='Z' && ch>='A') || (ch<='9' && ch>='0'));
    }
    public static int precedence(String ch){
        //System.out.println("precedence "+ch);
        if(ch.equals("^"))
            return 3;
        else if(ch.equals("*") || ch.equals("/"))
            return 2;
        else if(ch.equals("+") || ch.equals("-"))
            return 1;
        else
            return -1;
    }
    public static String ITP(String exp){
        Stack<String> stack=new Stack<>();
        String result="";
        for(char ch:exp.toCharArray()){
            String x=Character.toString(ch);
            if(isOperand(ch)){
                result+=x;
            }
            else if(x.equals("(")){
                stack.push(x);
            }
            else if(x.equals(")")){
                while(!stack.empty() && !stack.peek().equals("(")){
                    result+=stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else{
                while(!stack.empty() && (precedence(x)<=precedence(stack.peek()))){
                    //System.out.println(precedence(x)+" "+precedence(stack.peek()));
                    result+=stack.peek();
                    stack.pop();
                }
                stack.push(x);
            }
            //System.out.println(x+" "+result+" "+stack.toString());
        }
        while(!stack.empty()){
            result+=stack.peek();
            stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        String exp="a+b*(c-d)";
        System.out.println(ITP(exp));
    }
}