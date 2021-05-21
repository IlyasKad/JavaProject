package com.travelset.laba3;

import java.sql.Timestamp;
import java.util.List;
//import com.travelset.laba3.controllers.OrderItemController;
import com.travelset.laba3.controllers.OrderItemController;
import com.travelset.laba3.model.entity.*;
import com.travelset.laba3.model.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.travelset.laba3.model.repository")
@EntityScan("com.travelset.laba3.model.entity")
@ComponentScan(basePackages = {"com.travelset.laba3.services", "com.travelset.laba3.controllers"})
public class Laba3Application implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;



	// =========================== START SEED ======================================================
	@Autowired
	private BackpackRepository backpackRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemtypeRepository itemtypeRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private UserRepository userRepository;

	// =========================== END SEED ======================================================

	@Autowired
	private OrderItemController orderItemController;

	public static void main(String[] args){
		SpringApplication.run(Laba3Application.class, args);
	}

	private void seed(){
		Category foodCategory = new Category();
		foodCategory.setName("Food");
		categoryRepository.save(foodCategory);

		Itemtype milkItemType = new Itemtype();
		milkItemType.setName("Milk");
		milkItemType.setCategory(foodCategory);
		itemtypeRepository.save(milkItemType);

		Item cowMilkItem = new Item();
		cowMilkItem.setItemtype(milkItemType);
		cowMilkItem.setCalories(100);
		cowMilkItem.setDescription("cow milk 2 Liter");
		cowMilkItem.setQuantity(1000);
		cowMilkItem.setWeight(500);
		itemRepository.save(cowMilkItem);

		Permission canCreateOrderPermission = new Permission();
		canCreateOrderPermission.setName("canCreateOrder");
		canCreateOrderPermission.setDescription("can Create Order ");
		permissionRepository.save(canCreateOrderPermission);

		Role userRole = new Role();
		userRole.setName("User");
		roleRepository.save(userRole);

		canCreateOrderPermission.getRoles().add(userRole);
		permissionRepository.save(canCreateOrderPermission);

		User user1 = new User();
		user1.setLogin("Alex");
		user1.setPassword("123");
		user1.setRole(userRole);
		userRepository.save(user1);

		Status openStatus = new Status();
		openStatus.setName("open");
		statusRepository.save(openStatus);

		Backpack backpack = new Backpack();
		backpack.setDescription("simple big backpack for man");
		backpack.setQuantity(100);
		backpack.setWeight(2);
		backpack.setMaxCapacity(15000);
		backpackRepository.save(backpack);

		Order order1 = new Order();
		order1.setBackpack(backpack);
		order1.setCreatedAt(Timestamp.valueOf("2007-09-23 10:10:10.0"));
		order1.setDelivery("by car ");
		order1.setPaid(false);
		order1.setStatus(openStatus);
		order1.setUser(user1);
		orderRepository.save(order1);

		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(order1);
		orderItem.setItem(cowMilkItem);
		orderItem.setQuantity(3);
		orderItemRepository.save(orderItem);

	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(applicationContext.getDisplayName());
//		System.out.println(applicationContext.getId());
//		seed();

	}

}


