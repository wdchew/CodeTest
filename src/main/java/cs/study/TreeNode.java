package cs.study;

/**
 * A simple binary tree
 * @author dchew
 *
 */
public class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;
  
  public TreeNode(){}
  
  public TreeNode(int value){
    this.value = value;
  }
  
  public TreeNode(int value, TreeNode left, TreeNode right){
    this.value = value;
    this.left = left;
    this.right = right;
  }
  
  public int getValue() {
    return value;
  }
  public void setValue(int value) {
    this.value = value;
  }
  public TreeNode getLeft() {
    return left;
  }
  public void setLeft(TreeNode left) {
    this.left = left;
  }
  public TreeNode getRight() {
    return right;
  }
  public void setRight(TreeNode right) {
    this.right = right;
  }
  
  public static boolean lookup(TreeNode node, int target){
    if (node == null)
      return false;
    
    if (target == node.getValue()){
      return true;
    }else if ( target < node.getValue() ){
      return lookup(node.getLeft(), target);
    }else if ( target > node.getValue() ){
      return lookup(node.getRight(), target);
    }
    
    return false;    
  }
    
}
