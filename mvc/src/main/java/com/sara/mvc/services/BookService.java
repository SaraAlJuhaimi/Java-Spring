package com.sara.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sara.mvc.models.Book;
import com.sara.mvc.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, int pages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
        	optionalBook.get().setTitle(title);
        	optionalBook.get().setDescription(desc);
        	optionalBook.get().setLanguage(lang);
        	optionalBook.get().setNumberOfPages(pages);
        	return bookRepository.save(optionalBook.get());
        } else {
            return null;
        }
    }
    
    public void deleteBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
        	bookRepository.deleteById(id);
        }
    }
    
    
}
