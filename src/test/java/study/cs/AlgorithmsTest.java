package study.cs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cs.study.TreeNode;

public class AlgorithmsTest {
  
  Logger log = LoggerFactory.getLogger(AlgorithmsTest.class);

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void shouldSortByBubbleSort() {
    int[] nums = new int[]{10,8,1,3,4,2,5,7,9,6};
    boolean isContinue = true;
    int count = 0;
    
    while(isContinue == true){
      isContinue = false;
      for (int i = 0; i < nums.length - 1; i ++){
        if (nums[i] < nums[i + 1]){
          int cur = nums[i];
          int tmp = nums[i + 1];
          nums[i] = tmp;
          nums[i+1] = cur;
          isContinue = true;
          count ++;
        }
      }
    }
    
    for (int i = 0; i < nums.length; i ++ ){
      assert(nums[i] >= nums[i -1 >= 0 ? i-1 : i]);
    }
    
    System.out.println("Bubble Sort Iterations: " + count);
  }
  
  @Test
  public void testInsertionSort(){
    int[] nums = new int[]{10,8,1,3,4,2,5,7,9,6};
    int count = 0;
    
    for (int i = 1; i < nums.length; i ++ ){
      int temp = nums[i];
      int j = i -1;
      for (; j >= 0 && nums[j] > temp; j--){
        nums[j+1] = nums[j];
        count ++;
      }
      nums[j + 1] = temp;      
    }
    
    for (int i = 0; i < nums.length; i ++ ){
      assert(nums[i] >= nums[i -1 >= 0 ? i-1 : i]);
    }
    
    System.out.println("Insertion Sort Iterations: " + count);    
    
  }
  
  @Test
  public void shouldFindByLinearSearch(){
    int[] nums = new int[]{10,8,2,1,3,4,5,7,9,6};
    assertTrue("Should have found the index.", linearSearch(nums, 5) == 6);
    assertTrue("Should have found the index.", linearSearch(nums, 10) == 0);
    assertTrue("Should have found the index.", linearSearch(nums, 6) == 9);
  }

  private int linearSearch(int[] nums, int searchFor) {
    

    int index = 0;
    for (int i = 0; i < nums.length; i++){
      if (nums[i] ==  searchFor){
        index = i;
        break;
      }
    }
    return index;
  }
  
  @Test
  public void shouldFindIndexByBinarySearch(){
    int i = 0;
    int search = 64;
    int[] nums = new int[]{1,3,4,6,8,11,13,15,16,19,21,24,28,31,35,36,37,40,42,50,52,58,60,64};       
    int searchIndex = binarySearch(nums, search, 0, nums.length - 1, 0);
    assertTrue(searchIndex != -1);
    System.out.println(searchIndex);
  }

  private int binarySearch(int[] nums, int search, int start, int end, int count) {
    count++;
    System.out.println(count);
    if (start > end){
      return -1; // does not exist
    }
    
    int middleIndex = (int)Math.floor(((double)start + (double)end) / 2 );
    int middleValue = nums[middleIndex];
    
    if (search < middleValue){
      return  binarySearch(nums, search, start, middleIndex -1, count);
    }
    if (search > middleValue){
      return binarySearch(nums, search, middleIndex + 1, end, count);
    }
    
    return middleIndex;    
  }
  
  @Test
  public void shouldCountNodesInBinaryTree(){
    TreeNode root = createBinaryTree();
    
    assertTrue("should count nodes in binary tree", 5 == countNodes(root));
  }
  
  @Test
  public void shouldPrintBinaryTreeInOrder(){
    inOrderPrint(createBinaryTree());
  }
  
  @Test
  public void shouldPrintBinarySortTreeInOrder(){
    inOrderPrint(createBinarySortTree());
  }  
  
  private void inOrderPrint(TreeNode node){
    if (node != null){
      inOrderPrint(node.getLeft());
      System.out.println(node.getValue());
      inOrderPrint(node.getRight());
    }    
  }

  private TreeNode createBinaryTree() {
    //populate binary tree
    TreeNode root = new TreeNode();
    root.setValue(5);    
    root.setLeft(new TreeNode());
    root.getLeft().setValue(4);    
    root.setRight(new TreeNode());
    root.getRight().setValue(10);
    TreeNode tmp = root.getRight();
    tmp.setRight(new TreeNode());
    tmp.getRight().setValue(7);
    tmp.getRight().setLeft(new TreeNode());
    tmp = tmp.getRight().getLeft();
    tmp.setValue(8);
    return root;
  }
  
  public int countNodes(TreeNode root){
    if (root == null){
      return 0; // the tree is empty.  It contains no nodes
    }else{
      int count = 1;
      count += countNodes(root.getLeft());
      count += countNodes(root.getRight());
      return count;
    }
  }
  
  
  private TreeNode createBinarySortTree() {
    TreeNode root = new TreeNode(10, new TreeNode(8), new TreeNode(12));
    TreeNode tmp = root.getLeft();    
    tmp.setLeft(new TreeNode(7));
    tmp.setRight(new TreeNode(9));
    
    tmp = root.getRight();
    tmp.setRight(new TreeNode(15, new TreeNode(13), new TreeNode(19)));
    
    return root;
  }  
  
  @Test
  public void shouldSearchForValueInBinaryTree(){
    assertFalse(TreeNode.lookup(null, 999));
    TreeNode root = new TreeNode();
    assertFalse(TreeNode.lookup(root, 999));
    
    TreeNode bst = createBinarySortTree();
    assertFalse(TreeNode.lookup(bst, 25));
    
    assertTrue(TreeNode.lookup(bst, 10));
    assertTrue(TreeNode.lookup(bst, 9));
    assertTrue(TreeNode.lookup(bst, 12));
    assertTrue(TreeNode.lookup(bst, 7));
    assertTrue(TreeNode.lookup(bst, 8));
    assertFalse(TreeNode.lookup(bst, 11));
    assertTrue(TreeNode.lookup(bst, 15));
    assertTrue(TreeNode.lookup(bst, 13));
    assertTrue(TreeNode.lookup(bst, 19));
    
    bst = treeInsert(null, 3);
    treeInsert(bst, 2);
    treeInsert(bst, 4);
    treeInsert(bst, 10);
    treeInsert(bst, 20);
    treeInsert(bst, 19);
    treeInsert(bst, 30);
    
    assertTrue(TreeNode.lookup(bst, 3));
    assertTrue(TreeNode.lookup(bst, 2));
    assertTrue(TreeNode.lookup(bst, 4));
    assertTrue(TreeNode.lookup(bst, 10));
    assertTrue(TreeNode.lookup(bst, 30));
    
    
  }
  
  private TreeNode treeInsert(TreeNode root, int value){
    TreeNode runner = root;    
    if (runner == null){
      runner = new TreeNode(value);
      return runner;
    }
    
    while(true){
      if( value < runner.getValue()){
        if (runner.getLeft() == null){
          runner.setLeft(new TreeNode(value));
          return runner;
        }else{
          runner = runner.getLeft();
        }
      }else{ // the value belongs on the right side, it's greater than the current value
        if(runner.getRight() == null){
          runner.setRight(new TreeNode(value));
          return runner;
        }else{
          runner = runner.getRight();
        }
      }
    }    
  }
}
