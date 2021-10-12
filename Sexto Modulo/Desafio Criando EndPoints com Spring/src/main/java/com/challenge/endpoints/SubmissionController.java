package com.challenge.endpoints;

import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/submission")
public class SubmissionController implements SubmissionServiceInterface {
    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @Override
    @GetMapping(params = {"challengeId", "accelerationId"})
    public List<Submission> findByChallengeIdAndAccelerationId(
            @RequestParam Long challengeId,
            @RequestParam Long accelerationId) {
        return submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
}
