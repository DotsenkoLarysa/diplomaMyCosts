package com.itstep.diploma.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "category", schema = "mycosts")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int category_id;

    @Column(name = "name_category")
    private String name_category;

    @Column(name = "percentage_value")
    private int percentage;

    @OneToMany(mappedBy = "category")
    private Set<Journal> journalSet;

    public Category() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Set<Journal> getJournal() {
        return journalSet;
    }

    public void setJournal(Set<Journal> journalSet) {
        this.journalSet = journalSet;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name_category='" + name_category + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
