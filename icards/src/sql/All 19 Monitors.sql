-- все 19 мониторы 

DROP TEMPORARY TABLE IF EXISTS all_monitors;

CREATE TEMPORARY TABLE all_monitors
SELECT department, inventory_number, name, fio, upgrade, device
FROM icardsdb.equipments
WHERE            
         name LIKE '%монитор%' 
         AND name NOT LIKE '%23,8%'
         AND name NOT LIKE '%23.8%'
         AND name NOT LIKE '%23.6%'
         AND name NOT LIKE '%23,6%'
         AND name NOT LIKE '%21,5%'
         AND name NOT LIKE '%21.5%'
         AND name NOT LIKE '%24"%'
         AND name NOT LIKE '%27"%'
         AND name NOT LIKE '%22"%'
         AND name NOT LIKE '%27\'%'
         AND name NOT LIKE '%24\'%'
         AND name NOT LIKE '%74,5"%'
         AND name NOT LIKE '%VG24%'
         AND name NOT LIKE '%S24%'
         AND name NOT LIKE '%кронштейн%'
         AND name NOT LIKE '%S23A%'
         AND name NOT LIKE '%34"%'
         AND name NOT LIKE '%сенсор%'
         AND name NOT LIKE '%225%';


SELECT * FROM all_monitors ORDER BY fio;

SELECT * FROM icardsdb.equipments WHERE device = 'монитор';
