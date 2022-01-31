package ru.netology.repository;

import ru.netology.product.Product;
import ru.netology.exception.NotFoundException;


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
        int foundedId = 0;
        for (Product product : products){
            if (findedId == product.getId()){
                foundedId = product.getId();
            }
        }
        if (foundedId == 0){
            throw new NotFoundException("Element with id: " + findedId + " not found");
        }
        Product[] copy = new Product[products.length - 1];
        int index = 0;
        for (int i = 0; i < products.length; i++){
            if (products[i].getId() != foundedId){
                copy[index] = products[i];
                index++;
            }
        }
        this.products = copy;
    }
}
