# Test Cases

## Library Management System

The following 12 test cases cover the scenarios required by Lab 4. The test cases are based on the current implementation of the Library Management System. Where the required functionality is not present in the current Java codebase, the test is marked as **BLOCKED**.

| ID | Title | Requirement | Preconditions | Steps | Expected | Priority | Type | Result | Notes | Issue |
|---|---|---|---|---|---|---|---|---|---|---|
| TC-001 | Add book with valid new ISBN | REQ-01 | ISBN-based book creation is supported | Enter valid ISBN, title, author and quantity, then add the book. | Book is added successfully. | High | Positive / Functional | BLOCKED | ISBN is not implemented. | — |
| TC-002 | Reject duplicate ISBN | REQ-02 | A book with the ISBN already exists | Attempt to add another book with the same ISBN. | Duplicate ISBN is rejected. | High | Negative / Functional | BLOCKED | ISBN is not implemented. | — |
| TC-003 | Reject malformed ISBN | REQ-03 | ISBN validation is available | Enter a malformed ISBN and attempt to add the book. | Malformed ISBN is rejected. | High | Negative / Functional | BLOCKED | ISBN validation is not implemented. | — |
| TC-004 | Borrow book when copies are available | REQ-05 | Book has available copies and member exists | Create a book with quantity 2, create a member, borrow the book and check quantity. | Borrow succeeds and quantity becomes 1. | High | Positive / Functional | PASS | Manually executed successfully. | — |
| TC-005 | Borrow book when no copies are available | REQ-06 | Book quantity is 0 and member exists | Create a book with quantity 0 and attempt to borrow it. | `IllegalStateException` is raised and quantity remains 0. | Critical | Negative / Functional / Regression | PASS | Manually executed successfully. Verifies Issue #9. | — |
| TC-006 | Return book currently on loan | REQ-07 | Member has borrowed the book | Borrow a book and attempt to return it. | Book is returned and quantity is restored. | High | Positive / Functional | BLOCKED | `returnBook()` is not implemented. | — |
| TC-007 | Reject return of book not on loan by member | REQ-07 | Member has not borrowed the book | Attempt to return a book not borrowed by the member. | Invalid return is rejected. | High | Negative / Functional | BLOCKED | Return and loan records are not implemented. | — |
| TC-008 | Member borrowing at allowed limit | REQ-08 | A borrowing limit is defined | Borrow books until the allowed limit is reached. | Member can borrow up to the limit. | High | Positive / Functional | BLOCKED | Borrowing limit is not implemented. | — |
| TC-009 | Member borrowing beyond allowed limit | REQ-08 | Member has reached the limit | Attempt to borrow one more book. | Additional borrowing is rejected. | High | Negative / Functional | BLOCKED | Borrowing limit is not implemented. | — |
| TC-010 | Fine calculation for zero days overdue | REQ-08 | Fine rules are available | Set overdue period to 0 days and calculate fine. | Correct fine is calculated. | Medium | Positive / Functional | BLOCKED | Fine calculation is not implemented. | — |
| TC-011 | Fine calculation for mid-range overdue | REQ-08 | Fine tiers are available | Use an overdue period in a middle tier and calculate fine. | Correct tier fine is calculated. | Medium | Positive / Functional | BLOCKED | Fine calculation is not implemented. | — |
| TC-012 | Fine calculation at overdue-tier boundary | REQ-08 | Fine tiers are available | Use the exact boundary between two tiers and calculate fine. | Correct boundary rule is applied. | High | Boundary / Functional | BLOCKED | Fine calculation is not implemented. | — |

## Execution Summary

| Result | Count |
|---|---:|
| PASS | 2 |
| FAIL | 0 |
| BLOCKED | 10 |
| Total | 12 |

## Manual Execution Notes

TC-004 and TC-005 were manually executed against the current Java implementation and passed successfully.

TC-005 provides regression coverage for Issue #9, which prevents users from borrowing a book when no copies are available.

The remaining 10 test cases are BLOCKED because ISBN validation, book return functionality, member borrowing limits, and fine calculation are not implemented in the current codebase.

## Existing Test Suite Finding

The existing `tests/BookBorrowingTest.java` could not be compiled against the current `Book.java`.

The test uses:

`new Book("Java Programming", "James Gosling", 2)`

but the current implementation requires:

`Book(bookId, title, author, quantity)`

The compiler produced:

`incompatible types: int cannot be converted to String`

This is a test-suite defect and should be tracked through a GitHub Issue.
