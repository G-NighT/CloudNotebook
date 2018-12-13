<?php
/**
 * Created by PhpStorm.
 * User: Maxim
 * Date: 06.12.2017
 * Time: 14:20
 */

if($_SERVER["REQUEST_METHOD"]=="POST"){
    require 'connection.php';
    deleteNote();
}

function deleteNote(){
    global $connect;

    $id = $_POST['id'];

    $query = "DELETE FROM `todo_list` WHERE id=".$id;

    mysqli_query($connect,$query) or die (mysqli_error($connect));
    mysqli_close($connect);
}

?>