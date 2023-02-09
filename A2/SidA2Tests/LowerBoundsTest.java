package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class LowerBoundsTest {

  @Test
  public void testPositiveRange() {
    Range range = new Range(0, 10);
    double lowerBound = range.getLowerBound();
    assertEquals(0, lowerBound, 0.0);
  }

  @Test
  public void testZeroRange() {
    Range range = new Range(5, 5);
    double lowerBound = range.getLowerBound();
    assertEquals(5, lowerBound, 0.0);
  }

  @Test
  public void testNegativeRange() {
    Range range = new Range(-10, -5);
    double lowerBound = range.getLowerBound();
    assertEquals(-10, lowerBound, 0.0);
  }

  @Test
  public void testLargeNumberFirstRange() {
    Range range = new Range(10, 0);
    double lowerBound = range.getLowerBound();
    assertEquals(0, lowerBound, 0.0);
  }

}
