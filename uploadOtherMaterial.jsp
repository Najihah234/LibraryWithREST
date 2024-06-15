<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/adminHeader.jsp"%>    
<!-- Code by Haidah-->

<title>Upload Material (PDF/WORD/OTHER)</title>

<style>

h2{
  padding: 20px;
  text-align:center;
  margin-top: 10px;
}

.center{
  margin: auto;
  padding: 15px;
  
}

</style>

		<h2>Upload Material
		  <div class="btn-group" role="group" aria-label="Basic example">
		  <a class="btn btn-outline-primary" href="uploadMaterial.jsp">e-Book</a>
		  <a class="btn btn-outline-primary" href="uploadOtherMaterial.jsp">PDF/WORD/OTHER</a>
		</div>
	  </h2>

<div class="card border-primary mb-3 center" style="max-width: 50rem;">
	<div class="card-header" style="text-align:center; font-size: 20px;">PDF/WORD/OTHER</div>

<div class="card-body" style="margin-top:0px;">
<form>
  <fieldset>
    <div class="form-group">
      <input class="form-control" type="file" id="formFile">
    </div><br>
    <div class="form-group">
      <input type="text" class="form-control" id="materialCode" placeholder="Input Material Code">
    </div><br>
    <div class="form-group">
      <input type="text" class="form-control" id="tittle" placeholder="Input Tittle">
    </div><br>
    <div class="form-group">
      <input type="text" class="form-control" id="author" placeholder="Input Author">
    </div><br>
    <div class="form-group">
      <input type="date" class="form-control" id="date" placeholder="Date">
    </div><br>
   
    <a class="btn btn-primary" href="#">Submit</a>
  </fieldset>
 
</form>

</div>
</div>