<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/adminHeader.jsp"%>    
<!-- Code by Haidah-->

<title>Update Book</title>

<style>

h2{
  padding: 20px;
  margin-left: 30px;
  margin-top: 10px;
}

.place{
  margin-left: 30px;
  padding: 15px;
  
img{
  margin-left: 700px;
  margin-right: auto;
}

</style>


<h2>Update Book</h2>

<div class="row">
	<div class="col-8">
			<div class="card border-primary mb-3 place" style="max-width: 50rem;">
		
		<div class="card-body" style="margin-top:0px;">
		
		<form>
		  <fieldset>
		  <div class="form-group">
		     <label for="formFile" class="form-label mt-4">Images Of Books</label>
		      <input class="form-control" type="file" id="formFile">
		    </div><br>
		    <div class="form-group">
		      <input type="text" class="form-control" id="isbnNum" placeholder="ISBN Number xxxxx">
		    </div><br>
		    <div class="form-group">
		      <input type="text" class="form-control" id="tittle" placeholder="Tittle">
		    </div><br>
		    <div class="form-group">
		      <input type="text" class="form-control" id="author" placeholder="Author">
		    </div><br>
		    <div class="form-group">
		      <input type="date" class="form-control" id="date" placeholder="Date">
		    </div><br>
		     <div class="form-group">
		      <input type="text" class="form-control" id="description" placeholder="Description">
		    </div><br>
		   
		    <a class="btn btn-primary" href="#">Update Details</a>
		    <a class="btn btn-danger" href="#">Delete Book</a>
		  </fieldset>
		 
		</form>
		</div>
		</div>
	</div>

		<div class="col-4" >
		<div class="center">
			<img id="center" src="img/book.jpg" width="250" height="250"/>
		</div>
			
		</div>

</div>

	