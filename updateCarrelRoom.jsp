<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/adminHeader.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Carrel Room Request</title>

 <style>
.pagination {
  position: absolute;
  right: 200px;
}

#rcorners {
  border: 2px solid #2c3e50;
  width: 1000px;
  height: 150px;  
  margin-left:17%;
  margin-right:20%;
}

h3{
margin-top: 50px;
margin-bottom: 20px;
margin-left: 17%;
}

</style>

</head>
<body>
<h3>Carrel Room Booking List</h3>
		<table class="table table-hover" id="rcorners">
		  <tbody>
		  
		  <tr class="table-primary">
		       <th>Matric No</th>
		       <th>Room No.</th>
		       <th>Date</th>
		       <th>Slot</th>
		       <th>Availability</th>
		       <th>Status</th>
		       <th>Actions</th>
		        </tr>
		  
		  <tr>
		      <td>B21EC3005</td>
		      <td>411</td> 
		      <td>27/12/2022</td>
		      <td>2.00 - 4.00 PM</td>
		      <td><span class="badge bg-success">AVAILABLE</span></td>
		      <td><span class="badge bg-warning">PENDING</span></td>
		      <td><a href="changeStatusCR.jsp"><img src="img/update.png" width="20" height="20"></a>
		      <a href="#"><img src="img/delete.png" width="20" height="20"></a>
		      </td>
		    </tr>
		    <tr>
		      <td>A21EC3072</td>
		      <td>413</td>
		      <td>27/12/2022</td>
		      <td>2.00 - 4.00 PM</td>
		      <td><span class="badge bg-danger">BOOKED</span></td>
		      <td><span class="badge bg-success">APPROVED</span></td>
		      <td><a href="changeStatusCR.jsp"><img src="img/update.png" width="20" height="20"></a>
		      <a href="#"><img src="img/delete.png" width="20" height="20"></a>
		      </td>
		    </tr>
		    <tr>
		      <td>A21EC3008</td>
		      <td>401</td>
		      <td>27/12/2022</td>
		      <td>2.00 - 4.00 PM</td>
		      <td><span class="badge bg-success">AVAILABLE</span></td>
		      <td><span class="badge bg-warning">PENDING</span></td>
		      <td><a href="changeStatusCR.jsp"><img src="img/update.png" width="20" height="20"></a>
		      <a href="#"><img src="img/delete.png" width="20" height="20"></a>
		      </td>
		    </tr>
		  </tbody>
		</table>

<div class="center">
  <ul class="pagination">
    <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
    <li class="page-item active">
      <a class="page-link" href="#">1</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
    </li>
  </ul>
</div> 

</body>
</html>