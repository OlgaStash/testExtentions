package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private static Book first = new Book(1, "Лори", 1500, "Стивен Кинг", 400, 2002);
    private static Book second = new Book(2, "Сила подсозная", 700, "Джо Диспенз", 450, 2020);
    private static Book third = new Book(3, "Алгоритмы", 150, "Никлаус Вирт", 300, 2001);
    private static TShirt fourth = new TShirt(4, "Gucci", 5000, "White", "M");
    private static TShirt five = new TShirt(5, "Nike", 1000, "Black", "M");
    private static TShirt six = new TShirt(6, "Sela", 500, "Grey", "M");

    static ProductRepository repository = new ProductRepository();

    @BeforeAll
    public static void setAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(five);
        System.out.println(repository);
    }


    @Test
    public void shouldChekDeleteExistElement() {
        repository.removeById(3);
        Product actual = repository.findById(3);
        Product expected = null;

        assertEquals(actual,expected);
    }

    @Test
    public void shouldChekDeleteNotExistElement() {
        assertThrows(NotFoundException.class, () ->{
            repository.removeById(10);
        });
    }
}