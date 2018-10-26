<?php
	include("dbconnect.php");
echo "2";

if($_SERVER['REQUEST_METHOD'] == 'POST'){
	$mail=$_POST['email'];
	$pass=$_POST['password'];
	$q="SELECT * FROM users WHERE Email='$mail' AND Password='$pass'";
	$p=mysqli_query($dbconnect,$q);
	$row=mysqli_num_rows($p);
	if($row == 1){	
			echo "Login Successful";
		}
		else{
				echo "Wrong";
		}

}
?>