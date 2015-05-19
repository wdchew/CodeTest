package jtest;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringTest {

  @Test
  public void testStringBuilderCheckingForLastCharacter() {
    StringBuilder b = new StringBuilder("Hello World. Once upon a time.");
    assertEquals(new Integer(b.length() - 1), new Integer(b.lastIndexOf(".")));
  }
  @Test
  public void testShouldSubstringWithoutErrors(){
    String shortCourseNumber = "123";
    String processedString = StringUtils.substring(shortCourseNumber, 0, 4);
    assertEquals(shortCourseNumber, processedString);
  }
  
  @Test
  public void testShouldPadNullString(){
    String str = null;
    String padded = StringUtils.rightPad(str, 4);
    assertFalse("    ".equals(padded));
    padded = StringUtils.rightPad(StringUtils.defaultString(str), 4);
    assertEquals("    ",padded);
  }
  
  /**
   * 
   */
  @Test
  public void testShouldFindStartOfString(){
    String event = "EVENT"; 
    String str = event + "#1#2";
    assertTrue("regex should match substring", str.startsWith(event));
  }

}
