package com.itstep.diploma.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "journal", schema = "mycosts")
public class Journal {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long event_id;

    @Column(name = "event_date", nullable = false)
    private Date event_date;

    @NotBlank(message = "Sum is mandatory")
    @Column(name = "event_sum", nullable = false)
    private Double event_sum;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "transactionId")
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "periodId")
    private Period period;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "userId")
    private User user;

    public Journal() {
    }

    public Journal(Long event_id, Date event_date, @NotBlank(message = "Sum is mandatory") Double event_sum,
                   String description, Category category, Transaction transaction, Period period,
                   User user) {
        this.event_id = event_id;
        this.event_date = event_date;
        this.event_sum = event_sum;
        this.description = description;
        this.category = category;
        this.transaction = transaction;
        this.period = period;
        this.user = user;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public Double getEvent_sum() {
        return event_sum;
    }

    public void setEvent_sum(Double event_sum) {
        this.event_sum = event_sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public Transaction getTransaction() { return transaction; }

    public void setTransaction(Transaction transaction) { this.transaction = transaction; }

    public Period getPeriod() { return period; }

    public void setPeriod(Period period) { this.period = period; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Journal{" +
                "event_id=" + event_id +
                ", event_date=" + event_date +
                ", event_sum=" + event_sum +
                ", description='" + description + '\'' +
                ", categorySet=" + category +
                ", transactionSet=" + transaction +
                ", periodSet=" + period +
                ", user=" + user +
                '}';
    }
}
