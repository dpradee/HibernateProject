package com.hilo.custom.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRobotIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor impl, Object entity) throws HibernateException {
		Connection con =null;
		Statement stmt=null;
		ResultSet rst=null;
		String id=null;
		int i=0;
		String sql="select nextval('robot_seq')";
		try {
			con= impl.connection();
			stmt=con.createStatement();
			rst=stmt.executeQuery(sql);
			while(rst.next())
			 i=rst.getInt(1);
			if(i<=9) {
				id="roo"+i;
			}else if(i<=99) {
				id="ro"+i;
			}else {
				id="r+"+i;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
				try {
					if(stmt!=null) {
					stmt.close();
					}
					if(rst!=null) {
						rst.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		return id;
	}

}
