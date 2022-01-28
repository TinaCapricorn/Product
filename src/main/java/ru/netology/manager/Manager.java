package ru.netology.manager;

import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.Repository;
import ru.netology.product.Book;
import ru.netology.exception.NotFoundException;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public Product[] searchBy(String text) {
        Product[] searchedProduct = new Product[0];
        for (Product product: repository.getProducts()) {
            if (matches(product, text)) {
                Product[] copy = new Product[searchedProduct.length + 1];
                System.arraycopy(searchedProduct, 0, copy, 0, searchedProduct.length );
                copy[copy.length - 1] = product;
                searchedProduct = copy;
            }
        }
        return searchedProduct;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getManufacruter().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void saveProduct(Product product){
        repository.add(product);
    }

    public Product[] getProducts(){
        return repository.getProducts();
    }

    public void removeId(int findedId){
        try {
            repository.deleteById(findedId);
        }
        catch (NotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

}
