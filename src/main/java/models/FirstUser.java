package models;

public class FirstUser {
    private int id;
    private String name;
    private long phonenumber;
    private String email;
    private int expense;
    private int count;
    private int userid;
    private int paidto;

    public FirstUser() {
    }

    public FirstUser(int id, String name, long phonenumber, String email, int expense, int count, int userid, int paidto) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.expense = expense;
        this.count = count;
        this.userid = userid;
        this.paidto = paidto;
    }

    public int getPaidto() {
        return paidto;
    }

    public void setPaidto(int paidto) {
        this.paidto = paidto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "FirstUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", email='" + email + '\'' +
                ", expense=" + expense +
                ", count=" + count +
                ", userid=" + userid +
                ", paidto=" + paidto +
                '}';
    }
}
