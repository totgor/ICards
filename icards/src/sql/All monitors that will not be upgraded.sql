-- все мониторы которые не будут обновлены, т.к. не находятся в этапах модернизации

SELECT * FROM user_monitors WHERE
fio IN (SELECT fio FROM pc_not_upgrade);