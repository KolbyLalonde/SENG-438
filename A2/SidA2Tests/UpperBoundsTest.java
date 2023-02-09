package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class UpperBoundsTest {

  @Test
  public void testPositiveRange() {
    Range range = new Range(0, 10);
    double UpperBound = range.getUpperBound();
    assertEquals(0, UpperBound, 0.0);
  }

  @Test
  public void testZeroRange() {
    Range range = new Range(5, 5);
    double UpperBound = range.getUpperBound();
    assertEquals(5, UpperBound, 0.0);
  }

  @Test
  public void testNegativeRange() {
    Range range = new Range(-5, -10);
    double UpperBound = range.getUpperBound();
    assertEquals(-10, UpperBound, 0.0);
  }

  @Test
  public void testLargeNumberFirstRange() {
    Range range = new Range(10, 0);
    double UpperBound = range.getUpperBound();
    assertEquals(0, UpperBound, 0.0);
  }

}
