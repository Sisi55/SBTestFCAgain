package com.example.testFCagain.repository;

import com.example.testFCagain.TestFCagainApplicationTests;
import com.example.testFCagain.model.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends TestFCagainApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = new Category();
        category.setTitle("cate sisi");
        category.setType("type sisi");
        category.setCreatedAt(LocalDateTime.now());
        category.setCreatedBy("by sisi");

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getTitle(), category.getTitle());
        Assert.assertEquals(newCategory.getType(), category.getType());
        Assert.assertEquals(newCategory.getCreatedAt(), category.getCreatedAt());
        Assert.assertEquals(newCategory.getCreatedBy(), category.getCreatedBy());

        Assert.assertEquals(newCategory, category);
//        Assert.assertEquals(newCategory.get(), category);
        // 근데 모르겠당 객체 비교하면 주소 비교하는건지,
        // 내용물까지 해주는건지
    }

    @Test
    public void read(){
        Optional<Category> optionalCategory = categoryRepository.findById(1L);

        optionalCategory.ifPresent(c->{
            System.out.println(c.getId());
            System.out.println(c.getTitle());
            System.out.println(c.getType());
        });
    }

}
