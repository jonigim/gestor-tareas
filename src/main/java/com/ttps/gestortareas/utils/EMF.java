package com.ttps.gestortareas.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private	static final EntityManagerFactory EM = Persistence.createEntityManagerFactory("up");
	
	private EMF() {
		//Nothing to do	
	}
	
	public static EntityManagerFactory getEMF() {
		return EM;
	}
}
