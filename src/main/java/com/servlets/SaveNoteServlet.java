package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entites.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNoteServlet() {
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// title and content from form
		try {
			String title = request.getParameter("title").trim();
			String content = request.getParameter("content").trim();

			// Creating entity Object
			Note noteData = new Note(title, content, new Date());
			 System.out.println(noteData.toString());
			
			// Creation of Session
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(noteData);
			tx.commit();
			session.close();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.print("<hi style='text-align:center;'> Note is added succesfully <br></h1>");
			out.print("<hi> <a href='all_notes.jsp'>View all notes </a></h1>");
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
