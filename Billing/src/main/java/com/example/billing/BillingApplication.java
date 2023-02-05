package com.example.billing;

import com.example.billing.Entity.Bills;
import com.example.billing.Entity.ProductItem;
import com.example.billing.Model.Customer;
import com.example.billing.Model.Product;
import com.example.billing.Service.BillsService;
import com.example.billing.Service.CustomerRestClient;
import com.example.billing.Service.ProductItemService;
import com.example.billing.Service.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillsService billsService,
							ProductItemService productItemService,
							ProductRestClient productRestClient,
							CustomerRestClient customerRestClient){
		return args -> {
			Collection<Product> productList = productRestClient.allProduct();
			Long customerId = 1L;
			Customer customer = customerRestClient.findCustomerById(customerId);

			if (customer == null) throw new RuntimeException("Customer not found");

			Bills bills = new Bills();
			bills.setBillDate(new Date());
			bills.setCustomerId(customerId);
			Bills saved_bill = billsService.save(bills);
			productList.forEach(product -> {
				ProductItem productItem = new ProductItem();
				productItem.setBills(saved_bill);
				productItem.setQuantite(1+new Random().nextInt(10));
				productItem.setProductId(product.getId_Inventory());
				productItem.setPrice(product.getPrice_Inventory());
				productItem.setDiscount(Math.random());
				productItemService.save(productItem);
			});
		};
	}
}
