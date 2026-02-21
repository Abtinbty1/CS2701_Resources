package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderedItems;
import com.example.demo.Models.Produce;
import com.example.demo.Models.SellerProduce;
import com.example.demo.Models.User;
import com.example.demo.Models.UserType;
import com.example.demo.Repos.OrderRepository;
import com.example.demo.Repos.OrderedItemsRepository;
import com.example.demo.Repos.ProduceRepository;
import com.example.demo.Repos.SellerProduceRepository;
import com.example.demo.Repos.UserRepository;

@Component
public class DatabaseInit implements CommandLineRunner {

    // Step 0: Inject all necessary repositories 
    @Autowired private UserRepository userRepository;
    @Autowired private ProduceRepository produceRepository;
    @Autowired private SellerProduceRepository sellerProduceRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderedItemsRepository orderedItemsRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data to avoid duplicates on restart
        orderedItemsRepository.deleteAll();
        orderRepository.deleteAll();
        sellerProduceRepository.deleteAll();
        produceRepository.deleteAll();
        userRepository.deleteAll();

        // Step 1: Create and save Users [cite: 90]
        User bob = new User("Bob", "bob@sample.com", "bob_pass", UserType.BUYER); // [cite: 91]
        User prapanch = new User("Prapanch", "prapanch@sample.com", "prap_pass", UserType.SELLER); // [cite: 92]
        User ademola = new User("Ademola", "ademola@sample.com", "ade_pass", UserType.BOTH); // [cite: 93]
        User zhixian = new User("Zhixian", "zhixian@sample.com", "zhi_pass", UserType.BUYER); // [cite: 94]

        userRepository.save(bob);
        userRepository.save(prapanch);
        userRepository.save(ademola);
        userRepository.save(zhixian);

        // Step 2: Create and save Produce types [cite: 95]
        Produce apple = produceRepository.save(new Produce("Apple")); // [cite: 96]
        Produce lettuce = produceRepository.save(new Produce("Lettuce")); // [cite: 97]
        Produce potatoes = produceRepository.save(new Produce("Potatoes")); // [cite: 98]

        // Step 3: Add selling/stock information (SellerProduce) [cite: 99]
        // Prapanch sells apples (£0.15, stock 100) and lettuce (£0.25, stock 20) [cite: 100]
        SellerProduce prapApple = sellerProduceRepository.save(new SellerProduce(prapanch, apple, 100, 0.15));
        SellerProduce prapLettuce = sellerProduceRepository.save(new SellerProduce(prapanch, lettuce, 20, 0.25));

        // Ademola sells apples (£0.30, stock 50) and potatoes (£0.05, stock 30) [cite: 101]
        SellerProduce adeApple = sellerProduceRepository.save(new SellerProduce(ademola, apple, 50, 0.30));
        SellerProduce adePotatoes = sellerProduceRepository.save(new SellerProduce(ademola, potatoes, 30, 0.05));

        // Step 4: Create and save Orders [cite: 102]
        // Bob's order [cite: 103]
        Order bobsOrder = orderRepository.save(new Order(bob, new Date()));
        orderedItemsRepository.save(new OrderedItems(bobsOrder, adeApple, 2, 0.30));
        orderedItemsRepository.save(new OrderedItems(bobsOrder, prapLettuce, 1, 0.25));

        // Zhixian's order [cite: 104]
        Order zhiOrder = orderRepository.save(new Order(zhixian, new Date()));
        orderedItemsRepository.save(new OrderedItems(zhiOrder, prapApple, 10, 0.15));
        orderedItemsRepository.save(new OrderedItems(zhiOrder, adePotatoes, 15, 0.05));
        
        System.out.println("Database Initialized with sample data!");
    }
}