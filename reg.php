<?php
	include("dbconnect.php");

if($_SERVER['REQUEST_METHOD'] == 'POST'){

	$mail=$_POST['email'];
	$pass=$_POST['password'];
	$uname=$_POST['username'];


	$adding="INSERT INTO users(ID,User_Name,Password,Email) VALUES(NULL,'$mail','$uname','$mail');";

	if(mysqli_query($dbconnect,$adding)){
		echo "Successful";
	}
	else{
		echo "Error in inserting values";
	}
}

?>