package com.afpa.bibliotheque.utility;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {


    public static final EntityManagerFactory EMF =
            Persistence.createEntityManagerFactory("wtf");


}
