package com.masai.service;

import java.util.List;

import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;
import com.masai.entity.AvailableStatus;
import com.masai.entity.Commercial;
import com.masai.entity.PropertyDescription;
import com.masai.entity.Residential;
import com.masai.ui.Offer;
import com.masai.ui.Owner;
import com.masai.ui.Tenant;

public interface ClassService {
    void Add_Owner(Owner owner) throws SomethingWentWrongException;
    void Add_Tenant(Tenant tenant) throws SomethingWentWrongException;

    public void Add_Commercial(Commercial commercium) throws SomethingWentWrongException;
    public void Add_Residential(Residential residential) throws SomethingWentWrongException;
	void UpdateProperty(long propertyId, double rent, AvailableStatus status) throws SomethingWentWrongException, NoRecordFoundException;

	List<Commercial> searchCommercialProperties(String location, double minRentAmount, double maxRentAmount) throws SomethingWentWrongException, NoRecordFoundException;
	List<Residential> searchResidentialProperties(String location, double minRentAmount, double maxRentAmount)
			throws SomethingWentWrongException, NoRecordFoundException;
	void Add_Commercial_Description(Commercial commercial,PropertyDescription desc)throws SomethingWentWrongException;
	void LoginAsOwner(String username, String password) throws SomethingWentWrongException , NoRecordFoundException;
	void LoginAsTenant(String username, String password) throws SomethingWentWrongException, NoRecordFoundException;
	void changePassword(String oldpassword, String reEnterPassword) throws SomethingWentWrongException, NoRecordFoundException;
	public void DeleteAccount(int id) throws SomethingWentWrongException;
	void DeletPropertyById(int id) throws SomethingWentWrongException;
	void Add_Residential_Description(Residential residential, PropertyDescription desc)throws SomethingWentWrongException;
	PropertyDescription getPropertyDescriptionForResidential(Residential residential) throws SomethingWentWrongException;
	
	
    List<Offer> getOffersForProperty(int propertyId);
    boolean acceptOrRejectOffer(int offerId, boolean accept);
	void submitOffer(int propertyId, double offerAmount, String type);
	Commercial ViewCommercialPropertyById(long propertyId) throws NoRecordFoundException,SomethingWentWrongException;
	Residential ViewResidentialPropertyById(long propertyId) throws NoRecordFoundException, SomethingWentWrongException;
}
