package ru.netology.Repository;

import ru.netology.Product.Product;


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

    public void deleteById(int findedId){
        for (Product product : products){
            if (findedId == product.getId()){
                findedId = product.getId();
            }
        }
        Product[] copy = new Product[products.length - 1];
        int index = 0;
        for (int i = 0; i < products.length; i++){
            if (products[i].getId() != findedId){
                copy[index] = products[i];
                index++;
            }
        }
        this.products = copy;
    }
}
