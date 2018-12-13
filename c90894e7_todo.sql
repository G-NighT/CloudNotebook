-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Дек 07 2017 г., 15:08
-- Версия сервера: 5.7.19-17-beget-5.7.19-17-1-log
-- Версия PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `c90894e7_todo`
--

-- --------------------------------------------------------

--
-- Структура таблицы `todo_list`
--
-- Создание: Дек 06 2017 г., 09:20
-- Последнее обновление: Дек 07 2017 г., 06:29
--

DROP TABLE IF EXISTS `todo_list`;
CREATE TABLE `todo_list` (
  `id` int(30) NOT NULL,
  `note` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `datetime` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `todo_list`
--

INSERT INTO `todo_list` (`id`, `note`, `description`, `datetime`) VALUES
(2, 'Rechko', '5 and 6', '2017-11-22 12:38:04'),
(6, 'Pimonov', '3 and 4', '2017-12-06 12:51:40'),
(24, 'lazeeva', 'Dodelat laby', '2017-12-06 13:11:49'),
(41, 'Tailakova', 'UML diagrammi', '2017-12-06 13:31:02'),
(54, 'Doroganov', 'Sdat labi', '2017-12-07 05:07:52'),
(59, 'Podarki', 'Kupit na NG', '2017-12-07 08:39:44');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `todo_list`
--
ALTER TABLE `todo_list`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `todo_list`
--
ALTER TABLE `todo_list`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
