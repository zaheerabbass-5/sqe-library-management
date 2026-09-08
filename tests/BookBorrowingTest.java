import com.sqe.Book;
import com.sqe.Member;

public class BookBorrowingTest {

    public static void main(String[] args) {

        testBorrowAvailableBook();
        testBorrowUnavailableBook();
        testQuantityDoesNotGoBelowZero();

        System.out.println("All Issue #9 tests passed successfully.");
    }

    public static void testBorrowAvailableBook() {

        Book book = new Book("B201", "Java Programming", "James Gosling", 2);
        Member member = new Member("Ali", "M001");

        member.borrowBook(book);

        if (book.getAvailableQuantity() != 1) {
            throw new AssertionError(
                "Test failed: Available quantity should become 1 after borrowing."
            );
        }

        System.out.println("Test 1 passed: Available book can be borrowed.");
    }

    public static void testBorrowUnavailableBook() {

        Book book = new Book("B202", "Java Programming", "James Gosling", 0);
        Member member = new Member("Ali", "M002");

        try {

            member.borrowBook(book);

            throw new AssertionError(
                "Test failed: Borrowing should not be allowed when quantity is 0."
            );

        } catch (IllegalStateException e) {

            if (!e.getMessage().equals("No copies are available.")) {
                throw new AssertionError(
                    "Test failed: Incorrect error message."
                );
            }

            System.out.println(
                "Test 2 passed: Borrowing an unavailable book is prevented."
            );
        }
    }

    public static void testQuantityDoesNotGoBelowZero() {

        Book book = new Book("B203", "Java Programming", "James Gosling", 0);
        Member member = new Member("Ali", "M003");

        try {

            member.borrowBook(book);

        } catch (IllegalStateException e) {

        }

        if (book.getAvailableQuantity() != 0) {
            throw new AssertionError(
                "Test failed: Available quantity should not go below zero."
            );
        }

        System.out.println(
            "Test 3 passed: Quantity remains zero after failed borrowing."
        );
    }
}
