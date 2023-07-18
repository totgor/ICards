
-- SELECT inventory_number, name, fio
-- FROM icardsdb.equipments
-- WHERE fio LIKE (SELECT DISTINCT fio FROM icardsdb.equipments);

-- SELECT DISTINCT fio FROM icardsdb.equipments;


-- SELECT department, inventory_number, name, fio
-- FROM icardsdb.equipments
-- WHERE    

--     name LIKE '%системн%блок%' AND name NOT LIKE '%подставка%под%системный%блок%'  
--                                AND name NOT LIKE '%подставка%для%системн%блока%' 

--     OR  name LIKE '%ПК%' AND name NOT LIKE '%подставка%под%ПК%' 
--                          AND name NOT LIKE '%блок%питания%' 
--                          AND name NOT LIKE '%ППК%' 
--                          AND name NOT LIKE '%ПКД%'         
--                          AND name NOT LIKE '%скрепки%' 
--                          AND name NOT LIKE '%сигнализац%'

--     OR name LIKE '%ноутбук%'   

--     OR name LIKE '%ЭВМ%' AND name NOT LIKE '%техлитература%'
    
--     OR name LIKE '%компьютер%' AND name NOT LIKE '%стол%компьютерный%' 
--                                AND name NOT LIKE '%компьютер%промышленный%' 
--                                AND name NOT LIKE '%компьютер%встраиваемый%' 
--                                AND name NOT LIKE '%RISC%'
    

--     OR name LIKE '%ультрабук%'

--     AND CONVERT(SUBSTRING(inventory_number, 2, 2), UNSIGNED) > 14

-- ORDER BY fio;
-- CONVERT(SUBSTRING(inventory_number, 2, 2), UNSIGNED) > 14 
-- SELECT department, inventory_number, name, fio
SELECT department, inventory_number, name, fio
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
