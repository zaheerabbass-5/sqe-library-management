package com.sqe;

public class Member {

    private String name;
    private String memberId;

   public Member(String name, String memberId) {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Member name cannot be empty");
    }

    if (memberId == null || memberId.trim().isEmpty()) {
        throw new IllegalArgumentException("Member ID cannot be empty");
    }

    this.name = name;
    this.memberId = memberId;
}

    private String id;

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

   public String getMemberId() {
    return memberId;
}
    public String getId() {
        return id;
    }

    public void borrowBook(String bookTitle) {
        System.out.println(name + " borrowed " + bookTitle);
    }
}
