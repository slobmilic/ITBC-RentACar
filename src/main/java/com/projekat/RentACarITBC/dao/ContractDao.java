package com.projekat.RentACarITBC.dao;

import com.projekat.RentACarITBC.model.ContractModel;

import java.util.List;

public interface ContractDao {
    ContractModel sample();
    void addContract(ContractModel contract);
    List<ContractModel> getAllContracts();
    List<ContractModel> getPending();
    void approval(String contractId);
    List<ContractModel> getHistory(String userId);
}
