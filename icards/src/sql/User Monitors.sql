-- 19 мониторы у пользователей

DROP TEMPORARY TABLE user_monitors IF NOT EXISTS(user_monitors);

CREATE TEMPORARY TABLE user_monitors
SELECT department, inventory_number, name, fio, upgrade, device
FROM icardsdb.equipments
WHERE    
        fio NOT LIKE '%фомичев%евгений%'
         AND name LIKE '%монитор%' 
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
         AND name NOT LIKE '%кронштейн%';

SELECT * FROM user_monitors ORDER BY fio;