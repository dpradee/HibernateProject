package com.hilo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hilo.common.HibernateSessionFactroy;
import com.hilo.entity.Robot;

public class RobotTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		boolean flag=false;
		Robot robot1=null;
		Robot robot2=null;
		Robot robot3=null;
		Robot robot4=null;
		Robot robot5=null;
		try {
			factory=HibernateSessionFactroy.getSessionFactory();
			session=factory.openSession();
			tx=session.beginTransaction();
			robot1=new Robot();
			robot1.setRobotName("babySaver");
			robot1.setRobotType("electronic");
			robot2=new Robot();
			robot2.setRobotName("babySaver2");
			robot2.setRobotType("electronic");
			robot3=new Robot();
			robot3.setRobotName("babySaver3");
			robot3.setRobotType("electronic");
			robot4=new Robot();
			robot4.setRobotName("player");
			robot4.setRobotType("electronic");
			robot5=new Robot();
			robot5.setRobotName("babySaver4");
			robot5.setRobotType("electronic");
			String i= (String) session.save(robot1);
			String i2=(String) session.save(robot2);
			String i3=(String) session.save(robot3);
			String i4=(String) session.save(robot4);
			String i5=(String) session.save(robot5);
			System.out.println("RobotTest.main()..."+i);
			System.out.println("RobotTest.main()..."+i2);
			System.out.println("RobotTest.main()..."+i3);
			System.out.println("RobotTest.main()..."+i4);
			System.out.println("RobotTest.main()..."+i5);
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				if(tx!=null) {
					tx.commit();
				}else {
					tx.rollback();
				}
			}if(session!=null) {
				session.close();
			}
			if(factory!=null) {
				HibernateSessionFactroy.closeFactroy();
			}
		}

	}

}
