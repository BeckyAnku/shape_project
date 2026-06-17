public class Loan {

    private Book book;
    private Member member;
    private String borrowDate;
    private String dueDate;

    public Loan(Book book, Member member, String borrowDate, String dueDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Loan: " + book.getTitle() + " borrowed by " + member.getName()
                + ", from " + borrowDate + " to " + dueDate;
    }
}
