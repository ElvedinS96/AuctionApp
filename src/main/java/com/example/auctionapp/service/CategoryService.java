package com.example.auctionapp.service;

import com.example.auctionapp.Util.RepositoryUtility;
import com.example.auctionapp.dto.CategoryDto;
import com.example.auctionapp.model.Category;
import com.example.auctionapp.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService implements IBaseService<CategoryDto> {

    private static final String RESOURCE_NAME = "Category";

    BaseRepository<Category> repository;

    private static Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    public CategoryService(BaseRepository<Category> repository) {
        this.repository = repository;
        this.repository.setResourceClass(Category.class);
    }

    public List<CategoryDto> getAll() {

        List<Category> categories = repository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category:categories) {
            categoryDtos.add(new CategoryDto(
                                        category.getId(),
                                        category.getDateCreated(),
                                        category.getLastModifiedDate(),
                                        category.getName())
            );
        }

        return  categoryDtos;
    }


    public CategoryDto getById(Long id) {

        Category category = RepositoryUtility.findIfExist(repository, id, RESOURCE_NAME);

        return new CategoryDto(
                            category.getId(),
                            category.getDateCreated(),
                            category.getLastModifiedDate(),
                            category.getName()
        );
    }


    public CategoryDto add(CategoryDto resource) {
        Category category = repository.create(new Category(resource.getName()));
        logger.info("Category with id " + category.getId() + " created");
        return new CategoryDto(
                            category.getId(),
                            category.getDateCreated(),
                            category.getLastModifiedDate(),
                            category.getName()
        );
    }


    public CategoryDto update(CategoryDto resource) {

        Category resourceToUpdate = RepositoryUtility.findIfExist(repository, resource.getId(), RESOURCE_NAME);

        resourceToUpdate.setName(resource.getName());

        Category category = repository.update(resourceToUpdate);
        logger.info("Category with id " + category.getId() + " updated");

        return new CategoryDto(
                            category.getId(),
                            category.getDateCreated(),
                            category.getLastModifiedDate(),
                            category.getName()
        );
    }


    public void deleteById(Long id) {

        RepositoryUtility.findIfExist(repository, id, RESOURCE_NAME);

        repository.deleteById(id);
        logger.info("Category with id " + id + " deleted");
    }
}