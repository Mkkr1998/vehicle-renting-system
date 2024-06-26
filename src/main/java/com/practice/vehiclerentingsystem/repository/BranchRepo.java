package com.practice.vehiclerentingsystem.repository;

import com.practice.vehiclerentingsystem.domain.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long> {
    List<Branch> getByBranchName(String branchName);
}
