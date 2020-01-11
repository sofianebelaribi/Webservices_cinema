# CinemaApp
Webservice, Web and mobile client


CinemaServer :
	install and launch:
		You will need to have a mysql database cinema already here,
		with a user userepul/epul here
		Once you started mysql, you should be able to launch the server:

	Endpoints:
	You can get lists with these urls :

	personnages: http://localhost:8080/personnages
	categories : http://localhost:8080/categories
	acteurs : http://localhost:8080/acteurs
	realisateurs: http://localhost:8080/realisateurs 
	films: http://localhost:8080/films

	You can get details with urls : 
	personnages: http://localhost:8080/personnages/{idpersonnage}  //not working at the time but will
	categories : http://localhost:8080/categories/{idCate}
	acteurs : http://localhost:8080/acteurs/{idActeur}
	realisateurs: http://localhost:8080/realisateurs/{idReal}
	films: http://localhost:8080/films/{idFilm}

