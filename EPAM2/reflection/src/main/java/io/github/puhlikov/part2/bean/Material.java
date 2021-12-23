package com.epam.training.part2.bean;

import com.epam.training.part2.annotations.Equal;
import com.epam.training.part2.enums.Compare;

import java.util.Objects;

public class Material {

    @Equal(compareBy = Compare.REFERENCE)
    private String name;

    @Equal(compareBy = Compare.REFERENCE)
    private String viewMaterial;

    @Equal(compareBy = Compare.VALUE)
    private int quantity;


    public Material(String name, String viewMaterial, int  quantity){
        this.name = name;
        this.viewMaterial = viewMaterial;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewMaterial() {
        return viewMaterial;
    }

    public void setViewMaterial(String viewMaterial) {
        this.viewMaterial = viewMaterial;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return quantity == material.quantity &&
                Objects.equals(name, material.name) &&
                Objects.equals(viewMaterial, material.viewMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, viewMaterial, quantity);
    }
}