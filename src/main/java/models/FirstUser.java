package models;

public class FirstUser {
    private int expense;
    private int count;
    private int paidto;

    public FirstUser() {
    }

    public FirstUser( int expense, int count, int paidto) {

        this.expense = expense;
        this.count = count;
        this.paidto = paidto;
    }

    public int getPaidto() {
        return paidto;
    }

    public void setPaidto(int paidto) {
        this.paidto = paidto;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FirstUser{" +
                ", expense=" + expense +
                ", count=" + count +
                ", paidto=" + paidto +
                '}';
    }
}
