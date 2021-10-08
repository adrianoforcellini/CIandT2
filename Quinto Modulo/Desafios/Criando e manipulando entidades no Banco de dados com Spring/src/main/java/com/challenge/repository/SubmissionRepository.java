package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query(value = "SELECT s.* FROM Submission s, " +
            "Challenge c, Acceleration a " +
            "WHERE s.Challenge_id = c.id AND c.id = a.Challenge_id " +
            "AND s.Challenge_id = :challengeId AND a.id = :accelerationId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(
            @Param("challengeId") Long challengeId,
            @Param("accelerationId") Long accelerationId
    );

    Submission findFirstByIdChallengeIdOrderByScoreDesc(Long challengeId);
}


// https://stackoverflow.com/questions/2061068/jpa-find-the-last-entry

// Montagem da Query feito pelo meu bom amigo Layo
// https://www.codenation.dev/code-review/#/java-10/j1_FGdH7R