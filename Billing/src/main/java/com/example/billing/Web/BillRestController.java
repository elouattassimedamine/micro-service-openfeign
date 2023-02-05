package com.example.billing.Web;

import com.example.billing.Entity.Bills;
import com.example.billing.Service.BillsService;
import com.example.billing.Service.CustomerRestClient;
import com.example.billing.Service.ProductItemService;
import com.example.billing.Service.ProductRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillRestController {

    private BillsService billsService;
    private ProductItemService productItemService;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillsService billsService, ProductItemService productItemService, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billsService = billsService;
        this.productItemService = productItemService;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping("/find/{id}")
    public Bills findById(@PathVariable Long id){
        Bills bills = billsService.findById(id);
        bills.setCustomer(customerRestClient.findCustomerById(bills.getCustomerId()));
        bills.getProductItemList().forEach(pi ->{
            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
        });

        return bills;
    }
}
