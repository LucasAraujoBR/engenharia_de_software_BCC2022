package com.sotckSystem.Stock.model.DTO;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class StockDTO {

    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Double variation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull
    private String dono;

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
