import com.sqe.Book;
import com.sqe.Member;

public class BorrowLimitTest {

    public static void main(String[] args) {

        testMemberWithThreeBooks();
        testMemberWithFiveBooks();

        System.out.println("All borrow limit tests passed successfully.");
    }

    public static void testMemberWithThreeBooks() {

        Member member = new Member("Ali", "M101");

        member.setBooksOnLoan(3);

        Book book = new Book(
            "B101",
            "Java Programming",
            "James Gosling",
            2
        );

        member.borrowBook(book);

        if (member.getBooksOnLoan() != 4) {
            throw new AssertionError(
                "Test failed: Member with 3 books should be able to borrow another book."
            );
        }

        System.out.println(
            "Test 1 passed: Member with 3 books can borrow another book."
        );
    }

    public static void testMemberWithFiveBooks() {

        Member member = new Member("Ahmed", "M102");

        member.setBooksOnLoan(5);

        Book book = new Book(
            "B102",
            "Data Structures",
            "Mark Allen",
            2
        );

        try {

            member.borrowBook(book);

            throw new AssertionError(
                "Test failed: Member with 5 books should not be allowed to borrow another book."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                "Test 2 passed: Member with 5 books cannot borrow another book."
            );
        }
    }
}
