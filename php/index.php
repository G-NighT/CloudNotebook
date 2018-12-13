<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ToDo</title>
    </head>
    <body>
		<form method="post" action="showNotes.php">
			<h2>Отображение заметок
			<input type="submit" value="Выполнить"/></h2>
		</form>

        <form method="post" action="insertNote.php">
            <h2>Добавление заметки</h2>
            <p>Заметка: <input type="text" name="note" /></p>
            <p>Описание: <input type="text" name="description" /></p>
            <p><input type="submit" value="Выполнить"/></p>
        </form>

        <form method="post" action="deleteNote.php">
            <h2>Удаление заметки</h2>
            По ID: <input type="text" name="id" />
            <input type="submit" value="Выполнить"/>
        </form>

    </body>
</html>
