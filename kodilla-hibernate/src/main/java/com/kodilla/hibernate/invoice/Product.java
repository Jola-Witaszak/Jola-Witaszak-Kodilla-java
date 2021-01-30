package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    private int id;
    private String Name;
    private List<Item> items = new ArrayList<>();

    public Product(String name) {
        Name = name;
    }

    public Product() {
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    @NotNull
    @Column(name = "PRODUCT_NAME")
    public String getName() {
        return Name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        Name = name;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }
}
