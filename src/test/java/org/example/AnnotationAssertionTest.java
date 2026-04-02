package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class AnnotationAssertionTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite: Starting the entire test suite.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: Preparing to execute tests.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: Starting AnnotationAssertionTest class.");
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("BeforeMethod: Browser opened.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("AfterMethod: Browser closed.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: Finished executing AnnotationAssertionTest class.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: Finished all tests.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite: Entire test suite execution completed.");
    }

    // Test 1: Check if a number and its reversed number are equal
    @Test(priority = 1)
    public void testReverseNumberEquality() {
        int number = 121;
        int original = number;
        int reverse = 0;

        while (number > 0) {
            reverse = reverse * 10 + (number % 10);
            number = number / 10;
        }

        System.out.println("Original Number: " + original);
        System.out.println("Reversed Number: " + reverse);

        Assert.assertEquals(reverse, original, "The number and reversed number are not equal.");
    }

    // Test 2: Check if the factorial of a given number is correct
    @Test(priority = 2)
    public void testFactorial() {
        int number = 5;
        int factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + number + " is " + factorial);

        Assert.assertEquals(factorial, 120, "Factorial result is incorrect.");
    }

    // Test 3: Check if a given number is prime
    @Test(priority = 3)
    public void testPrimeNumber() {
        int number = 7;
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println("Is " + number + " prime? " + isPrime);

        Assert.assertTrue(isPrime, "The given number is not prime.");
    }

    // Test 4: Verify that actual web page title is NOT equal to expected title
    @Test(priority = 4)
    public void testTitleNotEqual() {
        driver.get("https://example.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        System.out.println("Actual Title: " + actualTitle);
        System.out.println("Expected Title: " + expectedTitle);

        Assert.assertNotEquals(actualTitle, expectedTitle, "The actual title should not match the expected title.");
    }

    // Test 5: Verify that actual URL matches expected URL
    @Test(priority = 5)
    public void testUrlMatch() {
        driver.get("https://example.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://example.com/";

        System.out.println("Actual URL: " + actualUrl);
        System.out.println("Expected URL: " + expectedUrl);

        Assert.assertEquals(actualUrl, expectedUrl, "The actual URL does not match the expected URL.");
    }

    // Test 6: Verify that the size of elements on a web page matches expected size
    @Test(priority = 6)
    public void testElementSize() {
        driver.get("https://example.com");

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        int actualSize = elements.size();

        System.out.println("Actual number of link elements: " + actualSize);

        Assert.assertTrue(actualSize > 0, "Element size/count does not meet expected value.");
    }

    // Test 7: Check if a string is a palindrome
    @Test(priority = 7)
    public void testPalindromeString() {
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        System.out.println("Original String: " + word);
        System.out.println("Reversed String: " + reversed);

        Assert.assertEquals(word, reversed, "The string is not a palindrome.");
    }

    // Test 8: Validate the sum of digits of a number
    @Test(priority = 8)
    public void testSumOfDigits() {
        int number = 123;
        int temp = number;
        int sum = 0;

        while (temp > 0) {
            sum += temp % 10;
            temp = temp / 10;
        }

        System.out.println("Sum of digits of " + number + " is " + sum);

        Assert.assertEquals(sum, 6, "The sum of digits is incorrect.");
    }

    // Test 9: Verify whether a number is even or odd
    @Test(priority = 9)
    public void testEvenOrOdd() {
        int number = 4;
        boolean isOdd = number % 2 != 0;

        System.out.println("Number " + number + " is odd? " + isOdd);

        Assert.assertFalse(isOdd, "The number should be even, but it is odd.");
    }

    // Test 10: Verify that web element text matches expected value
    @Test(priority = 10)
    public void testElementText() {
        driver.get("https://example.com");

        String actualText = driver.findElement(By.tagName("h1")).getText();
        String expectedText = "Example Domain";

        System.out.println("Actual Text: " + actualText);
        System.out.println("Expected Text: " + expectedText);

        Assert.assertEquals(actualText, expectedText, "The web element text does not match the expected value.");
    }
}
