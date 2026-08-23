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

## Task 4 — Commit Hygiene Audit

### Last 10 Commits

The following output was obtained using:
git log --oneline -10
57432a9 (HEAD -> main, origin/main, origin/HEAD) docs(workflow): document merge conflict resolution
57e7b38 docs(workflow): document merge conflict resolution
db755ef (origin/feature/rename-field-b, feature/rename-field-b) fix(book): resolve title field merge conflict
f6e029e Merge pull request #6 from zaheerabbass-5/feature/rename-field-a
791e8eb refactor(book): rename title to bookName
9d94bf6 (origin/feature/rename-field-a) refactor(book): rename title to bookTitle
de85663 Merge pull request #5 from zaheerabbass-5/feature/add-member-management
d99d2f5 (origin/feature/add-member-management) Merge branch 'main' into feature/add-member-management
67c7843 fix(member): improve member validation and naming
ec9c118 feat(member): add Member class
### Weak Commit Messages and Suggested Rewrites

#### 1. Original

`Merge branch 'main' into feature/add-member-management`

Suggested rewrite:

`chore(member): sync feature branch with main`

Why it is better: The original message describes the Git operation rather than its purpose. The rewritten message follows the Conventional Commits format and clearly describes the purpose.

#### 2. Original

`Merge pull request #5 from zaheerabbass-5/feature/add-member-management`

Suggested rewrite:

`feat(member): merge member management implementation`

Why it is better: The original message is automatically generated and does not clearly describe the functionality being integrated. The rewritten message uses the Conventional Commits format and explains the purpose.

### Note

These are suggested improvements only. The existing Git history was not rewritten and no force-push was performed.
