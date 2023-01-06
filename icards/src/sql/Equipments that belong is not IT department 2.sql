
SELECT department, inventory_number, name, fio
FROM icardsdb.equipments
WHERE 
    fio NOT LIKE '%фомичев%евгений%'

    AND name NOT LIKE '%системн%блок%' OR name LIKE '%подставка%под%системный%блок%'  
                               OR name LIKE '%подставка%для%системн%блока%' 

    AND  name NOT  LIKE '%ПК%' AND name NOT LIKE '%подставка%под%ПК%' 
                         AND name NOT LIKE '%блок%питания%' 
                         AND name NOT LIKE '%ППК%' 
                         AND name NOT LIKE '%ПКД%'         
                         AND name NOT LIKE '%скрепки%' 
                         AND name NOT LIKE '%сигнализац%'

    AND name NOT LIKE '%ноутбук%'

    AND name NOT LIKE '%монитор%' AND name NOT LIKE '%подставка%под%монитор%' 
                             AND name NOT LIKE '%мониторинг%' 
                             AND name NOT LIKE '%огнетушитель%' 
                             AND name NOT LIKE '%энергомонитор%'
                             AND name NOT LIKE '%видеомонитор%'
                             AND name NOT LIKE '%видеомагнитофон%'

    AND name NOT LIKE '%кронштейн%' AND name NOT LIKE '%для%светильников%' 
                               AND name NOT LIKE '%освещения%' 
                               AND name NOT LIKE '%огнетушитель%' 
                               AND name NOT LIKE '%под ТВ%'

    AND name NOT LIKE '%телефон%'

    AND name NOT LIKE '%ЭВМ%' AND name NOT LIKE '%техлитература%'
    
    AND name NOT LIKE '%компьютер%' AND name NOT LIKE '%стол%компьютерный%' 
                               AND name NOT LIKE '%компьютер%промышленный%' 
                               AND name NOT LIKE '%компьютер%встраиваемый%' 
                               AND name NOT LIKE '%RISC%'
    
    AND name NOT LIKE '%жесткий%диск%'

    AND name NOT LIKE '%МФУ%'

    AND name NOT LIKE '%принтер%' AND name NOT LIKE '%тумба%' 
                             AND name NOT LIKE '%промышленный%' 
                             AND name NOT LIKE '%трафаретный%' 
                             AND name NOT LIKE '%ленточный%' 
                             AND name NOT LIKE '%маркировочный%'

    AND name NOT LIKE '%клавиатура%'    

    AND name NOT LIKE '%мышь%'

    AND name NOT LIKE '%принтсервер%'

    AND name NOT LIKE '%внешний АКБ%'

    AND name NOT LIKE '%ультрабук%'

    AND name NOT LIKE '%локальная%сеть%'

    AND name NOT LIKE '%UPS%' AND name NOT LIKE '%KRUPS%'

    AND name NOT LIKE '%Источник%бесперебойного%питания%'

    AND name NOT LIKE '%видеокарта%'

    AND name NOT LIKE '%внешний%накопитель%'

    AND name NOT LIKE '%проектор%' AND name NOT LIKE '%стойка%для%проектора%'

    AND name NOT LIKE '%точка%доступа%'

    AND name NOT LIKE '%сервер%' AND name NOT LIKE '%промышленный%' 
                            AND name NOT LIKE '%сервер%времени%' 
                            AND name NOT LIKE '%серверная%стойка%' 
                            AND name NOT LIKE '%серверный%шкаф%'     

    AND name NOT LIKE '%веб%камера%'

    AND name NOT LIKE '%гарнитура%' AND name NOT LIKE '%ХTR446%'

    AND name NOT LIKE '%дисковод%'

    AND name NOT LIKE '%Ippon%'

    AND name NOT LIKE '%колонки%'

    AND name NOT LIKE '%колонка%' AND name NOT LIKE '%колонка%для%документов%'

    AND name NOT LIKE '%коммутатор%'

    AND name NOT LIKE '%межсетевой%экран%'

    AND name NOT LIKE '%микрофон%' AND name NOT LIKE '%TourAudio%WT-300T%'

    AND name NOT LIKE '%мини%АТС%'

    AND name NOT LIKE '%диктофон%'

    AND name NOT LIKE '%накопитель%' AND name NOT LIKE '%водонагреватель%'

    AND name NOT LIKE '%память%'

    AND name NOT LIKE '%видеокамера%Hikvision%'

    AND name NOT LIKE '%видеокамера%Samsung HMX-H405%'

    AND name NOT LIKE '%плеер%'

    AND name NOT LIKE '%проигрыватель%Defender%'

    AND name NOT LIKE '%комплект%беспроводной%'    

    AND name NOT LIKE '%маршрутизатор%'

    AND name NOT LIKE '%модем%' AND name NOT LIKE '%GSM%'

    AND name NOT LIKE '%сетевое%хранилище%'

    AND name NOT LIKE '%флэш%' OR name LIKE '%флеш%'

ORDER BY fio;