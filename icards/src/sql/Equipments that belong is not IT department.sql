
SELECT fio, name
FROM icardsdb.equipments
WHERE 
    -- fio LIKE '%Фомичев%'

    

    -- OR name LIKE '%системн%блок%' AND name NOT LIKE '%подставка%под%системный%блок%'  
    --                            AND name NOT LIKE '%подставка%для%системн%блока%' 

    -- OR  name LIKE '%ПК%' AND name NOT LIKE '%подставка%под%ПК%' 
    --                      AND name NOT LIKE '%блок%питания%' 
    --                      AND name NOT LIKE '%ППК%' 
    --                      AND name NOT LIKE '%ПКД%'         
    --                      AND name NOT LIKE '%скрепки%' 
    --                      AND name NOT LIKE '%сигнализац%'

    -- OR name LIKE '%ноутбук%'

    -- OR name LIKE '%монитор%' AND name NOT LIKE '%подставка%под%монитор%' 
    --                          AND name NOT LIKE '%мониторинг%' 
    --                          AND name NOT LIKE '%огнетушитель%' 
    --                          AND name NOT LIKE '%энергомонитор%'
    --                          AND name NOT LIKE '%видеомонитор%'
    --                          AND name NOT LIKE '%видеомагнитофон%'

    -- OR name LIKE '%кронштейн%' AND name NOT LIKE '%для%светильников%' 
    --                            AND name NOT LIKE '%освещения%' 
    --                            AND name NOT LIKE '%огнетушитель%' 
    --                            AND name NOT LIKE '%под ТВ%'

    -- OR name LIKE '%телефон%'

    -- OR name LIKE '%ЭВМ%' AND name NOT LIKE '%техлитература%'
    
    -- OR name LIKE '%компьютер%' AND name NOT LIKE '%стол%компьютерный%' 
    --                            AND name NOT LIKE '%компьютер%промышленный%' 
    --                            AND name NOT LIKE '%компьютер%встраиваемый%' 
    --                            AND name NOT LIKE '%RISC%'
    
    -- OR name LIKE '%жесткий%диск%'

    -- OR name LIKE '%МФУ%'

    -- OR name LIKE '%принтер%' AND name NOT LIKE '%тумба%' 
    --                          AND name NOT LIKE '%промышленный%' 
    --                          AND name NOT LIKE '%трафаретный%' 
    --                          AND name NOT LIKE '%ленточный%' 
    --                          AND name NOT LIKE '%маркировочный%'

    -- OR name LIKE '%клавиатура%'    

    -- OR name LIKE '%мышь%'

    -- OR name LIKE '%принтсервер%'

    -- OR name LIKE '%внешний АКБ%'

    -- OR name LIKE '%ультрабук%'

    -- OR name LIKE '%локальная%сеть%'

    -- OR name LIKE '%UPS%' AND name NOT LIKE '%KRUPS%'

    -- OR name LIKE '%Источник%бесперебойного%питания%'

    -- OR name LIKE '%видеокарта%'

    -- OR name LIKE '%внешний%накопитель%'

    -- OR name LIKE '%проектор%' AND name NOT LIKE '%стойка%для%проектора%'

    -- OR name LIKE '%точка%доступа%'

    -- OR name LIKE '%сервер%' AND name NOT LIKE '%промышленный%' 
    --                         AND name NOT LIKE '%сервер%времени%' 
    --                         AND name NOT LIKE '%серверная%стойка%' 
    --                         AND name NOT LIKE '%серверный%шкаф%'     

    -- OR name LIKE '%веб%камера%'

    -- OR name LIKE '%гарнитура%' AND name NOT LIKE '%ХTR446%'

    -- OR name LIKE '%дисковод%'

    -- OR name LIKE '%Ippon%'

    -- OR name LIKE '%колонки%'

    -- OR name LIKE '%колонка%' AND name NOT LIKE '%колонка%для%документов%'

    -- OR name LIKE '%коммутатор%'

    -- OR name LIKE '%межсетевой%экран%'

    -- OR name LIKE '%микрофон%' AND name NOT LIKE '%TourAudio%WT-300T%'

    -- OR name LIKE '%мини%АТС%'

    -- OR name LIKE '%диктофон%'

    -- OR name LIKE '%накопитель%' AND name NOT LIKE '%водонагреватель%'

    -- OR name LIKE '%память%'

    -- OR name LIKE '%видеокамера%Hikvision%'

    -- OR name LIKE '%видеокамера%Samsung HMX-H405%'

    -- OR name LIKE '%плеер%'

    -- OR name LIKE '%проигрыватель%Defender%'

    -- OR name LIKE '%комплект%беспроводной%'    

    -- OR name LIKE '%маршрутизатор%'

    -- OR name LIKE '%модем%' AND name NOT LIKE '%GSM%'

    -- OR name LIKE '%сетевое%хранилище%'

    -- OR name LIKE '%флэш%' OR name LIKE '%флеш%'


    -- Отдельно работающие запросы
    -- fio LIKE '%Фомичев%'
    -- name LIKE '%системн%блок%' OR name LIKE '%ПК%'  AND name NOT LIKE '%подставка%под%системный%блок%' AND name NOT LIKE '%подставка%для%системн%блока%'
	-- name NOT LIKE '%подставка%под%ПК%' AND name NOT LIKE '%блок%питания%' AND name NOT LIKE '%ППК%' AND name NOT LIKE '%ПКД%' AND name NOT LIKE '%скрепки%' AND name NOT LIKE '%сигнализац%'
    -- name LIKE '%ноутбук%'
    -- name LIKE '%монитор%' AND name NOT LIKE '%подставка%под%монитор%' AND name NOT LIKE '%мониторинг%' AND name NOT LIKE '%огнетушитель%' AND name NOT LIKE '%энергомонитор%' AND name NOT LIKE '%видеомонитор%' AND name NOT LIKE '%видеомагнитофон%'
    -- name LIKE '%кронштейн%' AND name NOT LIKE '%для%светильников%' AND name NOT LIKE '%освещения%' AND name NOT LIKE '%огнетушитель%' AND name NOT LIKE '%под ТВ%'
    -- name LIKE '%телефон%'
    -- name LIKE '%ЭВМ%' AND name NOT LIKE '%техлитература%'
    -- name LIKE '%компьютер%' AND name NOT LIKE '%стол%компьютерный%' AND name NOT LIKE '%компьютер%промышленный%' AND name NOT LIKE '%компьютер%встраиваемый%' AND name NOT LIKE '%RISC%'
    -- name LIKE '%жесткий%диск%'
    -- name LIKE '%МФУ%'
    -- name LIKE '%принтер%' AND name NOT LIKE '%тумба%' AND name NOT LIKE '%промышленный%' AND name NOT LIKE '%трафаретный%' AND name NOT LIKE '%ленточный%' AND name NOT LIKE '%маркировочный%'
    -- name LIKE '%клавиатура%'    
    -- name LIKE '%мышь%'
    -- name LIKE '%принтсервер%'
    -- name LIKE '%внешний АКБ%'
    -- name LIKE '%ультрабук%'
    -- name LIKE '%локальная%сеть%'
    -- name LIKE '%UPS%' AND name NOT LIKE '%KRUPS%'
    -- name LIKE '%Источник%бесперебойного%питания%'
    -- name LIKE '%видеокарта%'
    -- name LIKE '%внешний%накопитель%'
    -- name LIKE '%проектор%' ANd name NOT LIKE '%стойка%для%проектора%'
    -- name LIKE '%точка%доступа%'
    -- name LIKE '%сервер%' AND name NOT LIKE '%промышленный%' AND name NOT LIKE '%сервер%времени%' AND name NOT LIKE '%серверная%стойка%' AND name NOT LIKE '%серверный%шкаф%'     
    -- name LIKE '%веб%камера%'
    -- name LIKE '%гарнитура%' AND name NOT LIKE '%ХTR446%'
    -- name LIKE '%дисковод%'
    -- name LIKE '%Ippon%'
    -- name LIKE '%колонки%'
    -- name LIKE '%колонка%' AND name NOT LIKE '%колонка%для%документов%'
    -- name LIKE '%коммутатор%'
    -- name LIKE '%межсетевой%экран%'
    -- name LIKE '%микрофон%' AND name NOT LIKE '%TourAudio%WT-300T%'
    -- name LIKE '%мини%АТС%'
    -- name LIKE '%диктофон%'
    -- name LIKE '%накопитель%' AND name NOT LIKE '%водонагреватель%'
    -- name LIKE '%память%'
    -- name LIKE '%видеокамера%Hikvision%'
    -- name LIKE '%видеокамера%Samsung HMX-H405%'
    -- name LIKE '%плеер%'
    -- name LIKE '%проигрыватель%Defender%'
    -- name LIKE '%комплект%беспроводной%'    
    -- name LIKE '%маршрутизатор%'
    -- name LIKE '%модем%' AND name NOT LIKE '%GSM%'
    -- name LIKE '%сетевое%хранилище%'
    -- name LIKE '%флэш%' OR name LIKE '%флеш%'
    




    -- Для того что бы убрать все то что проанализировнно из таблицы
    fio NOT LIKE '%Фомичев%'
    AND name NOT LIKE '%системн%блок%' AND name NOT LIKE '%подставка%под%системный%блок%' AND name NOT LIKE '%подставка%для%системн%блока%' 
	AND name NOT LIKE '%ПК%' AND name NOT LIKE '%подставка%под%ПК%' AND name NOT LIKE '%блок%питания%' AND name NOT LIKE '%ППК%' AND name NOT LIKE '%ПКД%' AND name NOT LIKE '%скрепки%' AND name NOT LIKE '%сигнализац%'
    AND name NOT LIKE '%ноутбук%'
    AND name NOT LIKE '%монитор%' AND name NOT LIKE '%подставка%под%монитор%' AND name NOT LIKE '%мониторинг%' AND name NOT LIKE '%огнетушитель%' AND name NOT LIKE '%энергомонитор%' AND name NOT LIKE '%видеомонитор%' AND name NOT LIKE '%видеомагнитофон%'
    AND name NOT LIKE '%кронштейн%' AND name NOT LIKE '%для%светильников%' AND name NOT LIKE '%освещения%' AND name NOT LIKE '%огнетушитель%' AND name NOT LIKE '%под ТВ%'
    AND name NOT LIKE '%телефон%'
    AND name NOT LIKE '%ЭВМ%' AND name NOT LIKE '%техлитература%'
    AND name NOT LIKE '%компьютер%' AND name NOT LIKE '%стол%компьютерный%' AND name NOT LIKE '%компьютер%промышленный%' AND name NOT LIKE '%компьютер%встраиваемый%' AND name NOT LIKE '%RISC%'
    AND name NOT LIKE '%жесткий%диск%'
    AND name NOT LIKE '%МФУ%'
    AND name NOT LIKE '%принтер%' AND name NOT LIKE '%тумба%' AND name NOT LIKE '%промышленный%' AND name NOT LIKE '%трафаретный%' AND name NOT LIKE '%ленточный%' AND name NOT LIKE '%маркировочный%'
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
    AND name NOT LIKE '%проектор%' ANd name NOT LIKE '%стойка%для%проектора%'
    AND name NOT LIKE '%точка%доступа%'
    AND name NOT LIKE '%сервер%' AND name NOT LIKE '%промышленный%' AND name NOT LIKE '%сервер%времени%' AND name NOT LIKE '%серверная%стойка%' AND name NOT LIKE '%серверный%шкаф%' 
    AND name NOT LIKE  '%веб%камера%'
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
    AND name NOT LIKE '%флэш%' AND  name NOT LIKE '%флеш%'
    
    AND name NOT LIKE '%шкаф%' AND name NOT LIKE '%кресло%' AND name NOT LIKE '%светильник%' AND name NOT LIKE '%стол%' AND name NOT LIKE '%зеркало%' 
    AND name NOT LIKE '%стул%' AND name NOT LIKE '%мультиплексор%' AND name NOT LIKE '%ящик%' AND name NOT LIKE '%диван%' AND name NOT LIKE '%стеллаж%'
    AND name NOT LIKE '%жалюзи%' AND name NOT LIKE '%шторы%' AND name NOT LIKE '%автостоянка%' AND name NOT LIKE '%автотрансформатор%'
    AND name NOT LIKE '%амперметр%' AND name NOT LIKE '%анализатор%' AND name NOT LIKE '%астра%' AND name NOT LIKE '%аппарат%' AND name NOT LIKE '%лампа%'
    AND name NOT LIKE '%блок%расширений%' AND name NOT LIKE '%GPS%' AND name NOT LIKE '%блок%входов%' AND name NOT LIKE '%вольтметр%' AND name NOT LIKE '%датчик%'
    AND name NOT LIKE '%генератор%' AND name NOT LIKE '%сейф%' AND name NOT LIKE '%РКТУ%' AND name NOT LIKE '%пульт%' AND name NOT LIKE '%приборная%стойка%'
    AND name NOT LIKE '%приемник%' AND name NOT LIKE '%приставка%для%посетителей%' AND name NOT LIKE '%терминал%' AND name NOT LIKE '%тележка%'
    AND name NOT LIKE '%диспансер%' AND name NOT LIKE '%доска%' AND name NOT LIKE '%дрель%'
    AND name NOT LIKE '%бактерицидный%'  AND name NOT LIKE '%блок%логики%' AND name NOT LIKE '%блок%контроля%' AND name NOT LIKE '%автоматическая%'
    AND name NOT LIKE '%трансформатор%' AND name NOT LIKE '%брифинг%' AND name NOT LIKE '%вентилятор%' AND name NOT LIKE '%верстак%'
    AND name NOT LIKE '%вешалка%' AND name NOT LIKE '%туалет%' AND name NOT LIKE '%диспансер%' AND name NOT LIKE '%дымоуловитель%'
    AND name NOT LIKE '%измеритель%' AND name NOT LIKE '%имитатор%' AND name NOT LIKE '%индикатор%' AND name NOT LIKE '%кипятильник%' AND name NOT LIKE '%ключ%'
    AND name NOT LIKE '%кондиционер%' AND name NOT LIKE '%дверь%' AND name NOT LIKE '%диспенсер%' AND name NOT LIKE '%телевизор%' AND name NOT LIKE '%дым%'
    AND name NOT LIKE '%ионизатор%' AND name NOT LIKE '%интерфейс%'  AND name NOT LIKE '%GPR-730H10D%' AND name NOT LIKE '%каркас%' AND name NOT LIKE '%кассетный%'    
    AND name NOT LIKE '%карта%' AND name NOT LIKE '%контейнер%' AND name NOT LIKE '%концентратор%' AND name NOT LIKE '%кулер%' AND name NOT LIKE '%кресло%'
    AND name NOT LIKE '%даминатор%' AND name NOT LIKE '%лестница%' AND name NOT LIKE '%микроволновая%' AND name NOT LIKE '%мультиметр%' AND name NOT LIKE '%оптопреобразователь%'
    AND name NOT LIKE '%осциллограф%' AND name NOT LIKE '%осцилограф%' AND name NOT LIKE '%паяльная%' AND name NOT LIKE '%подставка%' AND name NOT LIKE '%пушка%'
    AND name NOT LIKE '%радиатор%' AND name NOT LIKE '%реле%' AND name NOT LIKE '%скамейка%' AND name NOT LIKE '%скамья%' AND name NOT LIKE '%реле%'
    AND name NOT LIKE '%сканер%' AND name NOT LIKE '%стойка%для%дверей%' AND name NOT LIKE '%стойка%для%плит%' AND name NOT LIKE '%стойка%информационная%'
    AND name NOT LIKE '%РЕТОМ%' AND name NOT LIKE '%цветочница%' AND name NOT LIKE '%чайник%' AND name NOT LIKE '%холодильник%' AND name NOT LIKE '%шредер%'
    AND name NOT LIKE '%штамп%' AND name NOT LIKE '%штангенциркуль%' AND name NOT LIKE '%шуруп%'

ORDER BY name;