

 
# Повторяющиеся инв. номера  
SELECT inventory_number, COUNT(inventory_number) AS count
FROM icardsdb.equipments
GROUP BY inventory_number
HAVING COUNT(inventory_number) > 1
ORDER BY inventory_number;


 
# Всего записей в таблице 8289
SELECT count(*)
FROM icardsdb.equipments;


# Всего "уникальныйх - не повторяющихся" записей inventory_number, name, fio в таблице 8286
SELECT count(DISTINCT inventory_number), count(DISTINCT name), count(DISTINCT fio)
FROM icardsdb.equipments;

# Повторяющиеся инв. номера
# 131 системных блоковa
# 41 подставок
SELECT fio, name
FROM icardsdb.equipments
WHERE name NOT LIKE '%системный блок%' #OR NOT LIKE '%подставка под системный блок%' #AND NOT LIKE '%подставка%' #OR '%ноутбук%' OR '%ультрабук%' 
ORDER BY fio;
