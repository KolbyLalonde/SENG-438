package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class LengthRangeTest {

  @Test
  public void testPositiveRange() {
    Range r1 = new Range(0, 20);
    double length = r1.getLength();
    assertEquals(20, length, 0.0);
  }

  @Test
  public void testZeroRange() {
    Range r2 = new Range(5, 5);
    double length = r2.getLength();
    assertEquals(0, length, 0.0);
  }

  @Test
  public void testNegativeRange() {
    Range r3 = new Range(-10, -5);
    double length = r3.getLength();
    assertEquals(5, length, 0.0);
  }

  @Test
  public void testLargeNumberFirstRange() {
    Range range = new Range(20,10);
    double length = range.getLength();
    assertEquals(10, length, 0.0);
  }

}
