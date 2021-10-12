package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController implements CandidateServiceInterface {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @Override
    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    @NotNull
    public Optional<Candidate> findById(
            @PathVariable Long userId,
            @PathVariable Long companyId,
            @PathVariable Long accelerationId) {
        return candidateService.findById(userId, companyId, accelerationId);
    }
    // De acordo com o teste,
    // String uri = "/candidate/" + UserIds.THREE + "/" + AccelerationIds.ONE + "/" + CompanyIds.ONE;
    // Diferentemente do que a ordem da implementação leva a crer.

    @Override
    @GetMapping(params = "companyId")
    public List<Candidate> findByCompanyId(@RequestParam Long companyId) {
        return candidateService.findByCompanyId(companyId);
    }

    @Override
    @GetMapping(params = "accelerationId")
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return candidateService.findByAccelerationId(accelerationId);
    }
}

// Diferença de PathVariable e RequestParam
// receitasdecodigo.com.br/spring-framework/diferenca-entre-@pathvariable-e-@requestparam-do-spring-mvc
// Em suma, ao menos nesse projeto, sabemos que o caminho correto e pelo PathVariable,
// quando estamos lidando com a classe Optional.