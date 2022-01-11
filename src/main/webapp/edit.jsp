<%@page import="com.entites.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>


<div class="container">
		<%@include file="navbar.jsp"%>
		<h1>Edit your note</h1>
		<br>
		
		<%
		int noteId = Integer.parseInt(request.getParameter("noteId"));
		Session s = FactoryProvider.getFactory().openSession();
		Note note = (Note) s.get(Note.class, noteId);
		%>
		
		<form action="UpdateServlet" method="post">
			<div class="mb-3">
			<input type="hidden" name="note_id" value="<%=noteId%>"/>
				<label for="title" class="form-label">Note title</label> 
				<input 
				name="title"
				required
				type="text" 
				class="form-control"
				id="title"
				placeholder="Enter here" 
				aria-describedby="emailHelp"
				value="<%=note.getTitle()%>">
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Note Content</label>
				<textarea 
				name="content"
				required
				id="content" 
				placeholder="Enter your content here"
				class="form-control"
				style = "height:250px;"><%=note.getContent()%>
				</textarea>
			</div>
			
			<div class="container text-center">
			<button type="submit" class="btn btn-success">Save your note</button>
			</div>
			
		</form>
</div>
</body>
</html>