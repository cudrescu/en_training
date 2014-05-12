Exercitii rezolvate in timpul training-ului

Continut:
Day 2 Git & Maven : 
	- contine rezolvarea exercitiilor din prezentarea "Development Environment" 
	- aceasta consta intr-un proiect creat folosind Maven ce afiseaza mesajul "Hello world"

Day 3&4: 
	- contine rezolvarea exercitiilor din prezentarea "Java Programming Fundamentals_final_cut_part1"
	- vei gasi 2 proiecte: FirstEx, SecondEx cu rezolvarea cerintelor din enunt.

Day 5: Flow control & Exceptions:
	- contine cele 2 exemple din prezentarea pe aceasta tema
	- vei gasi 2 proiecte: ExceptionChaining si FinallyExample

Day 6: Generics 
	- contine un proiect cu cateva exemple din prezentarea pe aceasta tema
	
Day 7: Collections
	- contine doua proiecte cu implementarea exercitiilor primite ca tema
	- collections.exercises contine cele 5 fisiere sursa ce aveau erori de implementare; 
		-> in principal aceste erori se puteau rezolva fie implementand interfata comparable si suprascriind metoda hashCode()
		-> mai multe detalii in comentariile din cod
	- RandomizedQueue contine implementarea unei cozi randomizate dupa specificatiile din enunt;
		-> am ales sa creez o interfata pentru aceasta coada ce contine metodele cerute in enunt
		-> am implementat aceste metode si am creat cateva teste in fiserul Test.java
		
Day 8: - IO
	- contine 2 proiecte cu implementarea exercitiilor primite ca tema 
	- CircularList: contine implementarea unei liste circulare serializabile
		-> fisierul Main.java contine o serie de teste privind serializarea si deserializare unei astfel de liste si afisarea rezultatelor
	- SerializeExamples: contine 2 pachete:
		->JustSuperclassSerializable: in care implementez o clasa parinte si o clasa care extinde aceasta clasa;
			* doar clasa parinte implementeaza serializable
			* in clasa fiu arunc o exceptie daca se incearca serializarea acesteia
			* am observat ca serializarea se realizeaza corect pentru clasa parinte ,iar pentru fiu se arunca o exceptie pe care o prind; testul se gaseste in fisierul Test.java
		->JustSubclassSerializable: in care implementez o clasa parinte si o clasa care extinde aceasta clasa;
			* doar clasa fiu implementeaza serializable 
			* la serializarea clasei parinte se arunca o exceptie pe care o prind
			* serializarea clasei fiu este realizata cu succes dar la deserializare se observa ca doar campurile din clasa fiu sunt corecte dupa citire, 
									campurile preluate din clasa parinte fiind null; testul se gaseste in Test.

Day 9: - Threading:
		- contine rezolvarea exercitiilor propuse in prezentarea pe aceasta tema

Day 10: - Database fundamentals
		- contine rezolvarea exercitiilor din prezentarea pe aceasta tema