package sameTree;
import dataStructureHelper.TreeNode;
/**   
* Filename:    Solutition.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 1, 2014 3:13:31 PM   
* Description:  
*   Comparing two trees to determine whether they are same or not.
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 1, 2014 Han Chen      1.0     1.0 Version   
*/     
public class Solutition {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null&&q!=null){
            boolean left = isSameTree(p.left,q.left);
            boolean right = isSameTree(p.right, q.right);
            if(left&&right&&p.val==q.val) return true;
            return false;
        }
        else if(p==null&&q==null) return true;
        return false;
    }
}
 