package guru.springframework.spring5webfluxrest.controllers;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class CategoryControllerTest {

    public static final String API_CATEGORIES = "/api/categories";
    public static final String ID = "some";
    public static final String CAT_1 = "Cat1";
    public static final String CAT_2 = "Cat2";

    WebTestClient webTestClient;
    CategoryRepository categoryRepository;
    CategoryController categoryController;

    @BeforeEach
    void setUp() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryController = new CategoryController(categoryRepository);
        webTestClient = WebTestClient.bindToController(categoryController).build();
    }

    @Test
    void getAllCategories() {
        BDDMockito.given(categoryRepository.findAll())
                .willReturn(Flux.just(Category.builder().description(CAT_1).build(),
                        Category.builder().description(CAT_2).build()));
        webTestClient.get().uri(getUri())
                .exchange()
                .expectBodyList(Category.class)
                .hasSize(2);

    }

    private String getUri() {

            return API_CATEGORIES;

    }

    @Test
    void getCategory() {
        BDDMockito.given(categoryRepository.findById(ID))
                .willReturn(Mono.just(Category.builder().description(CAT_1).build()));
        webTestClient.get().uri(getUri() +"/" + ID)
                .exchange()
                .expectBody(Category.class);

    }
}