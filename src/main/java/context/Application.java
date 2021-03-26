package context;

import controllers.ItemController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import repository.ItemRepository;
import services.ItemService;
import services.ItemServiceImpl;

import java.sql.SQLException;


@Configuration
@ComponentScan(basePackages = {"controllers", "services", "repository"})
public class Application {

//    @Bean
//    public ItemController itemController() throws SQLException {
//        return new ItemController(itemService());
//    }

//    @Bean
//    public ItemService itemService() throws SQLException {
//        return new ItemServiceImpl(itemRepository());
//    }

//    @Bean
//    protected ItemRepository itemRepository() throws SQLException {
//        return new ItemRepository();
//    }

}