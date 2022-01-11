package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entites.Note;
import com.helper.FactoryProvider;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			String title = request.getParameter("title").trim();
			String content = request.getParameter("content").trim();
			int noteId = Integer.parseInt(request.getParameter("note_id"));
			
			System.out.println(title);
			System.out.println(content);
			System.out.println(noteId);
			
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			Note note = (Note) session.get(Note.class, noteId);
			
			note.setContent(content);
			note.setTitle(title);
			note.setAddedDate(new Date());		
			
			tx.commit();
			session.close();
			
			response.sendRedirect("all_notes.jsp");
			
		} catch (Exception e) {
			System.out.println("hiiiii");
			System.out.println(e);
		}

		
	}

}
