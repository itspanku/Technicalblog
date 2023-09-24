package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started..." );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        
        //creating student
        Student st=new Student();
        st.setId(101);
        st.setName("John");
        st.setCity("Dehli");
        
     // creating object for address
        Address ad=new Address();
        ad.setStreet("Street1");
        ad.setCity("Dehli");
        ad.setIsopen(true);
        ad.setAddedDate(new Date());
        ad.setX(12.23);
        
        // reading image
        FileInputStream fis= new FileInputStream("src/main/java/R.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done");
    }
}
