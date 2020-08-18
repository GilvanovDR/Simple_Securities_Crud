- информация о ценных бумагах (securities_*.xml)
    http://iss.moex.com/iss/securities.xml;
- история торгов за произвольную дату (history_*.xml)
    http://iss.moex.com/iss/history/engines/stock/markets/shares/boards/tqbr/securities.xml?date=2013-12-20.


Функционал:
1. Импорт объектов из приложенных файлов (securities_*.xml, history_*.xml);
2. CREATE/UPDATE/DELETE(securities,history);
3. При ручном сохранении ценной бумаги проводить валидацию передаваемых
данных в поле name - только кириллица, цифры и пробел;
4. getAll вывод таблицы с данными из тегов:
 secid
 regnumber
 name
 emitent_title
 tradedate
 numtrades
 open
 close
SortBy emitent_title и tradedate;

5. Выбранную архитектуру решения и инструкцию по запуску приложения
описать в Readme файле /Start from Heroku/
***
1. Реализовать хранение и работу с данными в БД;
2. Реализовать MVC приложение, позволяющее через интерфейс
импортировать файлы и работать с таблицей п.4 и CRUD операциями. Не

стоит акцентировать внимание на ux/ui, нам интересно посмотреть на ваш
навык работы с html/js;
3. Доработать импорт данных: при импорте истории по отсутствующей ценной
бумаге выполнять rest запрос к API биржи (роут метода
http://iss.moex.com/iss/securities.xml?q=SEARCH_STRING). Обратить
внимание на оптимизацию обращений;
4. Реализовать фоновое выполнение парсинга данных по расписанию.