import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookList;
    private ArrayList<Member> memberList;
    private ArrayList<Loan> loanList;

    public Library() {
        bookList = new ArrayList<Book>();
        memberList = new ArrayList<Member>();
        loanList = new ArrayList<Loan>();
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public ArrayList<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(ArrayList<Loan> loanList) {
        this.loanList = loanList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void registerMember(Member member) {
        memberList.add(member);
    }

    public void lendBook(String isbn, String memberId, String borrowDate, String dueDate) {
        Book wantedBook = getBookByIsbn(isbn);
        Member wantedMember = getMemberById(memberId);

        if (wantedBook == null) {
            System.out.println("The book cannot be found.");
        } else if (wantedMember == null) {
            System.out.println("The member cannot be found.");
        } else if (wantedBook.isAvailable() == false) {
            System.out.println("Rejected: this book is already borrowed.");
        } else {
            Loan newLoan = new Loan(wantedBook, wantedMember, borrowDate, dueDate);
            loanList.add(newLoan);
            wantedMember.addLoan(newLoan);
            wantedBook.setAvailable(false);
            System.out.println("Lending done for " + wantedBook.getTitle());
        }
    }

    public void returnBook(String isbn) {
        Loan foundLoan = null;

        for (int i = 0; i < loanList.size(); i++) {
            if (loanList.get(i).getBook().getIsbn().equals(isbn)) {
                foundLoan = loanList.get(i);
            }
        }

        if (foundLoan == null) {
            System.out.println("This book does not have an active loan.");
        } else {
            foundLoan.getBook().setAvailable(true);
            foundLoan.getMember().removeLoan(foundLoan);
            loanList.remove(foundLoan);
            System.out.println("Returned: " + foundLoan.getBook().getTitle());
        }
    }

    public Book searchBookByTitle(String title) {
        Book foundBook = null;

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equalsIgnoreCase(title)) {
                foundBook = bookList.get(i);
            }
        }

        return foundBook;
    }

    private Book getBookByIsbn(String isbn) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getIsbn().equals(isbn)) {
                return bookList.get(i);
            }
        }

        return null;
    }

    private Member getMemberById(String memberId) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberId().equals(memberId)) {
                return memberList.get(i);
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String output = "";

        output = output + "Books in library:\n";
        for (int i = 0; i < bookList.size(); i++) {
            output = output + bookList.get(i) + "\n";
        }

        output = output + "Members:\n";
        for (int i = 0; i < memberList.size(); i++) {
            output = output + memberList.get(i) + "\n";
        }

        output = output + "Current loans:\n";
        for (int i = 0; i < loanList.size(); i++) {
            output = output + loanList.get(i) + "\n";
        }

        return output;
    }
}
