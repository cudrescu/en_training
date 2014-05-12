/* ex 2.1 */
update Salariat
	set salariu = salariu - (salariu/10)
where Departament_idDepartament = 20;

/* ex 2.2 */
select max(salariu)
	from salariat
group by Departament_idDepartament;

/* ex 2.3 */
select max(a.salariu)
	from salariat a
where 30 > (select count(*)
				from salariat b
				where a.Departament_idDepartament = b.Departament_idDepartament
			)
		and substring(a.numeSalariat,1,1) = 'T'
group by a.Departament_idDepartament;

/* ex 2.4 */
drop table auxTable;

create table auxTable as
	select Departament_idDepartament idDepartament, 
			count(*) numarSalariati
			from salariat
	group by Departament_idDepartament;

update salariat
	set salariu = salariu + salariu/10
where Departament_idDepartament in (select a.idDepartament
										from auxTable a
									where a.numarSalariati = 1);

drop table auxTable;
			


