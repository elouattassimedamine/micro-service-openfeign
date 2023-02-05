package com.example.customerservice.Web;

import com.example.customerservice.Entity.Customer;
import com.example.customerservice.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    @ResponseBody
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Customer> findAll(){
        return customerService.findAll();
    }
}
