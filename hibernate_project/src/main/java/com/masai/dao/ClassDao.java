package com.masai.dao;

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

public interface ClassDao {
    void Add_Owner(Owner owner) throws SomethingWentWrongException;
    void Add_Tenant(Tenant tenant) throws SomethingWentWrongException;
//    boolean AlreadyRegisterOwner(String email) throws SomethingWentWrongException, NoRecordFoundException;
    void Add_Commercial(Commercial commercium) throws SomethingWentWrongException;
    void Add_Residential(Residential residential) throws SomethingWentWrongException;
    void UpdatePropertyDetails(long propertyId, double rent, AvailableStatus status) 
            throws SomethingWentWrongException, NoRecordFoundException;
    List<Commercial> searchCommercialProperties(String location, double minRentAmount, double maxRentAmount)
            throws SomethingWentWrongException, NoRecordFoundException;
    List<Residential> searchResidentialProperties(String location, double minRentAmount, double maxRentAmount)
            throws SomethingWentWrongException, NoRecordFoundException;

    
	void Add_Commercial_Description(Commercial commercial,PropertyDescription desc)throws SomethingWentWrongException;
	
	void LoginAsOwner(String username, String password) throws SomethingWentWrongException, NoRecordFoundException;
	void LoginAsTenant(String username, String password) throws SomethingWentWrongException, NoRecordFoundException;
	public void changePassword(String oldpassword, String reEnterPassword)throws SomethingWentWrongException, NoRecordFoundException;
	public void DeleteAccount(int id) throws SomethingWentWrongException;
	void DeletePropertyById(int id) throws SomethingWentWrongException;
	void Add_Residential_Description(Residential residential, PropertyDescription desc)throws SomethingWentWrongException;
	PropertyDescription getPropertyDescriptionForResidential(Residential residential) throws SomethingWentWrongException;
	
    List<Offer> getOffersForProperty(int propertyId);
    boolean updateOfferStatus(int offerId, boolean accept);
	
	void saveOffer(int propertyId, double OfferAmount, String type);
	Commercial ViewCommercialPropertyById(long propertyId) throws SomethingWentWrongException;
	Residential ViewResidentialPropertyById(long propertyId) throws SomethingWentWrongException;

    
}
