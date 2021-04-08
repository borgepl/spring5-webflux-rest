package guru.springframework.spring5webfluxrest.bootstrap;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import guru.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadVendors();
    }

    private void loadVendors() {
    }

    private void loadCategories() {

        Category category1 = new Category();
        category1.setDescription("Cat 1");

        Category category2 = new Category();
        category2.setDescription("Cat 2");

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        System.out.println("Categories Loaded: " + categoryRepository.count());
    }
}
