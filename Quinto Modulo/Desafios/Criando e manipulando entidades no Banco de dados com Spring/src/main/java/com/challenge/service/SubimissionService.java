package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SubimissionService implements SubmissionServiceInterface {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public Submission save(Submission object) {
        return null;
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        BigDecimal result = BigDecimal.ZERO;
        try {
            result = BigDecimal.valueOf(submissionRepository.findFirstByIdChallengeIdOrderByScoreDesc(challengeId).getScore());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
}
