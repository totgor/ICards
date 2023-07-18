-- ПК в этапах
DROP TEMPORARY TABLE pc_upgrade;

CREATE TEMPORARY TABLE pc_upgrade
SELECT * FROM icardsdb.equipments WHERE
device = 'ПК' AND upgrade NOT LIKE 'Нет';

SELECT * FROM pc_upgrade ORDER BY fio;