# Lab 5 — Black-Box Testing Using Equivalence Partitioning

## LibraryHub

### Task 1 — Equivalence Partitioning Analysis

Equivalence Partitioning (EP) is a black-box testing technique that divides an input domain into groups called equivalence classes. Values within the same class are expected to behave similarly. Instead of testing every possible input, one representative value is selected from each class.

---

## 1. Number of Books on Loan

### Business Rule

A member may have between **0 and 5 books on loan simultaneously**.

### Equivalence Classes

| Class | Input Range     | Valid/Invalid | Representative Value |
| ----- | --------------- | ------------- | -------------------: |
| EC1   | 0–5 books       | Valid         |                    3 |
| EC2   | 6 or more books | Invalid       |                    6 |

### Explanation

The valid class contains values from 0 to 5 because a member is allowed to have a maximum of 5 books on loan at the same time.

The invalid class contains values of 6 or more because a member is not allowed to have more than 5 books on loan.

The representative value **3** is selected for the valid class, and **6** is selected for the invalid class.

---

## 2. ISBN Validation

### Business Rule

A book ISBN must contain **exactly 13 numeric digits**. Letters and symbols are not allowed.

### Equivalence Classes

| Class | Input Condition           | Valid/Invalid | Representative Value |
| ----- | ------------------------- | ------------- | -------------------- |
| EC1   | Exactly 13 numeric digits | Valid         | `9780132350884`      |
| EC2   | Empty string              | Invalid       | `""`                 |
| EC3   | Fewer than 13 digits      | Invalid       | `"123456789"`        |
| EC4   | More than 13 digits       | Invalid       | `"12345678901234"`   |
| EC5   | Contains letters          | Invalid       | `"9780132350ABC"`    |
| EC6   | Contains symbols          | Invalid       | `"97801323508@4"`    |

### Explanation

EC1 contains ISBN values that have exactly 13 numeric digits and are valid.

EC2 contains an empty ISBN value, which is invalid.

EC3 contains ISBN values with fewer than 13 digits.

EC4 contains ISBN values with more than 13 digits.

EC5 contains letters, which are not allowed in the ISBN.

EC6 contains symbols, which are also not allowed.

Each equivalence class has a representative value that will later be used to create automated pytest tests.

---

## 3. Limitation of Equivalence Partitioning

Equivalence Partitioning reduces the number of test cases by selecting representative values from groups of inputs that are expected to behave similarly. However, EP can miss errors at the exact boundaries between equivalence classes.

For example, for the borrow limit, EP uses **3** as a representative of the valid class and **6** as a representative of the invalid class. It does not specifically test the boundary values **5** and **6**.

Similarly, for ISBN validation, EP does not specifically focus on the transition between **12, 13, and 14 digits**.

These boundary-related cases will be addressed using **Boundary Value Analysis (BVA)** in Lab 6.

