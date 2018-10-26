<?php

	require_once('dbConnect.php');

	if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
		$id = $_POST['id'];

		$sql = "SELECT * from information where ID = $id";
		$result = mysqli_query($dbconnect,$sql);
		
		$s = '{"result":[';
		while($row = mysqli_fetch_assoc($result))
		{
		 $s.= json_encode($row).",";
		}
		$s = substr($s,0,-1);
		$s.="]}";

		echo $s;
	}
?>