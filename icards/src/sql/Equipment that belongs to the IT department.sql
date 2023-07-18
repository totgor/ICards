#SELECT * FROM icardsdb.equipments;

SELECT fio, name
FROM icardsdb.equipments
WHERE name LIKE '%ПК%' AND name NOT LIKE '%подставка%под%ПК%'
ORDER BY fio;