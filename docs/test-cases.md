# Test Cases

## Library Management System

The following 12 test cases cover the scenarios required by Lab 4. The test cases are based on the current implementation of the Library Management System. Each test case was manually reviewed or executed against the current Java codebase and recorded as PASS, FAIL, or BLOCKED.
| TC-001 | Add book with valid new ISBN | REQ-01 | ISBN-based book creation is supported | Enter valid ISBN, title, author and quantity, then add the book. | Book is added successfully. | High | Positive / Functional | BLOCKED | Execution blocked because the current Book implementation uses bookId and does not support ISBN-based book creation. | — |
| TC-002 | Reject duplicate ISBN | REQ-02 | A book with the ISBN already exists | Attempt to add another book with the same ISBN. | Duplicate ISBN is rejected. | High | Negative / Functional | BLOCKED | Execution blocked because duplicate ISBN checking is not implemented; the current code only checks duplicate bookId values. | — |
| TC-003 | Reject malformed ISBN | REQ-03 | ISBN validation is available | Enter a malformed ISBN and attempt to add the book. | Malformed ISBN is rejected. | High | Negative / Functional | BLOCKED | Execution blocked because ISBN format validation is not implemented in the current Book class. | — |
| TC-004 | Borrow book when copies are available | REQ-05 | Book has available copies and member exists | Create a book with quantity 2, create a member, borrow the book and check quantity. | Borrow succeeds and quantity becomes 1. | High | Positive / Functional | PASS | Manually executed successfully. Available book was borrowed and quantity decreased from 2 to 1. | — |
| TC-005 | Borrow book when no copies are available | REQ-06 | Book quantity is 0 and member exists | Create a book with quantity 0 and attempt to borrow it. | IllegalStateException is raised and quantity remains 0. | Critical | Negative / Functional / Regression | PASS | Manually executed successfully. Borrowing with quantity 0 raised IllegalStateException and quantity remained 0. Verifies Issue #9. | — |
| TC-006 | Return book currently on loan | REQ-07 | Member has borrowed the book | Borrow a book and attempt to return it. | Book is returned and quantity is restored. | High | Positive / Functional | BLOCKED | Execution blocked because book return functionality is not implemented in the current codebase. | — |
| TC-007 | Reject return of book not on loan by member | REQ-07 | Member has not borrowed the book | Attempt to return a book not borrowed by the member. | Invalid return is rejected. | High | Negative / Functional | BLOCKED | Execution blocked because return processing and member loan records are not implemented in the current codebase. | — |
| TC-008 | Member borrowing at allowed limit | REQ-08 | A borrowing limit is defined | Borrow books until the allowed limit is reached. | Member can borrow up to the limit. | High | Positive / Functional | BLOCKED | Execution blocked because the Member class does not implement a borrowing limit or track the number of books borrowed. | — |
| TC-009 | Member borrowing beyond allowed limit | REQ-08 | Member has reached the limit | Attempt to borrow one more book. | Additional borrowing is rejected. | High | Negative / Functional | BLOCKED | Execution blocked because the Member class does not implement borrowing-limit enforcement or track borrowed books. | — |
| TC-010 | Fine calculation for zero days overdue | REQ-08 | Fine rules are available | Set overdue period to 0 days and calculate fine. | Correct fine is calculated. | Medium | Positive / Functional | BLOCKED | Execution blocked because overdue fine calculation is not implemented in the current codebase. | — |
| TC-011 | Fine calculation for mid-range overdue | REQ-08 | Fine tiers are available | Use an overdue period in a middle tier and calculate fine. | Correct tier fine is calculated. | Medium | Positive / Functional | BLOCKED | Execution blocked because fine tiers and overdue fine calculation are not implemented in the current codebase. | — |
| TC-012 | Fine calculation at overdue-tier boundary | REQ-08 | Fine tiers are available | Use the exact boundary between two tiers and calculate fine. | Correct boundary rule is applied. | High | Boundary / Functional | BLOCKED | Execution blocked because overdue fine-tier boundary rules are not implemented in the current codebase. | — |

## Execution Summary

| Result  | Count |
| ------- | ----: |
| PASS    |     2 |
| FAIL    |     0 |
| BLOCKED |    10 |
| Total   |    12 |

## Manual Execution Notes

All 12 test cases were manually reviewed against the current Library Management System Java implementation.

TC-004 was manually executed successfully. A book with quantity 2 was borrowed and the available quantity decreased to 1.

TC-005 was manually executed successfully. Attempting to borrow a book with quantity 0 raised IllegalStateException, and the quantity remained 0. This provides regression coverage for Issue #9.

TC-001, TC-002, and TC-003 were blocked because ISBN-based book creation, duplicate ISBN checking, and ISBN validation are not implemented.

TC-006 and TC-007 were blocked because book return processing and member loan records are not implemented.

TC-008 and TC-009 were blocked because member borrowing limits and limit enforcement are not implemented.

TC-010, TC-011, and TC-012 were blocked because overdue fine calculation and fine-tier rules are not implemented.

No functional test case resulted in FAIL, so no new defect Issue was required from the 12 manual test cases.

## Existing Test Suite Finding

The existing tests/BookBorrowingTest.java could not be compiled against the current Book.java.

The test uses:

```java
new Book("Java Programming", "James Gosling", 2)
```

but the current implementation requires:

```java
Book(bookId, title, author, quantity)
```

The compiler produced:

```text
incompatible types: int cannot be converted to String
```

This is a test-suite defect and is tracked through GitHub Issue #18.

## Defect Tracking

Issue #18 — fix(test): update BookBorrowingTest constructor arguments

The issue tracks the constructor mismatch between the existing test suite and the current Book class implementation.
