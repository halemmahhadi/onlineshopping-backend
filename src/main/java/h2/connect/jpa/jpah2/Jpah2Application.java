package h2.connect.jpa.jpah2;

import h2.connect.jpa.jpah2.model.Products;
import h2.connect.jpa.jpah2.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Jpah2Application {

    public static void main(String[] args) {
        SpringApplication.run(Jpah2Application.class, args);


    }
    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository){
        return (args) -> {
            productRepository.save(new Products("Roomo Basic Wood Board", "https://i.postimg.cc/2yvrckQQ/IMG-20210203-WA0004.jpg", 59, "Kleines Trainingsboard im assymetrischen Design.", 20));
            productRepository.save(new Products("Campus Rungs - 6 Pack", "https://i.postimg.cc/Wb3fZb2H/IMG-20210203-WA0005.jpg", 59, "6er Set Campusleisten aus Holz von Metolius.", 20));
            productRepository.save(new Products("Rusher Send Portable Fingerboard", "https://i.postimg.cc/BnhFK4nM/IMG-20210202-WA0055.jpg", 55, "Ideales Aufwärmbrett für dein Projekt.", 20));
            productRepository.save(new Products("Auntworks Strong Aunt 3", "https://i.postimg.cc/sDj19q88/IMG-20210202-WA0054.jpg", 135, "Premiumboard aus hautschonendem Eschenholz.", 20));
        };
    }


}