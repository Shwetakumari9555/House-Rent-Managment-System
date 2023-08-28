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
import com.masaischool.util.EMUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class DaoIMplementation implements ClassDao{
	
	@Override
	public void Add_Owner(Owner owner) throws SomethingWentWrongException {
		EntityManager em = EMUtil.getConnection();
		EntityTransaction et = em.getTransaction();
		
		try {
			
			et.begin();
			em.persist(owner);
			et.commit();	
			
		}catch ( IllegalStateException | IllegalArgumentException e) {
			
			et.rollback();
			throw new SomethingWentWrongException("Error While Adding Owner:" +  e.getMessage());
			
		}catch (Exception e) {
			throw new SomethingWentWrongException("Owner Already present");
		}
		finally {
			em.close();
		}
		
		
	}

	@Override
	public void Add_Tenant(Tenant tenant) throws SomethingWentWrongException {
		EntityManager em = EMUtil.getConnection();
		EntityTransaction et = em.getTransaction();
		
		try {
			
			et.begin();
			em.persist(tenant);
			et.commit();	
			
		}catch ( IllegalStateException | IllegalArgumentException e) {
			
			et.rollback();
			throw new SomethingWentWrongException("Error While Adding Tenant:" +  e.getMessage());
			
		}catch (Exception e) {
			throw new SomethingWentWrongException("Tenant Already Present");
		}
		
		finally {
			em.close();
		}
		
		
	}

	
	@Override
	public void Add_Commercial(Commercial commercium) throws SomethingWentWrongException{
		EntityManager em = EMUtil.getConnection();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(commercium);
			et.commit();
		}catch (Exception e) {
			et.rollback();
			throw new SomethingWentWrongException("Error while adding Commercial Property:" + e.getMessage());
		}finally {
			em.close();
		}
	}
	
	@Override
	public void Add_Residential(Residential residential) throws SomethingWentWrongException{
		EntityManager em = EMUtil.getConnection();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(residential);
			et.commit();
		}catch (Exception e) {
			et.rollback();
			throw new SomethingWentWrongException("Error while adding Residential Property:" + e.getMessage());
		}finally {
			em.close();
		}
	}

	

	@Override
	public void UpdatePropertyDetails(long propertyId, double rent, AvailableStatus status)
			throws SomethingWentWrongException , NoRecordFoundException {
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtil.getConnection();
			et= em.getTransaction();
			et.begin();
			
		String query1 = "UPDATE Commercial c SET c.rent = :newRent , c.status = :newStatus WHERE c.id = :propertyId";
		Query q1 = em.createQuery(query1);
		q1.setParameter("newRent", rent);
		q1.setParameter("newStatus", status);
		q1.setParameter("propertyId", propertyId);
		
		int result = q1.executeUpdate();
		
		String query2 = "UPDATE Residential r SET r.rent = :newRent , r.status = :newStatus WHERE r.id = :propertyId";
		Query q2 = em.createQuery(query2);
		q2.setParameter("newRent", rent);
		q2.setParameter("newStatus", status);
		q2.setParameter("propertyId", propertyId);
		
		int result1 = q2.executeUpdate();
		
		if(result ==0 && result1==0) {
			throw new NoRecordFoundException("No Property Found with Id:" +propertyId);	
			
		}
		et.commit();
	
		}catch (Exception e) {
			if(et != null && et.isActive()) {
				et.rollback();
			}
			throw new SomethingWentWrongException("Something went wrong while updating property details."+ e.getMessage());
			
		}finally {
			if(em !=null) {
				em.close();
			}
		}
		
	}

//	@Override
//	public void PrintCommercialAvailableProperty(String location, int minRentAmount, int maxRentAmount)
//			throws SomethingWentWrongException, NoRecordFoundException {
//		try (EntityManager em = EMUtil.getConnection()){
//			String query = "SELECT c from Commercial c WHERE c.location = :location AND c.rent BETWEEN :minRentAmont AND :maxRentAmount";
//			Query q = em.createQuery(query);
//			q.setParameter("location", location);
//			q.setParameter("minRentAmount", minRentAmount);
//			q.setParameter("maxRentAmount", maxRentAmount);
//			
//			List<Commercial> commercial = (List<Commercial>) q.getResultList();
//			for(Commercial com: commercial)
//				System.out.println(com.toString());
//		}catch (IllegalArgumentException | IllegalStateException e) {
//			System.out.println(e.getMessage());
//			throw new NoRecordFoundException("Property is not available");
//		}
//		
//	}
//	
//	

//	@Override
//	public void PrintResidentialAvailableProperty(String location, int minRentAmount, int maxRentAmount)
//			throws SomethingWentWrongException, NoRecordFoundException {
//		
//			try (EntityManager em = EMUtil.getConnection()){
//				String query = "SELECT c from Residential c WHERE c.location = :location AND c.rent BETWEEN :minRentAmont AND :maxRentAmount";
//				Query q = em.createQuery(query);
//				q.setParameter("location", location);
//				q.setParameter("minRentAmount", minRentAmount);
//				q.setParameter("maxRentAmount", maxRentAmount);
//				
//				List<Residential> residential = (List<Residential>) q.getResultList();
//				for(Residential res: residential)
//					System.out.println(res.toString());
//			}catch (IllegalArgumentException | IllegalStateException e) {
//				System.out.println(e.getMessage());
//				throw new NoRecordFoundException("Property is not available");
//			}
//		
//	}

	@Override
	public List<Commercial> searchCommercialProperties(String location, double minRentAmount, double maxRentAmount)
	        throws SomethingWentWrongException, NoRecordFoundException {
	    try (EntityManager em = EMUtil.getConnection()) {
	    	String query = "SELECT c from Commercial c WHERE c.Location = :location AND c.rent BETWEEN :minRentAmount AND :maxRentAmount";
	    	Query q = em.createQuery(query);
	    	q.setParameter("location", location);
	    	q.setParameter("minRentAmount", minRentAmount);
	    	q.setParameter("maxRentAmount", maxRentAmount);
// Correct parameter name


	        List<Commercial> commercial = (List<Commercial>) q.getResultList();
	        return commercial; // Return the list of properties
	    } catch (IllegalArgumentException | IllegalStateException e) {
	        System.out.println(e.getMessage());
	        throw new SomethingWentWrongException("Error while accessing property data.");
	    }
	}
	@Override
	public List<Residential> searchResidentialProperties(String location, double minRentAmount, double maxRentAmount)
	        throws SomethingWentWrongException, NoRecordFoundException {
	    try (EntityManager em = EMUtil.getConnection()) {
	        String query = "SELECT c from Residential c WHERE c.Location = :location AND c.rent BETWEEN :minRentAmount AND :maxRentAmount";
	        Query q = em.createQuery(query);
	        q.setParameter("location", location);
	        q.setParameter("minRentAmount", minRentAmount);
	        q.setParameter("maxRentAmount", maxRentAmount);


	        List<Residential> residential = (List<Residential>) q.getResultList();
	        return residential; // Return the list of properties
	    } catch (IllegalArgumentException | IllegalStateException e) {
	        System.out.println(e.getMessage());
	        throw new SomethingWentWrongException("Error while accessing property data.");
	    }
	
	
	
	}

	

	@Override
	public void Add_Commercial_Description(Commercial commercial, PropertyDescription desc)
			throws SomethingWentWrongException {
		
		 EntityManager em = EMUtil.getConnection();
		 EntityTransaction et = em.getTransaction();
		 
		 try {
			
			 et.begin();
			 commercial= em.merge(commercial);
//			 commercial.setDescription(desc);
			 desc.setCommercial(commercial);
			 em.persist(desc);
			 et.commit();
			 
			 
			 
		} catch (Exception e) {
			
			et.rollback();
			System.out.println(e.getMessage());
		}
	
		 finally {
			 em.close();
		 }
		
		
	}
	
	@Override
	public void Add_Residential_Description(Residential residential, PropertyDescription desc)
			throws SomethingWentWrongException {
		
		 EntityManager em = EMUtil.getConnection();
		 EntityTransaction et = em.getTransaction();
		 
		 try {
			
			 et.begin();
			 residential= em.merge(residential);
//			 commercial.setDescription(desc);
			 desc.setResidential(residential);
			 em.persist(desc);
			 et.commit();
			 
			 
			 
		} catch (Exception e) {
			
			et.rollback();
			System.out.println(e.getMessage());
		}
	
		 finally {
			 em.close();
		 }
		
		
	}

@Override
public void LoginAsOwner(String email, String password) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtil.getConnection();
			
			Query query = em.createQuery("SELECT o FROM Owner o WHERE email = :username AND password= :password");
			query.setParameter("username", email);
			query.setParameter("password", password);
			
			Object result = query.getSingleResult();
			if(result != null) {
				System.out.println("Login Succesfully");
				
				//add function
			}else {
				throw new NoRecordFoundException("No User Found With the Provided Credentials.");
			}
			
			
			
			
		}catch (NoRecordFoundException e) {
			throw new SomethingWentWrongException("An error occurred during login.");
		}finally {
			em.close();
		}
	
	
}

@Override
public void LoginAsTenant(String email, String password) throws SomethingWentWrongException, NoRecordFoundException {
	
	EntityManager em= null;
	try {
		em = EMUtil.getConnection();
		
		Query query = em.createQuery("SELECT o FROM Tenant o WHERE email = :username AND password= :password");
		query.setParameter("username", email);
		query.setParameter("password", password);
		
		Object result = query.getSingleResult();
		if(result != null) {
			System.out.println("Login Succesfully");
			
			//add function
		}else {
			throw new NoRecordFoundException("No User Found With the Provided Credentials.");
		}
		
		
		
		
	}catch (NoRecordFoundException e) {
		throw new SomethingWentWrongException("An error occurred during login.");
	}finally {
		em.close();
	}
	
	
}

@Override
public void changePassword(String oldpassword, String reEnterPassword)throws SomethingWentWrongException, NoRecordFoundException {
	
	EntityManager em = null;
	EntityTransaction et = null;
	try {
		em= EMUtil.getConnection();
		et= em.getTransaction();
		et.begin();
		
		Query q = em.createQuery("Select t From Owner WHERE t.password =: oldPassword");
		q.setParameter("oldPassword", oldpassword);
		
		Tenant tenant = (Tenant) q.getSingleResult();
		if(tenant!= null) {
			tenant.setPassword(reEnterPassword);
			em.merge(tenant);
			et.commit();
			System.out.println("Password Updated Successfully");
			
		}else {
			throw new NoRecordFoundException("Owner not Found..");
		}
		
		
		
	}catch (NoResultException e) {
		throw new NoRecordFoundException("Tenant not found");
		
	}catch (Exception e) {
		if(et!=null && et.isActive()) {
			et.rollback();
		}
		throw new SomethingWentWrongException("An error Occured While Changing The Password");
	}finally {
		if(em!=null) {
			em.close();
		}
	}

	
}

  public void DeleteAccount(int id) throws SomethingWentWrongException{  
	EntityManager em = null;

    try {
        em = EMUtil.getConnection();
        
       
        Tenant tenant = em.find(Tenant.class, id);

        if (tenant != null) {
            em.getTransaction().begin();
            em.remove(tenant); 
            em.getTransaction().commit();
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Tenant not found with ID: " + id);
        }
    } catch (Exception e) {
        // Handle exceptions appropriately
        throw new SomethingWentWrongException("An error occurred while deleting the account.");
    } finally {
        if (em != null) {
            em.close();
        }
    }
}

@Override
public void DeletePropertyById(int id) throws SomethingWentWrongException {
	EntityManager em = null;

    try {
        em = EMUtil.getConnection();
        
       
        Commercial commercial = em.find(Commercial.class, id);
        Residential residential= null;

        if (commercial!= null) {
        	
        	
            em.getTransaction().begin();
            em.remove(commercial); 
            em.getTransaction().commit();
            System.out.println("Commercial Property deleted successfully.");
        } else {
            residential= em.find(Residential.class, id);
            if (residential!= null) {
            	
            	
                em.getTransaction().begin();
                em.remove(commercial); 
                em.getTransaction().commit();
                System.out.println("Residential Property deleted successfully.");
            
        }
        }
    } catch (Exception e) {
        // Handle exceptions appropriately
        throw new SomethingWentWrongException("An error occurred while deleting the account.");
    } finally {
        if (em != null) {
            em.close();
        }
    }
	
	
}

@Override
public PropertyDescription getPropertyDescriptionForResidential(Residential residential)throws SomethingWentWrongException {
	EntityManager em = EMUtil.getConnection();
	try {
		return em.find(PropertyDescription.class, residential.getPropertyDescription().getId());
	}catch (Exception e) {
		
	}
	
	return null;
}

@Override
public void saveOffer(int propertyId, double OfferAmount, String type) {
	EntityManager em = EMUtil.getConnection();
	if(type.equals("Commercial")) {
		Commercial commercial = em.find(Commercial.class, propertyId);
		commercial.setOfferAmount(OfferAmount);
	}else {
		Residential residential = em.find(Residential.class, propertyId);
		residential.setOfferAmount(OfferAmount);
	}
    
	
}

@Override
public List<Offer> getOffersForProperty(int propertyId) {
	 EntityManager em = EMUtil.getConnection();
	 
	 try {
	        String queryString = "SELECT o FROM Offer o WHERE o.propertyId = :propertyId";
	        TypedQuery<Offer> query = em.createQuery(queryString, Offer.class);
	        query.setParameter("propertyId", propertyId);

	        return query.getResultList();
	    } finally {
	        em.close();
	    }
	
}

@Override
public boolean updateOfferStatus(int offerId, boolean accept) {
	EntityManager em = EMUtil.getConnection();
    em.getTransaction().begin();

    Offer offer = em.find(Offer.class, offerId);
    if (offer != null) {
        offer.setAccepted(accept);
    }

    em.getTransaction().commit();
    em.close();

    return offer != null;
	
    
    //status change
}

@Override
public Commercial ViewCommercialPropertyById(long propertyId) throws SomethingWentWrongException {
	EntityManager em = null;
    try {
        em = EMUtil.getConnection();
        
        // Create a JPQL query to select the property by its ID
        String jpql = "SELECT p FROM Commercial p WHERE p.id = :propertyId";
        TypedQuery<Commercial> query = em.createQuery(jpql, Commercial.class);
        query.setParameter("propertyId", propertyId);
        
        return query.getSingleResult();
    } catch (NoResultException e) {
        return null; // Return null if no property is found
    } catch (Exception e) {
        throw new SomethingWentWrongException("Error while fetching property details: " + e.getMessage());
    } finally {
        if (em != null) {
            em.close();
        }
    }
	
}

@Override
public Residential ViewResidentialPropertyById(long propertyId) throws SomethingWentWrongException {
	EntityManager em = null;
    try {
        em = EMUtil.getConnection();
        
        // Create a JPQL query to select the property by its ID
        String jpql = "SELECT p FROM Residential p WHERE p.id = :propertyId";
        TypedQuery<Residential> query = em.createQuery(jpql, Residential.class);
        query.setParameter("propertyId", propertyId);
        
        return query.getSingleResult();
    } catch (NoResultException e) {
        return null; // Return null if no property is found
    } catch (Exception e) {
        throw new SomethingWentWrongException("Error while fetching property details: " + e.getMessage());
    } finally {
        if (em != null) {
            em.close();
        }
    }
}
	
		
	}
	

	
	
	
	




	