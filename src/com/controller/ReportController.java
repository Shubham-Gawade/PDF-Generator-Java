package com.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.dao.ReportDao;
import com.dao.ReportDao;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class ReportController
 */
@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String s1=request.getParameter("start_date");
		String s2=request.getParameter("end_date");
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection connection=null;;
		try {
			String file="C:\\Users\\Shubham Gawade\\Desktop\\report.txt";
			Document document=new Document();
			PdfWriter.getInstance(document, new  FileOutputStream(file));
			document.open();
			
			ReportDao d=new ReportDao();
			connection=d.getConnection();
			
			String query="select a.Branch_name,l.Acc_no from Account a,LoginInfo1 l where a.Customer_id=l.Customer_id";
			try {
				ps=connection.prepareStatement(query);
				rs=ps.executeQuery();
				
				while(rs.next())
				{
						Paragraph para=new Paragraph(rs.getString("Branch_name")+" "+rs.getString("Acc_no"));
						document.add(para);
						document.add(new Paragraph(" "));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			document.close();
			System.out.println("Finished....");
			PrintWriter pw=response.getWriter();
			pw.println("Downloaded successfully");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
	
	}
	}

