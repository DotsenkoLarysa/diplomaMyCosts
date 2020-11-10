package com.itstep.diploma.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "category",schema="mycosts")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int category_id;

    @NotBlank(message = "Specify the category name")
    @Column(name = "name_category")
    private String name_category;

    @NotBlank(message = "Indicate the percentage")
    @Column(name = "parcentage_value")
    private int percentage;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event_id")
    private Set<Journal> journalSet;

    public Category() {
    }

    public Category(int category_id, @NotBlank(message = "Specify the category name") String name_category,
                    @NotBlank(message = "Indicate the percentage") int percentage, Set<Journal> journalSet) {
        this.category_id = category_id;
        this.name_category = name_category;
        this.percentage = percentage;
        this.journalSet = journalSet;
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

    public void setJournal(Set<Journal> journal) {
        this.journalSet = journalSet;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name_category='" + name_category + '\'' +
                ", percentage=" + percentage +
                ", journalSet=" + journalSet +
                '}';
    }
}
