package com.example.Assignment_Food.entity;

import com.example.Assignment_Food.annocation.Column;
import com.example.Assignment_Food.annocation.ForeignKey;
import com.example.Assignment_Food.annocation.Id;
import com.example.Assignment_Food.annocation.Table;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Objects;

@Table(name = "foods")
public class Food {

    @Id(AutoIncrement = true)
    @Column(name = "id", type = "INT")
    private int id;

    @Column(name = "name", type = "VARCHAR(250)")
    private String name;

    @ForeignKey(referenceColumn = "id", referenceTable = "categories")
    @Column(name = "categoryId", type = "INT")
    private int categoryId;

    @Column(name = "description", type = "TEXT(250)")
    private String description;

    @Column(name = "thumbnail", type = "TEXT")
    private String thumbnail;

    @Column(name = "price", type = "DOUBLE")
    private double price;

    @Column(name = "createdAt", type = "TIMESTAMP NOT NULL DEFAULT CURRENT_DATE()")
    private Timestamp createdAt;

    @Column(name = "updatedAt", type = "TIMESTAMP NOT NULL DEFAULT CURRENT_DATE()")
    private Timestamp updatedAt;

    @Column(name = "status", type = "INT DEFAULT 1")
    private int status;


    public Food() {
        this.status = 1;
    }

    private HashMap<String, String> error;

    public void checkValid() {
        this.error = new HashMap<>();
        if (this.name == null || this.name.length() <= 7) {
            this.error.put("name", "Name is required!");
        }
        if (this.categoryId <= 0) {
            this.error.put("categoryId", "CategoryId is required!");
        }
        if (this.description == null || this.description.length() == 0) {
            this.error.put("description", "Description is required!");
        }
        if (this.price <= 0) {
            this.error.put("price", "Price is required!");
        }
    }

    public HashMap<String, String> getErrors() {
        checkValid();
        return error;
    }

    public boolean isValid() {
        checkValid();
        return error == null || error.size() == 0;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public Food(int id, String name, Integer categoryId, String description, String thumbnail, double price, Timestamp createdAt, Timestamp updatedAt, int status) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Food(String name, int categoryId, String description, String thumbnail, double price, int status) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
    }

    public Food(String name, int categoryId, String description, String thumbnail, double price) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}