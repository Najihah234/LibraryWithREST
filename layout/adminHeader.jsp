<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/_bootswatch.scss">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/_variables.scss">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#"><img src="img\UTM-LOGO.png" style="width:50px;height:50px;"></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav me-auto">
            <li class="nav-item">
                <a class="nav-link" href="adminDash">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="materialAdmin">Resource</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="materialRequest">Book/Material Request</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="finesList">Fine Payment</a>
              </li>
              
              
              <li class="nav-item">
                <a class="nav-link" href="bookReport">Statistics</a>
              </li>
        
            </ul>
            
              <a class="btn btn-secondary my-2 my-sm-0" href="index.jsp">Logout</a>
            
          </div>
        </div>
      </nav>


<body>

</body>
</html>