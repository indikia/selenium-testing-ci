package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnotationAssertionTest {

@Test
public void simplePassTest() {
System.out.println("GitHub Actions demo test running...");
Assert.assertTrue(true);
}
}
