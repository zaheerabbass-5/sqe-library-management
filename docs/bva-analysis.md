# Lab 6 — Boundary Value Analysis

## Task 1 — Enumerate All Boundaries

### 1. `fineTier()` Rules

The `fineTier()` function classifies the number of overdue days into different fine tiers.

| Days Overdue | Expected Result |
|---|---|
| days < 0 | Invalid |
| 0 | None |
| 1–7 | Low |
| 8–14 | Medium |
| 15–30 | High |
| days >= 31 | Severe |

### 2. Boundary Values

The important boundaries are:

- **0** — boundary between Invalid and None
- **1** — boundary between None and Low
- **8** — boundary between Low and Medium
- **15** — boundary between Medium and High
- **31** — boundary between High and Severe

For each boundary, BVA tests the value immediately below the boundary, the boundary itself, and the value immediately above the boundary.

| Boundary | Value - 1 | Expected | Boundary Value | Expected | Value + 1 | Expected |
|---|---:|---|---:|---|---:|---|
| 0 | -1 | Invalid | 0 | None | 1 | Low |
| 1 | 0 | None | 1 | Low | 2 | Low |
| 8 | 7 | Low | 8 | Medium | 9 | Medium |
| 15 | 14 | Medium | 15 | High | 16 | High |
| 31 | 30 | High | 31 | Severe | 32 | Severe |

### 3. BVA Test Values

The boundary-focused test values are:

```text
-1, 0, 1, 2, 7, 8, 9, 14, 15, 16, 30, 31, 32
