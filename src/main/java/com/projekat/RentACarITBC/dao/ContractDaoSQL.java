package com.projekat.RentACarITBC.dao;

import com.projekat.RentACarITBC.model.ContractModel;

import java.util.List;

public class ContractDaoSQL implements ContractDao{
    @Override
    public ContractModel sample() {
        return null;
    }

    @Override
    public void addContract(ContractModel contract) {

    }

    @Override
    public List<ContractModel> getAllContracts() {
        return null;
    }

    @Override
    public List<ContractModel> getPending() {
        return null;
    }

    @Override
    public void approval(String contractId) {

    }

    @Override
    public List<ContractModel> getHistory(String userId) {
        return null;
    }
}
