package com.itstep.diploma.dto;

import com.itstep.diploma.model.Journal;


import java.util.Date;

public class JournalsCreationDTO {

    private Date event_date;
    private Double event_sum;
    private String description;
    private Long user_id;
    private int category_id;
    private int transaction_id;

    public JournalsCreationDTO() {
    }

    public JournalsCreationDTO(Date event_date, Double event_sum, String description, Long user_id,
                               int category_id, int transaction_id) {
        this.event_date = event_date;
        this.event_sum = event_sum;
        this.description = description;
        this.user_id = user_id;
        this.category_id = category_id;
        this.transaction_id = transaction_id;
    }

    public JournalsCreationDTO(Journal journal) {
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


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
}
