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
