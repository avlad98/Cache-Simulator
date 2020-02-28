Vlad Andrei-Alexandru
321CB
					=== README TEMA 1 POO ===
				 - Give me more subscriptions - 
				 
	Pentru implementarea temei am creat 9 clase si o interfata.
		Clase: 
			-Main
			-Memory
			-FIFOCache		(implementeaza interfata Cache)
			-LRUCache		(implementeaza interfata Cache)
			-LFUCache		(implementeaza interfata Cache)
			-Subscriptie 	(clasa abstracta)
			-Free			(extinde Subscriptie)
			-Basic			(extinde Free)
			-Premium		(extinde Basic)
			
		Interfata:
			-Cache
		
Clasa "Main":

	-In metoda "main" citesc inputul, deschid fisierul de output si citesc
informatiile din input. Pe parcurs ce obtin informatiile, creez o instanta
pentru un tip de cache (determinat din input) cu ajutorul functiei initCache.
	Dupa ce delimitez operatiile si obiectele de pe fiecare linie apelez functiile
ADD sau GET.

	-In "ADD" adaug obiectul (deja creat in main) in memoria principala pe
baza regulilor din document

	-In "GET" se apeleaza metodele necesare si se scrie in fisier rezultatul
	
	-In "initCache" creez o instanta de cache pe baza tipului determinat din input
	
	
Clasa "Memory":
	Aceasta clasa contine o lista statica de elemente de tip subscriptie care 
reprezinta memoria principala.

	-Metoda "add" adauga un obiect in lista
	
	-Metoda "overwrite" cauta vechiul obiect si il suprascrie cu cel nou
	
	-"contains" verifica daca obiectul exista in lista
	
	-"get" returneaza referinta obiectului cautat in lista
	
Interfata "Cache":
	Aceasta interfata modeleaza clasele care o implementeaza:
		-FIFOCache
		-LRUCache
		-LFUCache
		
Clasa "FIFOCache":
	Acest tip de cache foloseste un simplu array de elemente Subscriptie
	Variabilele size si used tin evidenta la dimensiunea cache-ului si 
cate elemente sunt in array la un moment dat;
	
	-Metoda "add" adauga elementul daca nu exista deja in array
	
	-Metoda "remove()" sterge un element pe baza regulii din document
	
	-Metoda "contains" verifica daca un obiect exista in cache
	
	-Metoda "remove(name)" elimina elementul cu numele name (daca exista)

	-Metoda "get" returneaza referinta obiectului cautat in cache
	
Clasa "LRUCache":
	Acest tip de cache foloseste un arraylist de elemente Subscriptie.
	
	-Metoda "add" adauga elementul daca nu exista sau il actualizeaza mutandu-l
la sfarsitul listei (cele mai vechi obiecte sunt la inceputul vectorului)
	
	-Metoda "remove" sterge un element cautat (daca exista)
	
	-Metoda "contains" verifica daca un obiect exista in cache
	
	-Metoda "get" returneaza referinta obiectului cautat in cache
	
Clasa "LFUCache":
	Acest tip de cache foloseste un arraylist de elemente Subscriptie.
	
	-Metoda "add" adauga elementul daca nu exista. Numarul de accesari creste
la fiecare comanda GET.
	
	-Metoda "remove" sterge un element cautat (daca exista)
	
	-Metoda "contains" verifica daca un obiect exista in cache
	
	-Metoda "get" returneaza referinta obiectului cautat in cache
	
Clasa "Subscriptie":
	Contine numele obiectului si un contor pentru numarul de utilizari
(util pentru lfu).
	
	-Metoda "createSubscriptie" creeaza o subscriptie pe baza numarului
de accesari basic sau premium si returneaza referinta.

	-Metoda "plus" incrementeaza numarul de accesari (nrGet).
	
Clasele "Free", "Basic" si "Premium":
	-Fiecare clasa are un getter pentru tipul de cache care apeleaza 
superclasa daca numarul de premium, respectiv basic este 0; (Free e nelimitat)
	
	-Metoda "use" scade numarul de basic sau premium la fiecare operateie GET
	
Pe checkerul local obtin 100P + 20P bonus
Pe vmchecker obtin punctajul total de 150P + 40P bonus
