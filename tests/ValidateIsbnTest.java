import com.sqe.Library;

public class ValidateIsbnTest {

    public static void main(String[] args) {

        testValidIsbn();
        testEmptyIsbn();
        testShortIsbn();
        testLongIsbn();
        testIsbnWithLetters();
        testIsbnWithSymbols();

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
}
