-- ПК не в этапах
DROP TEMPORARY TABLE pc_not_upgrade;

CREATE TEMPORARY TABLE pc_not_upgrade
SELECT * FROM icardsdb.equipments WHERE
device = 'ПК' AND upgrade LIKE 'Нет';

SELECT * FROM pc_not_upgrade ORDER BY fio;