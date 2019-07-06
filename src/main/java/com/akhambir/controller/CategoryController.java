package com.akhambir.controller;

import com.akhambir.dao.CategoryRepository;
import com.akhambir.model.Category;
import com.akhambir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return categoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }


    class GreetingResponse {
        private String message;

        public GreetingResponse() {
        }

        public GreetingResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
