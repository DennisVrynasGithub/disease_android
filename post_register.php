 <?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "symptomsdisease";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
//Give values
$user_name = $_POST["user_name"];
$user_password = $_POST["user_password"];
$user_email = $_POST["user_email"];
$user_age = $_POST["user_age"];
$user_country = $_POST["user_country"];
$user_gender = $_POST["user_gender"];
	
$sql = "INSERT INTO login (user_name, user_password, user_email, user_age, user_country, user_gender)
VALUES ('$user_name', '$user_password', '$user_email', '$user_age', '$user_country', '$user_gender')";

if (mysqli_query($conn, $sql)) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>