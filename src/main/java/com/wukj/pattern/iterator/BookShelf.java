package com.wukj.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {

	private List<Book> books;
	private int last;

	public BookShelf() {
		books = new ArrayList<>();
	}

	Book getBookAt(int index) {
		return books.get(index);
	}

	void appendBook(Book book) {
		this.books.add(book);
		last++;
	}

	int getLength() {
		return last;
	}

	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}

}
