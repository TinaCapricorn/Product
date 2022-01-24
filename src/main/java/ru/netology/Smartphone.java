package ru.netology;

public class Smartphone extends Product{
    private String manufacruter;

    public Smartphone(int id, String name, int price, String manufacruter) {
        super(id, name, price);
        this.manufacruter = manufacruter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return manufacruter.equals(that.manufacruter);
    }

    public String getManufacruter() {
        return manufacruter;
    }
}
