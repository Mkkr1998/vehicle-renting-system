package com.project.vehiclerentingsystem.repository;

import com.project.vehiclerentingsystem.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Integer> {
    public List<Branch> getByBranchName(String branchName);
}
