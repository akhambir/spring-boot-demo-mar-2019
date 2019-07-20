package com.akhambir.service.scheduler;

import com.akhambir.dao.CategoryRepository;
import com.akhambir.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultScheduler {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RestTemplate restTemplate;

    private List<String> urls = Arrays.asList("http://google.com.ua");

    // DANGER!!! never do this. Stateful class is not thread safe!!!
    private int counter = 1;

    //@Scheduled(initialDelay = 5000, fixedDelay = 7000)  //(cron = "0 0 12 1/1 * ? *")
    public void pollAndPrintAllCategories() {
        System.out.println("#####################");
        categoryRepository.findAll().stream()
                .peek(System.out::println)
                .collect(Collectors.toSet());
        /*urls.stream()
                .map(u -> restTemplate.exchange(URI.create(u), HttpMethod.GET, null, String.class))
                .peek(System.out::println)
                .collect(Collectors.toSet());*/
    }

    //@Scheduled(initialDelay = 7000, fixedDelay = 7000)
    public void addNewCategory() {
        categoryRepository.save(new Category(null, "test_" + counter, "test_" + counter));
    }
}
