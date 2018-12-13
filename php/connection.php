<?php
/**
 * Created by PhpStorm.
 * User: Maxim
 * Date: 06.12.2017
 * Time: 14:17
 */

define("hostname","localhost");
define("databaseName","c90894e7_todo");
define("user","c90894e7_todo");
define("password", "c90894e7");

$connect = mysqli_connect(hostname,user,password,databaseName);

?>