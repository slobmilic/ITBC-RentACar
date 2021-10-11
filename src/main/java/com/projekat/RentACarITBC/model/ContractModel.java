package com.projekat.RentACarITBC.model;

import java.util.Date;
import java.util.UUID;

public class ContractModel {
    private UUID contractId;
    private Date startDate;
    private Date endDate;
    private double totalPrice;
    private boolean signed;
    private boolean approved;

}
