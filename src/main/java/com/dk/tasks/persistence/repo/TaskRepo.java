package com.dk.tasks.persistence.repo;

import com.dk.tasks.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepo extends JpaRepository<TaskEntity, Long> {

    @Query("SELECT t FROM TaskEntity t WHERE t.taxCode = :taxCode OR t.phone = :phone")
    Optional<TaskEntity> findByTaxCodeOrPhone(String taxCode, String phone);

    @Query("SELECT t FROM TaskEntity t WHERE t.assignedTo = :assignedTo")
    List<TaskEntity> findAllTasksByAssignedTo(Integer assignedTo);

    @Query("SELECT t FROM TaskEntity t WHERE t.createdBy = :createdBy")
    List<TaskEntity> findAllTasksByCreatedBy(Integer createdBy);

    @Query("SELECT t FROM TaskEntity t WHERE t.teamId = :teamId")
    List<TaskEntity> findAllTasksByTeamId(Integer teamId);
}
