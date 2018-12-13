<?php
/**
 * Created by PhpStorm.
 * User: Maxim
 * Date: 06.12.2017
 * Time: 14:20
 */

if($_SERVER["REQUEST_METHOD"]=="POST"){
    require 'connection.php';
    createNote();
}

function createNote(){
    global $connect;

    $note = $_POST["note"];
    $description = $_POST["description"];
    $datetime = date("Y-m-d H:i:s");

    $query = "INSERT INTO todo_list(note,description,datetime) VALUES ('$note','$description','$datetime');";

    mysqli_query($connect,$query) or die (mysqli_error($connect));
    mysqli_close($connect);
}

?>