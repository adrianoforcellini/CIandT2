package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    @Query("SELECT DISTINCT cha FROM Challenge cha " +
            " JOIN cha.accelerations AS acc " +
            " JOIN acc.candidates can " +
            " JOIN can.id.user user " +
            "WHERE user.id = :userId AND acc.id = :accelerationId")
    List<Challenge> findByAccelerationIdAndUserId(
            @Param("accelerationId") Long accelerationId, @Param("userId") Long userId);

}

// Montagem da Query feito pelo meu bom amigo Layo
// https://www.codenation.dev/code-review/#/java-10/j1_FGdH7R