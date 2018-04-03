/**
 * 
 */
package minStack;

import java.util.Stack;

/**
 * @author e007777
 *
 */
public class MinStack {
	int min = Integer.MAX_VALUE;
    Stack<Integer> st;
    Stack<Integer> st_min;
    public MinStack() {
        // do intialization if necessary
        st = new Stack<>();
        st_min = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if(number <= min){
            //st.push(min);
            min = number;
            st_min.push(min);
        }
        st.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int p = st.pop();
        
        
        
        if(p == min){
            if(st_min.size() == 1){
                min = st_min.pop();
            }
            else if(st_min.isEmpty()){

            }
            else{
                st_min.pop();
                min = st_min.peek();
            }
        }
        if(st.isEmpty()){
            min = Integer.MAX_VALUE;
        }
        return p;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min;
    }
}
