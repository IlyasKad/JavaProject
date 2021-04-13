package com.travelset;
import com.travelset.controllers.OrderlineController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.travelset.model.repository")
@EntityScan("com.travelset.model.entity")
@ComponentScan(basePackages = {"com.travelset.services", "com.travelset.controllers"})
public class Runner implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

//	@Autowired
//	private ItemRepository itemRepository;
//
//	@Autowired
//	private RoleRepository roleRepository;
//
//	@Autowired
//	private OrderlineService orderlineService;

	@Autowired
	private OrderlineController orderlineController;

	public static void main(String[] args){
		SpringApplication.run(Runner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(applicationContext.getDisplayName());
//		System.out.println(applicationContext.getId());
//
//		Item item = itemRepository.findById(1).get();
//		System.out.println(item.getItemtype().getName());

//		orderlineService.createOrUpdateOrderline(1,1,3);

		orderlineController.createOrUpdateOrderline(1,1,5);
	}
}


