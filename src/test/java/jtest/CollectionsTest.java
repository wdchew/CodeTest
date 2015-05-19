package jtest;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionsTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testAddToListAllowsDuplicates() {
    JButton a = new JButton("A");
    ArrayList<JButton> myList = new ArrayList<JButton>();
    assert(myList.size() == 0);
    myList.add(a);
    myList.add(a);    
    assertEquals(new Integer(2), new Integer(myList.size()));
  }
  
  @Test
  public void hashsetShouldNotAllowDuplicates(){
    JButton a = new JButton("A");
    HashSet<JButton> buttonSet = new HashSet<JButton>();
    buttonSet.add(a);
    buttonSet.add(a);
    assertEquals(new Integer(1), new Integer(buttonSet.size()));
  }

}
