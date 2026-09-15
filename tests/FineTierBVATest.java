import com.sqe.Library;

public class FineTierBVATest {

    public static void main(String[] args) {

        testBoundary0();
        testBoundary1();
        testBoundary8();
        testBoundary15();
        testBoundary31();

        System.out.println("All BVA fine tier tests passed successfully.");
    }

    public static void testBoundary0() {

        try {
            Library.fineTier(-1);
            throw new AssertionError(
                "Test failed: -1 days should be rejected."
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Test 1 passed: -1 days = Invalid.");
        }

        String result = Library.fineTier(0);

        if (!result.equals("None")) {
            throw new AssertionError(
                "Test failed: 0 days should return None."
            );
        }

        System.out.println("Test 2 passed: 0 days = None.");

        result = Library.fineTier(1);

        if (!result.equals("Low")) {
            throw new AssertionError(
                "Test failed: 1 day should return Low."
            );
        }

        System.out.println("Test 3 passed: 1 day = Low.");
    }

    public static void testBoundary1() {

        String result = Library.fineTier(0);

        if (!result.equals("None")) {
            throw new AssertionError(
                "Test failed: 0 days should return None."
            );
        }

        System.out.println("Test 4 passed: 0 days = None.");

        result = Library.fineTier(1);

        if (!result.equals("Low")) {
            throw new AssertionError(
                "Test failed: 1 day should return Low."
            );
        }

        System.out.println("Test 5 passed: 1 day = Low.");

        result = Library.fineTier(2);

        if (!result.equals("Low")) {
            throw new AssertionError(
                "Test failed: 2 days should return Low."
            );
        }

        System.out.println("Test 6 passed: 2 days = Low.");
    }

    public static void testBoundary8() {

        String result = Library.fineTier(7);

        if (!result.equals("Low")) {
            throw new AssertionError(
                "Test failed: 7 days should return Low."
            );
        }

        System.out.println("Test 7 passed: 7 days = Low.");

        result = Library.fineTier(8);

        if (!result.equals("Medium")) {
            throw new AssertionError(
                "Test failed: 8 days should return Medium."
            );
        }

        System.out.println("Test 8 passed: 8 days = Medium.");

        result = Library.fineTier(9);

        if (!result.equals("Medium")) {
            throw new AssertionError(
                "Test failed: 9 days should return Medium."
            );
        }

        System.out.println("Test 9 passed: 9 days = Medium.");
    }

    public static void testBoundary15() {

        String result = Library.fineTier(14);

        if (!result.equals("Medium")) {
            throw new AssertionError(
                "Test failed: 14 days should return Medium."
            );
        }

        System.out.println("Test 10 passed: 14 days = Medium.");

        result = Library.fineTier(15);

        if (!result.equals("High")) {
            throw new AssertionError(
                "Test failed: 15 days should return High."
            );
        }

        System.out.println("Test 11 passed: 15 days = High.");

        result = Library.fineTier(16);

        if (!result.equals("High")) {
            throw new AssertionError(
                "Test failed: 16 days should return High."
            );
        }

        System.out.println("Test 12 passed: 16 days = High.");
    }

    public static void testBoundary31() {

        String result = Library.fineTier(30);

        if (!result.equals("High")) {
            throw new AssertionError(
                "Test failed: 30 days should return High."
            );
        }

        System.out.println("Test 13 passed: 30 days = High.");

        result = Library.fineTier(31);

        if (!result.equals("Severe")) {
            throw new AssertionError(
                "Test failed: 31 days should return Severe."
            );
        }

        System.out.println("Test 14 passed: 31 days = Severe.");

        result = Library.fineTier(32);

        if (!result.equals("Severe")) {
            throw new AssertionError(
                "Test failed: 32 days should return Severe."
            );
        }

        System.out.println("Test 15 passed: 32 days = Severe.");
    }
}
