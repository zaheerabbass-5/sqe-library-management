# Boundary Value Analysis — fine_tier()

## 1. Purpose

Boundary Value Analysis (BVA) is used to test values at and around the boundaries of valid input ranges. It helps detect off-by-one errors and incorrect boundary conditions.

The `fine_tier()` function classifies overdue days into different fine tiers.

## 2. Equivalence Classes

| Input Range | Expected Result |
| ----------- | --------------- |
| days < 0    | Invalid         |
| days = 0    | None            |
| 1–7         | Low             |
| 8–14        | Medium          |
| 15–30       | High            |
| days >= 31  | Severe          |

## 3. Boundary Values

The important boundaries are 0, 1, 8, 15, and 31.

| Boundary | Value - 1 | Expected | Boundary Value | Expected | Value + 1 | Expected |
| -------- | --------: | -------- | -------------: | -------- | --------: | -------- |
| 0        |        -1 | Invalid  |              0 | None     |         1 | Low      |
| 1        |         0 | None     |              1 | Low      |         2 | Low      |
| 8        |         7 | Low      |              8 | Medium   |         9 | Medium   |
| 15       |        14 | Medium   |             15 | High     |        16 | High     |
| 31       |        30 | High     |             31 | Severe   |        32 | Severe   |

## 4. BVA Test Values

The complete boundary-focused values are:

```text
-1, 0, 1, 2, 7, 8, 9, 14, 15, 16, 30, 31, 32
```

These values test the points immediately below, at, and immediately above each important boundary.

## 5. Expected Behavior

* Negative overdue days should be rejected as invalid.
* 0 overdue days should return `None`.
* 1–7 overdue days should return `Low`.
* 8–14 overdue days should return `Medium`.
* 15–30 overdue days should return `High`.
* 31 or more overdue days should return `Severe`.

## 6. Conclusion

BVA provides focused tests around the points where the behavior of `fine_tier()` changes. Testing values immediately below, at, and immediately above each boundary helps detect off-by-one defects.
