package com.wukj.pattern.iterator;

import org.junit.Test;

public class IteratorTest {

    @Test
    public void testIterator() {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("A"));
        bookShelf.appendBook(new Book("B"));
        bookShelf.appendBook(new Book("C"));
        bookShelf.appendBook(new Book("D"));

        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getBookName());
        }
    }
}
