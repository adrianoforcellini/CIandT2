package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController implements AccelerationServiceInterface {
    private final AccelerationService accelerationService;

    public AccelerationController(AccelerationService accelerationService) {
        this.accelerationService = accelerationService;
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable("id")  Long id) {
        return accelerationService.findById(id);
    }

    @Override
    @GetMapping(params = "companyId")
    public List<Acceleration> findByCompanyId(@RequestParam Long companyId) {
        return accelerationService.findByCompanyId(companyId);
    }
}
