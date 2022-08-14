package com.demo.Hibdemo2;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = HibernateUtil.getInstnce();
        Session session = sessionFactory.openSession();    

        Employee e1=new Employee();    
      //  e1.setId(103);
        e1.setName("Gaurav Chawla");    

        Regular_Employee e2=new Regular_Employee();    
       // e2.setId(101);
        e2.setName("Vivek Kumar");    
        e2.setSalary(50000);    
        e2.setBonus(5);    

        Contract_Employee e3=new Contract_Employee();   
      //  e3.setId(102);
        e3.setName("Arjun Kumar");    
        e3.setPay_per_hour(1000);    
        e3.setContract_duration("15 hours");    


        org.hibernate.Transaction transaction;
        transaction=session.beginTransaction();
      //  session.save(vendor);
     /*   session.persist(e1);
        session.persist(e2);
        session.persist(e3);*/
session.save(e1);session.save(e2);session.save(e3);
        transaction.commit();
 
        session.close();
        sessionFactory.close();
    }
}
