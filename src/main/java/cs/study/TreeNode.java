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
  
  public static TreeNode insert(TreeNode root, int value) {
    TreeNode runner = root;
    if (runner == null) {
      runner = new TreeNode(value);
      return runner;
    }

    while (true) {
      if (value < runner.getValue()) {
        if (runner.getLeft() == null) {
          runner.setLeft(new TreeNode(value));
          return runner;
        } else {
          runner = runner.getLeft();
        }
      } else { // the value belongs on the right side, it's greater than the
               // current value
        if (runner.getRight() == null) {
          runner.setRight(new TreeNode(value));
          return runner;
        } else {
          runner = runner.getRight();
        }
      }
    }
  }
  public static int size(TreeNode root){
    
    if (root == null){
      return 0;
    }else{
      int count = 1;
      count+= size(root.getLeft());
      count+= size(root.getRight());
      return count;
    }
    
  }
  
  public static int maxDepth(TreeNode node){
    if (node == null){
      return 0;
    }else{
      int leftDepth = maxDepth(node.getLeft());
      int rightDepth = maxDepth(node.getRight());
      return (Math.max(leftDepth, rightDepth) + 1);
    }
  }
  
}
