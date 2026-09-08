## Task 4 — ISBN Validation Test Results

The ISBN validation equivalence partitioning tests were executed successfully.

### Test Execution Summary

```text
Test 1 passed: Exactly 13 numeric digits are valid.
Test 2 passed: Empty ISBN is rejected.
Test 3 passed: Short ISBN is rejected.
Test 4 passed: Long ISBN is rejected.
Test 5 passed: ISBN containing letters is rejected.
Test 6 passed: ISBN containing symbols is rejected.
All ISBN validation tests passed successfully.
```

### Result

All 6 ISBN equivalence partitioning test cases passed successfully.

| Test       | Equivalence Class         | Result |
| ---------- | ------------------------- | ------ |
| TC-ISBN-01 | Exactly 13 numeric digits | PASS   |
| TC-ISBN-02 | Empty string              | PASS   |
| TC-ISBN-03 | Fewer than 13 digits      | PASS   |
| TC-ISBN-04 | More than 13 digits       | PASS   |
| TC-ISBN-05 | Contains letters          | PASS   |
| TC-ISBN-06 | Contains symbols          | PASS   |

The test results confirm that `validateIsbn()` correctly accepts a valid 13-digit numeric ISBN and rejects invalid ISBN inputs.

## Final Test Execution Summary

All Lab 5 Equivalence Partitioning tests were executed successfully.

### Fine Tier Tests

* Test 1 passed: 0 days = None.
* Test 2 passed: 4 days = Low.
* Test 3 passed: 10 days = Medium.
* Test 4 passed: 20 days = High.
* Test 5 passed: 45 days = Severe.
* Test 6 passed: Negative days are rejected.

**Result:** 6/6 Fine Tier tests passed.

### Borrow Limit Tests

* Test 1 passed: Member with 3 books can borrow another book.
* Test 2 passed: Member with 5 books cannot borrow another book.

**Result:** 2/2 Borrow Limit tests passed.

### ISBN Validation Tests

* Test 1 passed: Exactly 13 numeric digits are valid.
* Test 2 passed: Empty ISBN is rejected.
* Test 3 passed: Short ISBN is rejected.
* Test 4 passed: Long ISBN is rejected.
* Test 5 passed: ISBN containing letters is rejected.
* Test 6 passed: ISBN containing symbols is rejected.

**Result:** 6/6 ISBN validation tests passed.

### Overall Result

| Test Area       |  Tests | Passed | Failed |
| --------------- | -----: | -----: | -----: |
| Fine Tier       |      6 |      6 |      0 |
| Borrow Limit    |      2 |      2 |      0 |
| ISBN Validation |      6 |      6 |      0 |
| **Total**       | **14** | **14** |  **0** |

All 14 Lab 5 Equivalence Partitioning tests passed successfully.
