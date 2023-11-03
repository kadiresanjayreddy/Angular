package com.example.angular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular.Book;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/books")
public class BookController {
	    
	@Autowired
   private BookRepository bookRepository;


@PostMapping("book")
public Book addBook(@RequestBody Book book) {
    return bookRepository.save(book);
}

@GetMapping
public List<Book> getAllbook() {
    return (List<Book>) bookRepository.findAll();
}

@GetMapping("/{name}")
public ResponseEntity<Object> getBookByName(@PathVariable String title) {
    Optional<Book> book = bookRepository.findByTitle(title);
    if (Book.isPresent()) {
        return ResponseEntity.ok(Book.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}

@PutMapping("/{id}")
public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
    Optional<Book> existingBook = bookRepository.findById(id);

    if (existingBook.isPresent()) {
        Book BookToUpdate = existingBook.get();
        // Update the product properties here
        BookToUpdate.setTitle(updatedBook.getTitle());
        BookToUpdate.setPages(updatedBook.getPages());
        // ... other properties you want to update

        bookRepository.save(BookToUpdate);
        return ResponseEntity.ok("Product updated successfully.");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with ID: " + id);
    }
}
}
