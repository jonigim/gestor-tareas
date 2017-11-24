package com.ttps.gestortareas.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private	static final EntityManagerFactory EM = Persistence.createEntityManagerFactory("up");
	
	public EMF() {

	}
	
	public static EntityManagerFactory getEMF() {
		return EM;
	}
}
