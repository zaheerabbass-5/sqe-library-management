import com.sqe.Library;

public class ValidateIsbnTest {

    public static void main(String[] args) {

        testValidIsbn();
        testEmptyIsbn();
        testShortIsbn();
        testLongIsbn();
        testIsbnWithLetters();
        testIsbnWithSymbols();

        testBoundary11();
        testBoundary12();
        testBoundary13();
        testBoundary14();
        testBoundary15();

        System.out.println("All ISBN validation tests passed successfully.");
    }

    public static void testValidIsbn() {

        boolean result = Library.validateIsbn("9780132350884");

        if (!result) {
            throw new AssertionError(
                "Test failed: A 13-digit numeric ISBN should be valid."
            );
        }

        System.out.println(
            "Test 1 passed: Exactly 13 numeric digits are valid."
        );
    }

    public static void testEmptyIsbn() {

        boolean result = Library.validateIsbn("");

        if (result) {
            throw new AssertionError(
                "Test failed: Empty ISBN should be invalid."
            );
        }

        System.out.println(
            "Test 2 passed: Empty ISBN is rejected."
        );
    }

    public static void testShortIsbn() {

        boolean result = Library.validateIsbn("123456789");

        if (result) {
            throw new AssertionError(
                "Test failed: ISBN with fewer than 13 digits should be invalid."
            );
        }

        System.out.println(
            "Test 3 passed: Short ISBN is rejected."
        );
    }

    public static void testLongIsbn() {

        boolean result = Library.validateIsbn("12345678901234");

        if (result) {
            throw new AssertionError(
                "Test failed: ISBN with more than 13 digits should be invalid."
            );
        }

        System.out.println(
            "Test 4 passed: Long ISBN is rejected."
        );
    }

    public static void testIsbnWithLetters() {

        boolean result = Library.validateIsbn("9780132350ABC");

        if (result) {
            throw new AssertionError(
                "Test failed: ISBN containing letters should be invalid."
            );
        }

        System.out.println(
            "Test 5 passed: ISBN containing letters is rejected."
        );
    }

    public static void testIsbnWithSymbols() {

        boolean result = Library.validateIsbn("97801323508@4");

        if (result) {
            throw new AssertionError(
                "Test failed: ISBN containing symbols should be invalid."
            );
        }

        System.out.println(
            "Test 6 passed: ISBN containing symbols is rejected."
        );
    }

    public static void testBoundary11() {

        boolean result = Library.validateIsbn("12345678901");

        if (result) {
            throw new AssertionError(
                "Test failed: 11-digit ISBN should be invalid."
            );
        }

        System.out.println(
            "Test 7 passed: 11-digit ISBN is rejected."
        );
    }

    public static void testBoundary12() {

        boolean result = Library.validateIsbn("123456789012");

        if (result) {
            throw new AssertionError(
                "Test failed: 12-digit ISBN should be invalid."
            );
        }

        System.out.println(
            "Test 8 passed: 12-digit ISBN is rejected."
        );
    }

    public static void testBoundary13() {

        boolean result = Library.validateIsbn("1234567890123");

        if (!result) {
            throw new AssertionError(
                "Test failed: 13-digit ISBN should be valid."
            );
        }

        System.out.println(
            "Test 9 passed: 13-digit ISBN is accepted."
        );
    }

    public static void testBoundary14() {

        boolean result = Library.validateIsbn("12345678901234");

        if (result) {
            throw new AssertionError(
                "Test failed: 14-digit ISBN should be invalid."
            );
        }

        System.out.println(
            "Test 10 passed: 14-digit ISBN is rejected."
        );
    }

    public static void testBoundary15() {

        boolean result = Library.validateIsbn("123456789012345");

        if (result) {
            throw new AssertionError(
                "Test failed: 15-digit ISBN should be invalid."
            );
        }

        System.out.println(
            "Test 11 passed: 15-digit ISBN is rejected."
        );
    }
}
