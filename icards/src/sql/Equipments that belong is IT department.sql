
SELECT fio, name
FROM icardsdb.equipments
WHERE 
    fio LIKE '%Фомичев%'

    OR name LIKE '%системн%блок%' AND name NOT LIKE '%подставка%под%системный%блок%'  
                               AND name NOT LIKE '%подставка%для%системн%блока%' 

    OR  name LIKE '%ПК%' AND name NOT LIKE '%подставка%под%ПК%' 
                         AND name NOT LIKE '%блок%питания%' 
                         AND name NOT LIKE '%ППК%' 
                         AND name NOT LIKE '%ПКД%'         
                         AND name NOT LIKE '%скрепки%' 
                         AND name NOT LIKE '%сигнализац%'

    OR name LIKE '%ноутбук%'

    OR name LIKE '%монитор%' AND name NOT LIKE '%подставка%под%монитор%' 
                             AND name NOT LIKE '%мониторинг%' 
                             AND name NOT LIKE '%огнетушитель%' 
                             AND name NOT LIKE '%энергомонитор%'
                             AND name NOT LIKE '%видеомонитор%'
                             AND name NOT LIKE '%видеомагнитофон%'

    OR name LIKE '%кронштейн%' AND name NOT LIKE '%для%светильников%' 
                               AND name NOT LIKE '%освещения%' 
                               AND name NOT LIKE '%огнетушитель%' 
                               AND name NOT LIKE '%под ТВ%'

    OR name LIKE '%телефон%'

    OR name LIKE '%ЭВМ%' AND name NOT LIKE '%техлитература%'
    
    OR name LIKE '%компьютер%' AND name NOT LIKE '%стол%компьютерный%' 
                               AND name NOT LIKE '%компьютер%промышленный%' 
                               AND name NOT LIKE '%компьютер%встраиваемый%' 
                               AND name NOT LIKE '%RISC%'
    
    OR name LIKE '%жесткий%диск%'

    OR name LIKE '%МФУ%'

    OR name LIKE '%принтер%' AND name NOT LIKE '%тумба%' 
                             AND name NOT LIKE '%промышленный%' 
                             AND name NOT LIKE '%трафаретный%' 
                             AND name NOT LIKE '%ленточный%' 
                             AND name NOT LIKE '%маркировочный%'

    OR name LIKE '%клавиатура%'    

    OR name LIKE '%мышь%'

    OR name LIKE '%принтсервер%'

    OR name LIKE '%внешний АКБ%'

    OR name LIKE '%ультрабук%'

    OR name LIKE '%локальная%сеть%'

    OR name LIKE '%UPS%' AND name NOT LIKE '%KRUPS%'

    OR name LIKE '%Источник%бесперебойного%питания%'

    OR name LIKE '%видеокарта%'

    OR name LIKE '%внешний%накопитель%'

    OR name LIKE '%проектор%' AND name NOT LIKE '%стойка%для%проектора%'

    OR name LIKE '%точка%доступа%'

    OR name LIKE '%сервер%' AND name NOT LIKE '%промышленный%' 
                            AND name NOT LIKE '%сервер%времени%' 
                            AND name NOT LIKE '%серверная%стойка%' 
                            AND name NOT LIKE '%серверный%шкаф%'     

    OR name LIKE '%веб%камера%'

    OR name LIKE '%гарнитура%' AND name NOT LIKE '%ХTR446%'

    OR name LIKE '%дисковод%'

    OR name LIKE '%Ippon%'

    OR name LIKE '%колонки%'

    OR name LIKE '%колонка%' AND name NOT LIKE '%колонка%для%документов%'

    OR name LIKE '%коммутатор%'

    OR name LIKE '%межсетевой%экран%'

    OR name LIKE '%микрофон%' AND name NOT LIKE '%TourAudio%WT-300T%'

    OR name LIKE '%мини%АТС%'

    OR name LIKE '%диктофон%'

    OR name LIKE '%накопитель%' AND name NOT LIKE '%водонагреватель%'

    OR name LIKE '%память%'

    OR name LIKE '%видеокамера%Hikvision%'

    OR name LIKE '%видеокамера%Samsung HMX-H405%'

    OR name LIKE '%плеер%'

    OR name LIKE '%проигрыватель%Defender%'

    OR name LIKE '%комплект%беспроводной%'    

    OR name LIKE '%маршрутизатор%'

    OR name LIKE '%модем%' AND name NOT LIKE '%GSM%'

    OR name LIKE '%сетевое%хранилище%'

    OR name LIKE '%флэш%' OR name LIKE '%флеш%'

ORDER BY name;