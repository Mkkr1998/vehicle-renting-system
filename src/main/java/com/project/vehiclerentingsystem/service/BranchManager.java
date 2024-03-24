package com.project.vehiclerentingsystem.service;

import com.project.vehiclerentingsystem.entity.Branch;
import com.project.vehiclerentingsystem.repository.BranchRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchManager {
    BranchRepo branchRepo;
    BranchManager(BranchRepo branchRepo){
        this.branchRepo=branchRepo;
    }
    public Branch addBranch(Branch branch){
        return branchRepo.save(branch);
    }
    public Branch getBranch(String branchName){
        List<Branch> branch=branchRepo.getByBranchName(branchName);
        if(branch.size()==0) return null;
        else return branch.get(0);
    }
}
