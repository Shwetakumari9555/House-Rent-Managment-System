package com.masai.service;

import java.util.List;

import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;
import com.masai.dao.ClassDao;
import com.masai.dao.DaoIMplementation;
import com.masai.entity.AvailableStatus;
import com.masai.entity.Commercial;
import com.masai.entity.PropertyDescription;
import com.masai.entity.Residential;
import com.masai.ui.Offer;
import com.masai.ui.Owner;
import com.masai.ui.Tenant;

public class ClassServiceImplementation implements ClassService{
	@Override
	public void Add_Owner(Owner owner) throws SomethingWentWrongException {
		ClassDao classdao = new DaoIMplementation();
		classdao.Add_Owner(owner);
		
	}

	@Override
	public void Add_Tenant(Tenant tenant) throws SomethingWentWrongException {
		ClassDao classdao = new DaoIMplementation();
		classdao.Add_Tenant(tenant);
		
	}


	@Override
	public void Add_Commercial(Commercial commercium) throws SomethingWentWrongException {
		ClassDao classdao = new DaoIMplementation();
		classdao.Add_Commercial(commercium);
		
	}

	@Override
	public void Add_Residential(Residential residential) throws SomethingWentWrongException {
		ClassDao classdao = new DaoIMplementation();
		classdao.Add_Residential(residential);
		
	}



	@Override
	public void UpdateProperty(long propertyId, double rent, AvailableStatus status)
			throws SomethingWentWrongException, NoRecordFoundException {
		ClassDao classdao = new DaoIMplementation();
		classdao.UpdatePropertyDetails(propertyId, rent,status);
		
	}

//	@Override
//	public void PrintCommercialAvailableProperty(String location, int minRentAmount, int maxRentAmount)
//			throws SomethingWentWrongException, NoRecordFoundException {
//		
//		
//	}

//	@Override
//	public void PrintResidentialAvailableProperty(String location, int minRentAmount, int maxRentAmount)
//			throws SomethingWentWrongException, NoRecordFoundException {
//		ClassDao classdao = new DaoIMplementation();
//		classdao.PrintResidentialAvailableProperty(location, minRentAmount, maxRentAmount);
//		
//		
//	}

	@Override
	public List<Commercial> searchCommercialProperties(String location, double minRentAmount, double maxRentAmount)
	        throws SomethingWentWrongException, NoRecordFoundException {
	    ClassDao classdao = new DaoIMplementation();
	    return classdao.searchCommercialProperties(location, minRentAmount, maxRentAmount);
	}

	@Override
	public List<Residential> searchResidentialProperties(String location, double minRentAmount, double maxRentAmount)
	        throws SomethingWentWrongException, NoRecordFoundException {
	    ClassDao classdao = new DaoIMplementation();
	    return classdao.searchResidentialProperties(location, minRentAmount, maxRentAmount);
	}
	
	
//	@Override
//	void Add_Commercial_Description(Commercial commercial, String descriptionTitle, String descriptionDetails)
//			throws SomethingWentWrongException;{
//	    PropertyDescription description = commercial.getDescription(); // Get the associated description
//
//	    // Set the commercial property for the description
//	    description.setCommercial(commercial);
//
//	    ClassDao classdao = new DaoIMplementation();
//	    classdao.Add_Commercial(commercial); // This will save both the commercial and its description
//	}
	
//	public void Add_Commercial_Description(Commercial commercial, String descriptionTitle, String descriptionDetails)
//	        throws SomethingWentWrongException {
////	    PropertyDescription description = new PropertyDescription(descriptionTitle, descriptionDetails);
////	    commercial.setDescription(description); // Associate the description with the commercial
//
//	    // Since you're associating a detached description with a managed commercial, you need to merge the commercial
//	    ClassDao classdao = new DaoIMplementation();
//	    try {
//	        classdao.Add_Commercial_Description(commercial,descriptionTitle,descriptionDetails); // This will save both the commercial and its description
//	    } catch (SomethingWentWrongException e) {
//	        throw new SomethingWentWrongException("Error while adding commercial property and description: " + e.getMessage());
//	    }
//	}

	@Override
	public void Add_Commercial_Description(Commercial commercial, PropertyDescription desc)
			throws SomethingWentWrongException {
		
		ClassDao classdao = new DaoIMplementation();
		classdao.Add_Commercial_Description(commercial, desc);
		
	}
	
	@Override
	public void Add_Residential_Description(Residential residential, PropertyDescription desc)
			throws SomethingWentWrongException {
		
		ClassDao classdao = new DaoIMplementation();
		classdao.Add_Residential_Description(residential, desc);
		
	}
	
	
	

	@Override
	public void LoginAsOwner(String username, String password)throws SomethingWentWrongException, NoRecordFoundException {
		ClassDao classdao = new DaoIMplementation();
		classdao.LoginAsOwner(username, password);
		
	}

	@Override
	public void LoginAsTenant(String username, String password)throws SomethingWentWrongException, NoRecordFoundException {
		ClassDao classdao = new DaoIMplementation();
		classdao.LoginAsTenant(username, password);
		
		
	}

	@Override
	public void changePassword(String oldpassword, String reEnterPassword)throws SomethingWentWrongException, NoRecordFoundException {
		ClassDao classdao = new DaoIMplementation();
		classdao.changePassword(oldpassword, reEnterPassword);
		
	}

	@Override
	public void DeleteAccount(int id) throws SomethingWentWrongException {
		ClassDao classdao = new DaoIMplementation();
		classdao.DeleteAccount(id);
		
	}

	@Override
	public void DeletPropertyById(int id) throws SomethingWentWrongException {
		ClassDao classdao = new DaoIMplementation();
		classdao.DeletePropertyById(id);
		
	}

	@Override
	public PropertyDescription getPropertyDescriptionForResidential(Residential residential)throws SomethingWentWrongException {
		try {
			ClassDao classdao = new DaoIMplementation();
            return classdao.getPropertyDescriptionForResidential(residential);
        } catch (Exception e) {
            throw new SomethingWentWrongException("Error while fetching property description: " + e.getMessage());
        }
		
	}

	@Override
	public void submitOffer(int propertyId, double offerAmount, String type) {
	ClassDao classdao = new DaoIMplementation();
	classdao.saveOffer(propertyId,offerAmount, type);
		
		
	}

	@Override
	public List<Offer> getOffersForProperty(int propertyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptOrRejectOffer(int offerId, boolean accept) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Commercial ViewCommercialPropertyById(long propertyId) throws NoRecordFoundException, SomethingWentWrongException {
		ClassDao classdao = new DaoIMplementation();
	    return classdao.ViewCommercialPropertyById(propertyId);
	}

	@Override
	public Residential ViewResidentialPropertyById(long propertyId) throws NoRecordFoundException, SomethingWentWrongException {
		ClassDao classdao = new DaoIMplementation();
	    return classdao.ViewResidentialPropertyById(propertyId);
	}

	



}
		
		
	


