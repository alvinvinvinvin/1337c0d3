package uniqueBST;   

import java.util.Vector;

/**   
* Filename:    Solution.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 5, 2014 4:55:05 PM   
* Description:  
*   
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 5, 2014 Han Chen      1.0     1.0 Version   
*/    
public class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1 || n == 2)
            return n;
        int results=2;
        for(int i=3; i<=n; i++)
            results=results*2*(2*i-1)/(i+1);
        return results;
    }
}
 
