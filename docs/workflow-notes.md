# Git Workflow Notes

## Task 3 — Deliberate Merge Conflict

### What caused the conflict?

The conflict was intentionally created by modifying the same line in
`src/main/java/com/sqe/Book.java` differently on two feature branches.

The original line was:

```java
private String title;
```

Branch `feature/rename-field-a` changed it to:

```java
private String bookTitle;
```

Branch `feature/rename-field-b` changed it to:

```java
private String bookName;
```

Branch A was merged into `main` first.

When Branch B was merged into the updated `main`, Git could not automatically
decide which version should be kept because both branches modified the same
line differently.

### How the conflict was resolved

The conflict was resolved locally using Git.

The following commands were used:

```bash
git checkout feature/rename-field-b
git merge main
```

Git reported a conflict in:

```text
src/main/java/com/sqe/Book.java
```

The conflict markers were manually edited and the `bookTitle` version was kept.

The file was then staged and committed:

```bash
git add src/main/java/com/sqe/Book.java
git commit -m "fix(book): resolve title field merge conflict"
git push origin feature/rename-field-b
```

The conflict-resolution commit was:

```text
db755ef fix(book): resolve title field merge conflict
```

### Result

The conflict was successfully resolved locally and the updated branch was
pushed to GitHub. The pull request then showed that there were no conflicts
with the base branch.
