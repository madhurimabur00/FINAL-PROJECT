package com.ems.daoimpl;

import javax.swing.JOptionPane;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.ManagerDAO;

import com.ems.entity.Manager;

public class ManagerDAOImpl implements ManagerDAO{

	@Override
	public void saveManager(Manager manager) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			
			session.save(manager);
			
			session.getTransaction().commit();
			
			
			session.clear();
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		
	}
		
	}

	@Override
	public  Manager getManagerUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Manager manager=session.get(Manager.class, id);
			return manager;
		}
		catch (HibernateException e) 
	{
		System.out.println(e.getMessage());
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	}
	
		return null;
	}

	@Override
	public Manager updateManager(int id, Manager manager) {
		try(Session session=HibernateUtil.getSession())
		{
			Manager manager1=session.get(Manager.class, id);
			
			//updating existing details with the new one
			manager1.setManName(manager1.getManName());
			manager1.setManEmail(manager1.getManEmail());
			manager1.setManAdd(manager1.getManAdd());
			manager1.setManSalary(manager1.getManSalary());
			
			manager1.setUserName(manager1.getUserName());
			manager1.setPassword(manager1.getPassword());
			
			
			
			
			session.beginTransaction();
			session.saveOrUpdate(manager1);
			session.getTransaction().commit();
			
		
		return manager1;    //returning entity
	}
		
	catch (HibernateException e) 
	{
		System.out.println(e.getMessage());
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	}
	
		return null;
	}

	@Override
	public void deleteManager(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Manager manager=session.load(Manager.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete all details??","Are you sure??"
					, JOptionPane.YES_NO_OPTION);
			
			if(input ==0)
				
			{
				session.delete(manager);
				
				JOptionPane.showMessageDialog(null,"Deleted Successfully!!");
				
			}else
			{
				JOptionPane.showMessageDialog(null,"User wants to return Mainmenu");	
			}
			session.getTransaction().commit();
		}
		catch (HibernateException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public boolean login(String userName, String password) {
		try(Session session=HibernateUtil.getSession())
		{
			int id =Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ", "Type Here..." ));
			Manager manager=session.get(Manager.class,id);
			if (manager.getUserName().equals(userName) && manager.getPassword().equals(password) && manager.getRole().equals("manager"))
			{
				JOptionPane.showMessageDialog(null,"Successfully Logged in!!");
				return true;
			}else {
				JOptionPane.showMessageDialog(null,"WRONG INPUT!!");
				return false;
			}
		}
		
	}

	
}
