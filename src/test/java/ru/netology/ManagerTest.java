package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Product[] products = {
            new Book(1, "Книга1", 1500, "Автор1"),
            new Smartphone(2, "Смартфон1", 28000, "Производитель1"),
            new Book(3, "Книга2", 870, "Автор2"),
            new Smartphone(4, "Смартфон2", 32000, "Производитель2"),
            new Book(5, "Книга3", 3600, "Автор3"),
            new Smartphone(6, "Смартфон3", 44000, "Производитель3"),
            new Book(7, "Книга4", 500, "Автор4"),
            new Smartphone(8, "Смартфон4", 19000, "Производитель4"),
            new Book(9, "Книга5", 1100, "Автор5"),
            new Smartphone(10, "Смартфон5", 20500, "Производитель5"),
            new Book(11, "Книга6", 1648, "Автор6"),
            new Smartphone(12, "Смартфон6", 86000, "Производитель6"),
            new Book(13, "Книга7", 2300, "Автор7"),
            new Smartphone(14, "Смартфон7", 37490, "Производитель7"),
            new Product(15, "Продукт", 0)
    };

    Repository repository = new Repository(products);
    Manager manager = new Manager(repository);

    @Test
    void searchByBookName() {
        Product[] expected = {
                new Book(5, "Книга3", 3600, "Автор3"),
        };
        Product[] actual = manager.searchBy("Книга3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneName() {
        Product[] expected = {
                new Smartphone(10, "Смартфон5", 20500, "Производитель5"),
        };
        Product[] actual = manager.searchBy("Смартфон5");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByProductAuthor() {
        Product[] expected = {
                new Book(7, "Книга4", 500, "Автор4")
        };
        Product[] actual = manager.searchBy("Автор4");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByProductManufacturer() {
        Product[] expected = {
                new Smartphone(14, "Смартфон7", 37490, "Производитель7")
        };
        Product[] actual = manager.searchBy("Производитель7");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchDontHaveProduct() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void saveProduct() {
        manager.saveProduct(new Book(16, "Тестовая книга", 987, "Тестовый автор"));
        int expected = 16;
        int actual = manager.getProducts().length;
        assertEquals(expected, actual);
    }
}