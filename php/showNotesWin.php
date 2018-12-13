<?php
/**
 * Created by PhpStorm.
 * User: Maxim
 * Date: 06.12.2017
 * Time: 14:27
 */

    define("hostname","localhost");
    define("databaseName","c90894e7_todo");
    define("user","c90894e7_todo");
    define("password", "c90894e7");
	
	$db = mysql_connect(hostname,user,password) or die("Ошибка подключения к базе данных");
	$db = mysql_select_db(databaseName, $db) or die("Ошибка в выборе БД");
	
	$result = mysql_query("SELECT * FROM todo_list");
	
	echo '{"notes":[';
	while($mass = mysql_fetch_array($result)){ 
	    echo '{"id":"'.$mass['id'].'","note":"'.$mass['note'].'","description":"'.$mass['description'].'","datetime":"'.$mass['datetime'].'"},';
	  }
	echo ']}';
?>