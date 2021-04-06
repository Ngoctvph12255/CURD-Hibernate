<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>JSP Page</title>
</head>
<body>
	<div class="container" style="margin-top: 10px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">				
				<h2>Register</h2>
				<form action="" method="post">
					<div class="form-group">
						<label>UserName</label> 
						<input type="text" class="form-control" placeholder="Enter UserName">
					</div>				
					<div class="form-group">
						<label>Age</label> 
						<input type="number" class="form-control" placeholder="Enter age" value="0">
					</div>
					<div class="form-group">
						<label for="">Country</label>
						<select class="form-control">
						  <option>Viet Nam</option>
						  <option>My</option>
						  <option>Nhat Ban</option>
						  <option>Anh</option>
						</select>
					  </div>
					<div class="form-group">
						<label>Gender</label>
						<div class="radio">
							<!--value = 1 => Nam| 0 =>Nu -->
							<label class="checkbox-inline">
							<input type="radio" value="1">Male</label> 
							<label class="checkbox-inline">
							<input type="radio" checked="checked" value="0">Female</label>
						</div>
					</div>
					<div class="form-group">
						<label>Hobby</label>
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="checkbox">
						  <label class="form-check-label">Music</label>
						  <input class="form-check-input" type="checkbox">
						  <label class="form-check-label">Reading</label>
						  <input class="form-check-input" type="checkbox">
						  <label class="form-check-label">Shopping</label>					
						</div>						
					</div>						
					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
					<a href="./UserServlet?action?List" class="btn btn-primary">Display Users</a>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
