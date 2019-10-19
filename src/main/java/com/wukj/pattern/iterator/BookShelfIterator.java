package com.wukj.pattern.iterator;

public class BookShelfIterator implements Iterator {

	private BookShelf bookShelf;
	private int index;

	public BookShelfIterator(BookShelf shelf) {
		this.bookShelf = shelf;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if (index < bookShelf.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

}
