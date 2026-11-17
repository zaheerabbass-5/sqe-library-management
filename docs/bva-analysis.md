# Lab 6 — Boundary Value Analysis

## Task 1 — Enumerate All Boundaries

### 1. `fineTier()` Rules

The `fineTier()` function classifies the number of overdue days into different fine tiers.

| Days Overdue | Expected Result |
| ------------ | --------------- |
| days < 0     | Invalid         |
| 0            | None            |
| 1–7          | Low             |
| 8–14         | Medium          |
| 15–30        | High            |
| days >= 31   | Severe          |

### 2. Boundary Values

The important boundaries are:

* **0** — boundary between Invalid and None
* **1** — boundary between None and Low
* **8** — boundary between Low and Medium
* **15** — boundary between Medium and High
* **31** — boundary between High and Severe

For each boundary, BVA tests the value immediately below the boundary, the boundary itself, and the value immediately above the boundary.

| Boundary | Value - 1 | Expected | Boundary Value | Expected | Value + 1 | Expected |
| -------- | --------: | -------- | -------------: | -------- | --------: | -------- |
| 0        |        -1 | Invalid  |              0 | None     |         1 | Low      |
| 1        |         0 | None     |              1 | Low      |         2 | Low      |
| 8        |         7 | Low      |              8 | Medium   |         9 | Medium   |
| 15       |        14 | Medium   |             15 | High     |        16 | High     |
| 31       |        30 | High     |             31 | Severe   |        32 | Severe   |

### 3. BVA Test Values

The boundary-focused test values are:

```text
-1, 0, 1, 2, 7, 8, 9, 14, 15, 16, 30, 31, 32
```

The value `2` is included because it is immediately above the boundary at `1`.

### 4. Expected Behavior

* Negative days should be rejected.
* 0 days should return `None`.
* 1–7 days should return `Low`.
* 8–14 days should return `Medium`.
* 15–30 days should return `High`.
* 31 or more days should return `Severe`.

### 5. Purpose of BVA

Equivalence Partitioning from Lab 5 tested representative values from each class. BVA complements EP by testing values around the boundaries where off-by-one errors are likely to occur.

For example, the boundary between Medium and High is 15. Therefore, BVA tests 14, 15, and 16 to verify that the boundary is correctly implemented.

---

## Task 2 — Full Boundary Suite for `fineTier()`

The boundary test suite was implemented in:

```text
tests/FineTierBVATest.java
```

The test suite checks the boundary values and their neighboring values for all `fineTier()` boundaries.

The tested values are:

```text
-1, 0, 1, 2, 7, 8, 9, 14, 15, 16, 30, 31, 32
```

### BVA Test Result

All boundary tests passed successfully.

The tests confirmed that:

* `-1` is rejected as invalid.
* `0` returns `None`.
* `1` and `2` return `Low`.
* `7` returns `Low`.
* `8` and `9` return `Medium`.
* `14` returns `Medium`.
* `15` and `16` return `High`.
* `30` returns `High`.
* `31` and `32` return `Severe`.

No defect was found in the `fineTier()` implementation.

---

## Task 3 — Borrow Limit Boundary Analysis

### 1. Borrow Limit Rule

A member may have between 0 and 5 books on loan.

A member with 5 books on loan cannot borrow another book.

### 2. Boundary

The important boundary is **5 books**.

The BVA values are:

* **4** — immediately below the boundary
* **5** — boundary value
* **6** — immediately above the boundary

| Current Books | Attempt       | Expected Result          |
| ------------: | ------------- | ------------------------ |
|             4 | Borrow 1 more | Allowed; total becomes 5 |
|             5 | Borrow 1 more | Rejected                 |
|             6 | Borrow 1 more | Rejected                 |

### 3. Boundary Test Implementation

The boundary tests were added to:

```text
tests/BorrowLimitTest.java
```

The tests check members currently having 4, 5, and 6 books and attempting to borrow one more book.

### 4. BVA Test Result

All borrow-limit boundary tests passed.

* **4 books** → borrowing one more was allowed, resulting in 5 books.
* **5 books** → borrowing one more was rejected.
* **6 books** → borrowing one more was rejected.

No defect was found in the borrow-limit rule.

Therefore, no defect issue or bug-fix branch was required.

---

## Task 4 — ISBN Length Boundary Analysis

### 1. ISBN Validation Rule

An ISBN is valid only when it contains exactly **13 numeric digits**.

### 2. Boundary

The valid boundary is **13 digits**.

The BVA test values are:

* **11 digits** — below the boundary
* **12 digits** — immediately below the boundary
* **13 digits** — boundary value
* **14 digits** — immediately above the boundary
* **15 digits** — above the boundary

| ISBN Length | Expected Result |
| ----------: | --------------- |
|   11 digits | Invalid         |
|   12 digits | Invalid         |
|   13 digits | Valid           |
|   14 digits | Invalid         |
|   15 digits | Invalid         |

### 3. Boundary Test Implementation

The boundary tests were added to:

```text
tests/ValidateIsbnTest.java
```

The tests verify ISBN strings with lengths of 11, 12, 13, 14, and 15 digits.

### 4. BVA Test Result

All five ISBN boundary tests passed.

* **11 digits** → rejected.
* **12 digits** → rejected.
* **13 digits** → accepted.
* **14 digits** → rejected.
* **15 digits** → rejected.

The 13-digit boundary was accepted correctly, while the values immediately below and above the boundary were rejected.

No defect was found in the ISBN validation rule.

Therefore, no defect issue or bug-fix branch was required.

---

## Overall Lab 6 Result

Boundary Value Analysis was applied to the following LibraryHub functions and rules:

| Function / Rule | Boundary Values                            | Result           |
| --------------- | ------------------------------------------ | ---------------- |
| `fineTier()`    | -1, 0, 1, 8, 15, 31 and neighboring values | All tests passed |
| Borrow Limit    | 4, 5, 6 books                              | All tests passed |
| ISBN Length     | 11, 12, 13, 14, 15 digits                  | All tests passed |

### Conclusion

The Boundary Value Analysis tests successfully verified the important boundaries in the LibraryHub system.

No defects were found during Lab 6 boundary testing. Therefore, no defect-fix issue or pull request was required.

The tests confirmed that the existing implementations correctly handle values immediately below, at, and immediately above the identified boundaries.
