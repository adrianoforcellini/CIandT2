package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController implements ChallengeServiceInterface {
    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @Override
    @GetMapping(params = {"accelerationId", "userId"})
    public List<Challenge> findByAccelerationIdAndUserId(
            @RequestParam Long accelerationId,
            @RequestParam Long userId) {
        return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}

