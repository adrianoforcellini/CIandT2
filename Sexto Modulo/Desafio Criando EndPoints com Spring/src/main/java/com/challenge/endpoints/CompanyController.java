package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController implements CompanyServiceInterface {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    @GetMapping({"/{id}"})
    public Optional<Company> findById(@PathVariable  Long id) {
        return companyService.findById(id);
    }

    @Override
    @GetMapping(params = "accelerationId")
    public List<Company> findByAccelerationId(@RequestParam Long accelerationId) {
        return companyService.findByAccelerationId(accelerationId);
    }

    @Override
    @GetMapping(params = "userId")
    public List<Company> findByUserId(@RequestParam Long userId) {
        return companyService.findByUserId(userId);
    }
}
