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
    
    assertTrue("should count nodes in binary tree", 5 == TreeNode.size(root));
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
  
  private TreeNode createBinarySortTree() {
//      10
//     /  \
//    8    12
//   / \     \
//  7   9     15
//           /  \
//         13    19
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
    
    bst = 
    TreeNode.insert(null, 3);
    TreeNode.insert(bst, 2);
    TreeNode.insert(bst, 4);
    TreeNode.insert(bst, 10);
    TreeNode.insert(bst, 20);
    TreeNode.insert(bst, 19);
    TreeNode.insert(bst, 30);
    
    assertTrue(TreeNode.lookup(bst, 3));
    assertTrue(TreeNode.lookup(bst, 2));
    assertTrue(TreeNode.lookup(bst, 4));
    assertTrue(TreeNode.lookup(bst, 10));
    assertTrue(TreeNode.lookup(bst, 30));
    
    
  }
  
  @Test
  public void shouldBuild123BinaryTree(){
	  // problem 1 at http://cslibrary.stanford.edu/110/BinaryTrees.html
  //    2 
  //   / \ 
  //  1   3
//    a: by calling newNode() three times, and using three pointer variables
    TreeNode root = new TreeNode(2);
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(3);
    root.setLeft(left);
    root.setRight(right);
    assertTrue(root.getRight().getValue() == 3);
//    b: by calling newNode() three times, and using only one pointer variable
    root = new TreeNode(2);
    root.setLeft(new TreeNode(1));
    root.setRight(new TreeNode(3));
    assertTrue(root.getLeft().getValue() == 1);
    
//    c: by calling insert() three times passing it the root pointer to build up the tree
    
    root = TreeNode.insert(null, 2);
    TreeNode.insert(root, 1);
    TreeNode.insert(root, 3);
    assertTrue(root.getValue() == 2);
    assertTrue(root.getRight().getValue() == 3);
    
  }
  
  public void shouldCountDepth(){
    TreeNode root = createBinarySortTree();
    int maxDepth = TreeNode.maxDepth(root);
    
    assertTrue(4 == maxDepth);
  }
  
  
//  public int countNodes(TreeNode root){
//    if (root == null){
//      return 0; // the tree is empty.  It contains no nodes
//    }else{
//      int count = 1;
//      count += countNodes(root.getLeft());
//      count += countNodes(root.getRight());
//      return count;
//    }
//  }
  @Test
  public void shouldGetMinValueOfBinarySearchTree(){
    TreeNode root = createBinarySortTree();
    assertTrue(7 == minValue(root));
  }
  
  private int minValue(TreeNode node){
    
    TreeNode current = node;
    while(current.getLeft() != null){
      current = current.getLeft();
    }
    return current.getValue();
  }
  
  @Test
  public void shouldPrintBinarySearchTreeInOrder(){
    // problem # 5
//    4 
//   / \ 
//  2   5 
// / \ 
//1   3
    TreeNode root = createTreeForPrint();
    inOrderPrint(root);    
  }

  private TreeNode createTreeForPrint() {
    //     4 
    //    / \ 
    //   2   5 
    //  / \ 
    // 1   3
    TreeNode root = TreeNode.insert(null, 4);
    TreeNode.insert(root, 2);
    TreeNode.insert(root, 5);
    TreeNode.insert(root, 1);
    TreeNode.insert(root, 3);
    return root;
  }
  
  @Test
  public void shouldPrintTreePostOrder(){
    //     4 
    //    / \ 
    //   2   5 
    //  / \ 
    // 1   3
    TreeNode root = createTreeForPrint();
    printPostOrder(root);
  }

  private void printPostOrder(TreeNode root) {
    if(root == null){
      return;
    }else{
      printPostOrder(root.getLeft());
      printPostOrder(root.getRight());
      System.out.println(root.getValue());
    }
  }
  
  @Test
  public void shouldSumPathsOfTree(){
    
    TreeNode root = createBinaryTree2();
    
    assertTrue(hasPathSum(root, 27));
    assertTrue(hasPathSum(root, 22));
    assertTrue(hasPathSum(root, 26));
    assertTrue(hasPathSum(root, 18));
    assertFalse(hasPathSum(root, 100));
    
  }

  private TreeNode createBinaryTree2() {
    //        5 
    //       / \ 
    //      4   8 
    //     /   / \ 
    //    11  13  4 
    //   /  \      \ 
    //  7    2      1
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(8));
        TreeNode left = root.getLeft();
        left.setLeft(new TreeNode(11, new TreeNode(7), new TreeNode(2)));
        TreeNode right = root.getRight();
        right.setLeft(new TreeNode(13));
        right.setRight(new TreeNode(4));
        right = right.getRight();
        right.setRight(new TreeNode(1));
    return root;
  }

  private boolean hasPathSum(TreeNode node, int search) {
    
    
    if (node == null){
      return false;
    } if (node.getValue() == search){
      return true;
    }else{
      return (hasPathSum(node.getLeft(), search, node.getValue()) || hasPathSum(node.getRight(), search, node.getValue()));
    }
  }
  
  private boolean hasPathSum(TreeNode node, int search, int sum) {
    
    if (node == null){
      return false;
    }else{
      int tmpSum = sum + node.getValue();
      if (tmpSum == search){
        return true;
      }else{
        return (hasPathSum(node.getLeft(), search, tmpSum) || hasPathSum(node.getRight(), search, tmpSum));
      }
    }
  }
  
  @Test
  public void shouldPrintPaths(){
    TreeNode root = createBinaryTree2();
    int[] path = new int[]{};
    int pathLength = 0;
    printTreePath(root, path, pathLength);
    
    
  }

  private void printTreePath(TreeNode node, int[] path, int pathLength) {
    int currentPathLength = pathLength + 1;
    int[] currentPath = new int[currentPathLength];
    System.arraycopy(path, 0, currentPath, 0, pathLength);
    currentPath[pathLength] = node.getValue();

    if (node.getLeft() != null){
      printTreePath(node.getLeft(), currentPath, currentPathLength);
    }
    if (node.getRight() != null){
      printTreePath(node.getRight(), currentPath, currentPathLength);
    }
    if (node.getLeft() == null && node.getRight() == null){
      printLeafPath(currentPath, currentPathLength);
    } 
    
  }

  private void printLeafPath(int[] path, int pathLength) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < path.length; i++){
      sb.append(path[i]);
      sb.append(" ");
    }
    System.out.println(String.format("Path for leaf length of %d is %s", pathLength, sb.toString()));
  }
  
  @Test
  public void shouldMirrorBinaryTree(){
    TreeNode root = createBinaryTree2();
    System.out.println("---Before mirror---");
    printTreePath(root, new int[0], 0);
    mirror(root);
    System.out.println("---After mirror---");
    printTreePath(root, new int[0], 0);
 
  }

  private void mirror(TreeNode node) {
    if(node == null){
      return;
    }else{
      TreeNode tmpNode;
      tmpNode = node.getLeft();
      node.setLeft(node.getRight());
      node.setRight(tmpNode);
      mirror(node.getRight());
      mirror(node.getLeft());
    }
  }
  @Test
  public void shouldDoubleTree(){
    TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    doubleTree(root);
    return;
  }

  private void doubleTree(TreeNode node) {
    if (node == null){
      return;
    }else{
      TreeNode newDuplicateNode = new TreeNode(node.getValue());
      newDuplicateNode.setLeft(node.getLeft());
      node.setLeft(newDuplicateNode);
      
      doubleTree(newDuplicateNode.getLeft());
      doubleTree(node.getRight());
      
    }
  }
  
  @Test
  public void shouldDetectSameTree(){
    TreeNode root1 = createBinaryTree2();
    TreeNode root2 = createBinaryTree2();
    TreeNode root3 = createBinaryTree();
    
    int sameTree = sameTree(root1, root2);
    
    assertEquals("Same tree will have a sum of 0", 0, sameTree);
    
    int notSameTree = sameTree(root1, root3);
    
    assertNotEquals("Different trees will not have a sume of 0", 0, notSameTree);
    
  }

  private int sameTree(TreeNode node1, TreeNode node2) {    
    if (node1 != null && node2 != null){
      return sameTree(node1.getLeft(), node2.getLeft()) - sameTree(node1.getRight(), node2.getRight());
    }else{
      return -1;
    }
  }
}