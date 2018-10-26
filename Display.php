<?php
include ("dbconnect.php");

// Create connection
//$conn = new mysqli($HostName, $HostUser, $HostPass, $DatabaseName);

//if ($conn->connect_error) {
 
 //die("Connection failed: " . $conn->connect_error);
//} 
$sql = "SELECT * FROM information ORDER BY Name";

$result = mysqli_query($dbconnect,$sql);

if ($result->num_rows >0) {
 
 
 while($row[] = $result->fetch_assoc()) {
 
 $tem = $row;
 
 $json = json_encode($tem);
 
 
 }
 
} else {
 echo "No Results Found.";
}
 echo $json;
?>