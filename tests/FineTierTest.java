import com.sqe.Library;

public class FineTierTest {

    public static void main(String[] args) {

        testNoFine();
        testLowFine();
        testMediumFine();
        testHighFine();
        testSevereFine();
        testInvalidDays();

        System.out.println("All fine tier tests passed successfully.");
    }

    public static void testNoFine() {

        String result = Library.fineTier(0);

        if (!result.equals("None")) {
            throw new AssertionError(
                "Test failed: 0 days should return None."
            );
        }

        System.out.println("Test 1 passed: 0 days = None.");
    }

    public static void testLowFine() {

        String result = Library.fineTier(4);

        if (!result.equals("Low")) {
            throw new AssertionError(
                "Test failed: 4 days should return Low."
            );
        }

        System.out.println("Test 2 passed: 4 days = Low.");
    }

    public static void testMediumFine() {

        String result = Library.fineTier(10);

        if (!result.equals("Medium")) {
            throw new AssertionError(
                "Test failed: 10 days should return Medium."
            );
        }

        System.out.println("Test 3 passed: 10 days = Medium.");
    }

    public static void testHighFine() {

        String result = Library.fineTier(20);

        if (!result.equals("High")) {
            throw new AssertionError(
                "Test failed: 20 days should return High."
            );
        }

        System.out.println("Test 4 passed: 20 days = High.");
    }

    public static void testSevereFine() {

        String result = Library.fineTier(45);

        if (!result.equals("Severe")) {
            throw new AssertionError(
                "Test failed: 45 days should return Severe."
            );
        }

        System.out.println("Test 5 passed: 45 days = Severe.");
    }

    public static void testInvalidDays() {

        try {

            Library.fineTier(-3);

            throw new AssertionError(
                "Test failed: Negative days should be rejected."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                "Test 6 passed: Negative days are rejected."
            );
        }
    }
}
