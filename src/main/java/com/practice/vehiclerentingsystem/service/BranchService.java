package com.practice.vehiclerentingsystem.service;

import com.practice.vehiclerentingsystem.domain.entities.Branch;
import com.practice.vehiclerentingsystem.repository.BranchRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchService {
    private BranchRepo branchRepo;
    public Branch addBranch(Branch branch){
        Branch branchByName = getBranchByName(branch.getBranchName());
        if(branchByName !=null) return null;
        return branchRepo.save(branch);
        }
    public Branch getBranchByName(String branchName){
        List<Branch> branch= branchRepo.getByBranchName(branchName);
        return branch.isEmpty()?null:branch.get(0);
    }

}
