# Requirements Traceability Matrix (RTM)

## Library Management System

The Requirements Traceability Matrix maps each Library Management System requirement to one or more test cases. It ensures that every requirement has test coverage and helps identify requirements that cannot currently be executed because the corresponding functionality has not yet been implemented.

| Requirement ID | Requirement                                                                 | Test Case IDs                          | Coverage | Execution Status                                               |
| -------------- | --------------------------------------------------------------------------- | -------------------------------------- | -------- | -------------------------------------------------------------- |
| REQ-01         | The system shall allow creation of a book with valid information.           | TC-001                                 | Covered  | To be Executed                                                 |
| REQ-02         | The system shall reject duplicate book IDs.                                 | TC-002                                 | Covered  | To be Executed                                                 |
| REQ-03         | The system shall reject invalid book identification data.                   | TC-003                                 | Covered  | Blocked — ISBN validation not implemented                      |
| REQ-04         | The system shall reject negative book quantities.                           | TC-001, TC-004                         | Covered  | To be Executed                                                 |
| REQ-05         | The system shall allow borrowing when copies are available.                 | TC-004                                 | Covered  | To be Executed                                                 |
| REQ-06         | The system shall prevent borrowing when no copies are available.            | TC-005                                 | Covered  | To be Executed                                                 |
| REQ-07         | The system shall handle book return operations correctly.                   | TC-006, TC-007                         | Covered  | Blocked — return functionality not implemented                 |
| REQ-08         | The system shall validate member borrowing rules and overdue fine behavior. | TC-008, TC-009, TC-010, TC-011, TC-012 | Covered  | Blocked — borrowing limit and fine calculation not implemented |

## Coverage Summary

All eight documented requirements have at least one linked test case. Therefore, there are currently no requirements with zero test-case coverage.

Some test cases are marked Blocked because the corresponding functionality is not implemented in the current Java codebase. These tests remain in the RTM because they represent requirements specified by the laboratory exercise and identify functionality that would need to be implemented before those tests can be executed.

## Requirement Coverage

| Category                           | Number |
| ---------------------------------- | -----: |
| Total Requirements                 |      8 |
| Requirements with Test Coverage    |      8 |
| Requirements without Test Coverage |      0 |
| Coverage Percentage                |   100% |

## Blocked Requirements

The following functionality is currently unavailable in the implementation:

* ISBN validation
* Book return functionality
* Member borrowing limit
* Fine calculation and overdue tiers

These items should be considered future implementation requirements or scope items for a later version of the system.
