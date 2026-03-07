class Solution {
    public boolean isValid(String s) {
        Stack<Character> paranthesisStack = new Stack<>();
        char[] paranthesis = s.toCharArray();
        for(char bracket : paranthesis){
            if(bracket=='{' || bracket=='[' || bracket=='('){
                paranthesisStack.push(bracket);
            }
            else{
            if(paranthesisStack.isEmpty()){
                return false;
            }
            char lastBracket= paranthesisStack.pop();
            //System.out.println("found closed brcket "+lastBracket);
            if(bracket=='}' && lastBracket!='{'){
                    return false;
            }
            if(bracket==')' && lastBracket!='('){
                    return false;
            }
            if(bracket==']' && lastBracket!='['){
                    return false;
            }
            }
        }
        return paranthesisStack.isEmpty();
    }
}