<?php
/**
 * Created by PhpStorm.
 * User: Maxim
 * Date: 06.12.2017
 * Time: 14:27
 */

if($_SERVER["REQUEST_METHOD"]=="POST"){
    include 'connection.php';
    showNotes();
}

function showNotes()
{
    global $connect;

    $query = "SELECT * FROM todo_list";

    $result = mysqli_query($connect, $query);

    $number_of_rows = mysqli_num_rows($result);

    $temp_array = array();

    if ($number_of_rows > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $temp_array[] = $row;
        }
    }

    header('Content-Type: application/json');
    echo json_encode(array("notes" => $temp_array));
    mysqli_close($connect);
}

?>