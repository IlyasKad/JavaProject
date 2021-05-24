package com.travelset.laba3.controllers;


import com.travelset.laba3.context.TestConfig;
import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.*;
import com.travelset.laba3.model.entity.Order;
import com.travelset.laba3.model.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@SpringBootTest(classes = {TestConfig.class})
@AutoConfigureDataJpa
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
public class OrderControllerIT {

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
    @Autowired
    private OrderController orderController;


    @BeforeEach
    public void createAllData(){
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
    }

    @Test
    public void createFindDeleteFindAgainOrder() {
        Backpack backpack = backpackRepository.findFirstByOrderByIdAsc();
        Status status = statusRepository.findFirstByOrderByIdAsc();
        User user = userRepository.findFirstByOrderByIdAsc();

        Order order1 = new Order();
        order1.setBackpack(backpack);
        order1.setCreatedAt(Timestamp.valueOf("2007-09-23 10:10:10.0"));
        order1.setDelivery("by car ");
        order1.setPaid(false);
        order1.setStatus(status);
        order1.setUser(user);
        Order orderSaved = orderController.saveOrder(order1);

        Order foundOrder = orderController.getOrderById(orderSaved.getId());
        Assertions.assertEquals(order1, foundOrder);
        orderController.deleteOrder(orderSaved.getId());
        Assertions.assertThrows(NoSuchEntityElementException.class,
                () -> orderController.getOrderById(orderSaved.getId()));


    }
}
