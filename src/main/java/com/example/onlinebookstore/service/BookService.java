package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.BookDto;
import com.example.onlinebookstore.dto.BookDtoWithoutCategoryIds;
import com.example.onlinebookstore.dto.CreateBookRequestDto;
import com.example.onlinebookstore.model.Book;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDtoWithoutCategoryIds> findAll(Pageable pageable);

    BookDto findById(Long id);

    Book findBookById(Long id);

    BookDto update(Long id, CreateBookRequestDto book);

    void deleteById(Long id);
}
