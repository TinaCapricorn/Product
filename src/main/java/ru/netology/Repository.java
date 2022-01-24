package ru.netology;

public class Repository {

    private Product[] products;

    public Repository(Product[] products) {
        this.products = products;
    }

    public void add(Product product){
        int length = this.products.length + 1;
        Product[] copy = new Product[length];
        System.arraycopy(products, 0, copy, 0, products.length);
        int lastIndex = copy.length - 1;
        copy[lastIndex] = product;
        products = copy;
    }

    public Product[] getProducts() {
        return products;
    }
}
