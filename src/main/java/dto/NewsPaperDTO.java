package dto;

import java.sql.Date;

public class NewsPaperDTO {
    private int id;
    private String name;
    private Date date;
    private int amount;

    public NewsPaperDTO() {}

    public NewsPaperDTO(int id, String name, Date date, int amount) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
