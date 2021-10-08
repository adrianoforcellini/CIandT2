package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {
    List<Candidate> findByIdCompanyId(Long companyId);
    List<Candidate> findByIdAccelerationId(Long accelerationId);
}
