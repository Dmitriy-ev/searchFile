# searchFile
1. Имеется корневая папка. В этой папке могут находиться текстовые
файлы, а также другие папки. В других папках также могут находится
текстовые файлы и папки (уровень вложенности может оказаться любым).
Найти все текстовые файлы, отсортировать их по имени и склеить
содержимое в один текстовый файл.
Поиск файлов осуществляется через рекурсивный вызов метода. Все данный из отсортированных файлов заносятся в файл file.txt