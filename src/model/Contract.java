package model;

import java.util.*;

public class Contract {

	Collection<Bill> bills;
	RentVehicle rentVehicle;
	private Date startContractDate;
	private Date finishContractDate;
	Deposit[] deposit;
	Client[] client;
	Vehicle[] vehicle;
	private Collateral[] collateral;
	private String start_date;
	private String finish_date;

	public Contract() {
		// TODO - implement Contract.Contract
		throw new UnsupportedOperationException();
	}

}