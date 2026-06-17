import java.util.ArrayList;

public class Member {

    private String memberId;
    private String name;
    private ArrayList<Loan> currentLoans;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.currentLoans = new ArrayList<Loan>();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Loan> getCurrentLoans() {
        return currentLoans;
    }

    public void setCurrentLoans(ArrayList<Loan> currentLoans) {
        this.currentLoans = currentLoans;
    }

    public void addLoan(Loan loan) {
        currentLoans.add(loan);
    }

    public void removeLoan(Loan loan) {
        currentLoans.remove(loan);
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name
                + ", Number of loans: " + currentLoans.size();
    }
}
