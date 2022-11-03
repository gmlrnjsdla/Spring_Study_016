package com.heekwoncompany.study016;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class TicketDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

	public TicketDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void buyTicket(final TicketDto dto) {
		
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO card(consumerid,amount) VALUES(?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO ticket(consumerid,countnum) VALUES(?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
	}
	
}
