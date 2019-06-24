package com.akhambir.controller;

import com.akhambir.dao.CategoryRepository;
import com.akhambir.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private CategoryRepository categoryRepository;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<GreetingResponse> greet() {
        return ResponseEntity.ok(new GreetingResponse("Hello from Spring Boot!"));
    }

    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryRepository.findAll());
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
