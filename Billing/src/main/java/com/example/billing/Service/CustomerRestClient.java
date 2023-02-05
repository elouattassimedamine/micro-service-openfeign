package com.example.billing.Service;

import com.example.billing.Model.Customer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER")
public interface CustomerRestClient {

    @GetMapping(path = "/find/{id}")
    Customer findCustomerById(@PathVariable Long id);
}
