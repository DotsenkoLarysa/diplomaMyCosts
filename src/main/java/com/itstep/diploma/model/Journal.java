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
    private Category categorySet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "transactionId")
    private Transaction transactionSet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "periodId")
    private Period periodSet;

    public Journal() {
    }

    public Journal(Long event_id, Date event_date, @NotBlank(message = "Sum is mandatory") Double event_sum, String description, Category categorySet,
                   Transaction transactionSet, Period periodSet) {
        this.event_id = event_id;
        this.event_date = event_date;
        this.event_sum = event_sum;
        this.description = description;
        this.categorySet = categorySet;
        this.transactionSet = transactionSet;
        this.periodSet = periodSet;
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

    public Category getCategorySet() { return categorySet; }

    public void setCategorySet(Category categories) { this.categorySet = categorySet; }

    public Transaction getTransactionSet() { return transactionSet; }

    public void setTransactionSet(Transaction transactions) { this.transactionSet = transactionSet; }

    public Period getPeriodSet() { return periodSet; }

    public void setPeriodSet(Period periods) { this.periodSet = periodSet; }

    @Override
    public String toString() {
        return "Journal{" +
                "event_id=" + event_id +
                ", event_date=" + event_date +
                ", event_sum=" + event_sum +
                ", description='" + description + '\'' +
                ", categorySet=" + categorySet +
                ", transactionSet=" + transactionSet +
                ", periodSet=" + periodSet +
                '}';
    }
}
