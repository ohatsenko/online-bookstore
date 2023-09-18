package com.example.onlinebookstore.dto;

import com.example.onlinebookstore.model.Category;
import com.example.onlinebookstore.validation.CoverImage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateBookRequestDto {
    @NotNull
    @NotBlank
    @Length(min = 5, max = 255)
    private String title;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 50)
    private String author;
    @NotNull
    private String isbn;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @Length(min = 5, max = 255)
    private String description;
    @CoverImage
    private String coverImage;
    private Set<Long> categoryIds;
}
