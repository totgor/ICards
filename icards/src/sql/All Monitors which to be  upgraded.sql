-- все мониторы которые находятся в этапах модернизации

SELECT * FROM user_monitors WHERE
fio IN (SELECT fio FROM pc_upgrade);