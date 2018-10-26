<?php
include ("DatabaseConfig.php");

	$dbconnect = mysqli_connect("localhost","root","","medicine");
	if(mysqli_connect_errno()) {
		echo "Connection failed : ".mysqli_connect_error();
	}
?>