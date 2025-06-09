package com.ccsw.tutorial.categories;

import com.ccsw.tutorial.categories.model.Category;
import com.ccsw.tutorial.categories.model.CategoryDto;
import com.ccsw.tutorial.categories.repository.CategoryRepository;
import com.ccsw.tutorial.categories.service.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void findAllShouldReturnAllCategories() {

        List<Category> list = new ArrayList<>();
        list.add(mock(Category.class));

        when(categoryRepository.findAll()).thenReturn(list);

        List<Category> clientes = categoryService.findAll();

        assertNotNull(clientes);
        assertEquals(1, clientes.size());
    }

    public static final String CATEGORY_NAME = "CAT";

    @Test
    public void saveNotExistsCategoriesIdShouldInsert() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(CATEGORY_NAME);

        ArgumentCaptor<Category> clients = ArgumentCaptor.forClass(Category.class);

        categoryService.save(null, categoryDto);

        verify(categoryRepository).save(clients.capture());

        assertEquals(CATEGORY_NAME, clients.getValue().getName());

    }

    public static final Long EXISTS_CATEGORY_ID = 1L;

    @Test
    public void saveExistsCategoryIdShouldUpdate() {
        CategoryDto clientsDto = new CategoryDto();
        clientsDto.setName(CATEGORY_NAME);

        Category category = mock(Category.class);
        when(categoryRepository.findById(EXISTS_CATEGORY_ID)).thenReturn(Optional.of(category));

        categoryService.save(EXISTS_CATEGORY_ID, clientsDto);

        verify(categoryRepository).save(category);
    }

    @Test
    public void deleteExitsCategoryIdShouldDelete() throws Exception {
        Category clients = mock(Category.class);
        when(categoryRepository.findById(EXISTS_CATEGORY_ID)).thenReturn(Optional.of(clients));

        categoryService.delete(EXISTS_CATEGORY_ID);
        verify(categoryRepository).deleteById(EXISTS_CATEGORY_ID);
    }

    public static final Long NOT_EXISTS_CATEGORY_ID = 0L;

    @Test
    public void getExistsCategoryIdShouldReturnCategory() {

        Category category = mock(Category.class);
        when(category.getId()).thenReturn(EXISTS_CATEGORY_ID);
        when(categoryRepository.findById(EXISTS_CATEGORY_ID)).thenReturn(Optional.of(category));

        Category categoryResponse = categoryService.get(EXISTS_CATEGORY_ID);

        assertNotNull(categoryResponse);
        assertEquals(EXISTS_CATEGORY_ID, category.getId());
    }

    @Test
    public void getNotExistsCategoryIdShouldReturnNull() {

        when(categoryRepository.findById(NOT_EXISTS_CATEGORY_ID)).thenReturn(Optional.empty());

        Category category = categoryService.get(NOT_EXISTS_CATEGORY_ID);

        assertNull(category);
    }
}