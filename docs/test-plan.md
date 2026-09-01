# Software Test Plan

## Library Management System

### 1. Introduction

This Test Plan defines the testing approach for the SQE Library Management System. The current system is implemented in Java and contains functionality for book creation, book ID management, book title and author validation, quantity management, book borrowing, member creation, member validation, and book ratings. The purpose of testing is to verify that implemented functionality behaves correctly and that invalid operations are properly rejected.

### 2. Test Items

The following Java components are included in the current test scope:

* `Book.java`
* `Member.java`
* `BookBorrowingTest.java`

The main functionality under test includes book creation, book validation, quantity management, borrowing available books, preventing borrowing when no copies are available, member validation, and rating validation.

### 3. Features to be Tested

The following features will be tested:

1. Creating a book with valid information.
2. Rejecting duplicate book IDs.
3. Rejecting empty book titles.
4. Rejecting empty author names.
5. Rejecting negative book quantities.
6. Borrowing a book when copies are available.
7. Preventing borrowing when no copies are available.
8. Ensuring book quantity does not become negative.
9. Creating a member with valid information.
10. Rejecting invalid member information.
11. Rejecting negative book ratings.
12. Maintaining correct available book quantity after borrowing.

### 4. Features Not to be Tested

ISBN-specific functionality is not tested because the current implementation uses a `bookId` rather than an ISBN field. Book return functionality, member borrowing limits, and fine calculation are also not implemented in the current `Book` and `Member` classes, so they cannot be functionally executed against the current codebase. These areas may be tested in a future version when the corresponding functionality is implemented.

### 5. Test Approach

Functional testing will be used to verify the behavior of individual methods and classes. Positive tests will verify valid operations, while negative tests will verify that invalid inputs and unavailable operations are correctly rejected. Regression testing will also be performed for Issue #9, which concerns preventing users from borrowing books when no copies are available.

### 6. Test Levels

#### Unit-Level Testing

Individual methods and constructors in `Book` and `Member` will be tested.

#### Integration-Level Testing

Interaction between `Member.borrowBook()` and `Book.borrowBook()` will be tested to verify that borrowing correctly changes book availability.

#### Regression Testing

The existing Issue #9 borrowing tests will be used as regression tests to ensure that unavailable books cannot be borrowed.

### 7. Pass/Fail Criteria

Testing will be considered successful when:

* At least 95% of executable planned test cases pass.
* All Critical defects are resolved or formally accepted.
* All implemented high-priority requirements have at least one passing test.
* The Issue #9 unavailable-book behavior passes its regression tests.
* No executable test remains without a recorded result.

A test case passes when the actual result matches the expected result. A test case fails when the actual result differs from the expected result. A test case is Blocked when the required functionality is not implemented or the test cannot be executed because of an environmental or code dependency.

### 8. Test Deliverables

The following deliverables will be produced:

* `docs/test-plan.md`
* `docs/test-cases.md`
* `docs/rtm.md`
* Manual execution results
* GitHub Issues for confirmed failures
* Screenshots or other evidence where required

### 9. Environmental Needs

Testing will be performed using:

* Windows operating system
* Java JDK
* VS Code
* Git and GitHub
* `sqe-library-management` repository

The Java source files will be compiled before executing the test cases.

### 10. Test Data

The test data will include:

* Unique book IDs
* Duplicate book IDs
* Valid book titles
* Empty book titles
* Valid author names
* Empty author names
* Positive book quantities
* Zero book quantities
* Negative book quantities
* Valid member names and IDs
* Invalid member names and IDs
* Valid and negative rating values

### 11. Schedule

| Activity                         | Estimated Time |
| -------------------------------- | -------------: |
| Test Plan                        |     60 minutes |
| Test Cases                       |     75 minutes |
| Requirements Traceability Matrix |     30 minutes |
| Manual Execution                 |     35 minutes |
| Total                            |        3 hours |

### 12. Risks and Mitigations

| Risk                                                     | Mitigation                                   |
| -------------------------------------------------------- | -------------------------------------------- |
| Some laboratory requirements are not implemented         | Mark the corresponding test as Blocked       |
| Existing test code may not match the current source code | Verify compilation before execution          |
| One test may affect another through static book IDs      | Use unique book IDs for each test            |
| Existing defects may cause failures                      | Record the failure and create a GitHub Issue |
| Future changes may break Issue #9 behavior               | Include Issue #9 tests as regression tests   |

### 13. Entry Criteria

Testing can begin when:

* The latest project code has been obtained from the `main` branch.
* The Java source files are available.
* The test documentation has been prepared.
* The Java project can be compiled or compilation problems have been identified.
* Test data has been defined.

### 14. Exit Criteria

Testing will be completed when:

* All 12 planned test cases have a recorded result.
* Every requirement is linked to at least one test case.
* Failures have been investigated.
* Confirmed defects have corresponding GitHub Issues.
* Blocked tests have documented reasons.
* The Test Plan, Test Cases, and RTM are committed to the repository.

### 15. Requirement Summary

| Requirement ID | Requirement                                                                                            |
| -------------- | ------------------------------------------------------------------------------------------------------ |
| REQ-01         | The system shall allow creation of a book with valid information.                                      |
| REQ-02         | The system shall reject duplicate book IDs.                                                            |
| REQ-03         | The system shall reject invalid book title or author information.                                      |
| REQ-04         | The system shall reject negative book quantities.                                                      |
| REQ-05         | The system shall allow borrowing when copies are available.                                            |
| REQ-06         | The system shall prevent borrowing when no copies are available.                                       |
| REQ-07         | The system shall prevent book quantity from becoming negative after an unsuccessful borrowing attempt. |
| REQ-08         | The system shall validate member information and book ratings.                                         |
