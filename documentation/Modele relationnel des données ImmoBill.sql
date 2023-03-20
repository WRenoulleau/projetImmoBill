------------------------------------------------------------
--        Script SQLite  
------------------------------------------------------------


------------------------------------------------------------
-- Table: Locataire
------------------------------------------------------------
CREATE TABLE Locataire(
	id             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	nom            TEXT NOT NULL ,
	prenom         TEXT NOT NULL ,
	adresse        TEXT NOT NULL ,
	tel            TEXT NOT NULL ,
	email          TEXT NOT NULL ,
	commentaire    TEXT NOT NULL
);


------------------------------------------------------------
-- Table: TypeVilla
------------------------------------------------------------
CREATE TABLE TypeVilla(
	id             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	nom            TEXT NOT NULL ,
	nbCouchages    INTEGER NOT NULL
);


------------------------------------------------------------
-- Table: Villa
------------------------------------------------------------
CREATE TABLE Villa(
	id                   INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	nom                  TEXT NOT NULL ,
	adresse              TEXT NOT NULL ,
	description          TEXT NOT NULL ,
	pieces               TEXT NOT NULL ,
	surface              REAL NOT NULL ,
	anneeConstruction    TEXT NOT NULL ,
	caution              TEXT NOT NULL ,
	id_TypeVilla         INTEGER NOT NULL

	,CONSTRAINT Villa_TypeVilla_FK FOREIGN KEY (id_TypeVilla) REFERENCES TypeVilla(id)
);


------------------------------------------------------------
-- Table: Réservation
------------------------------------------------------------
CREATE TABLE Reservation(
	id              INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	dateArrivee     NUMERIC NOT NULL ,
	dateDepart      NUMERIC NOT NULL ,
	nbAdultes       INTEGER NOT NULL ,
	nbEnfants       INTEGER NOT NULL ,
	dateResa        NUMERIC NOT NULL ,
	montant         TEXT NOT NULL ,
	optionMenage    INTEGER NOT NULL ,
	id_Locataire    INTEGER NOT NULL ,
	id_Villa        INTEGER NOT NULL

	,CONSTRAINT Reservation_Locataire_FK FOREIGN KEY (id_Locataire) REFERENCES Locataire(id)
	,CONSTRAINT Reservation_Villa0_FK FOREIGN KEY (id_Villa) REFERENCES Villa(id)
);


------------------------------------------------------------
-- Table: TypeUser
------------------------------------------------------------
CREATE TABLE TypeUser(
	id         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	libelle    TEXT NOT NULL
);


------------------------------------------------------------
-- Table: Equipement
------------------------------------------------------------
CREATE TABLE Equipement(
	id             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	nom            TEXT NOT NULL ,
	etat           TEXT NOT NULL ,
	description    TEXT NOT NULL ,
	caution        TEXT NOT NULL
);


------------------------------------------------------------
-- Table: User
------------------------------------------------------------
CREATE TABLE User(
	id             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	login          TEXT NOT NULL ,
	password       TEXT NOT NULL ,
	id_TypeUser    INTEGER NOT NULL

	,CONSTRAINT User_TypeUser_FK FOREIGN KEY (id_TypeUser) REFERENCES TypeUser(id)
);


------------------------------------------------------------
-- Table: Equiper
------------------------------------------------------------
CREATE TABLE Equiper(
	id               INTEGER NOT NULL ,
	id_Equipement    INTEGER NOT NULL ,
	qte              INTEGER NOT NULL,
	CONSTRAINT Equiper_PK PRIMARY KEY (id,id_Equipement)

	,CONSTRAINT Equiper_Villa_FK FOREIGN KEY (id) REFERENCES Villa(id)
	,CONSTRAINT Equiper_Equipement0_FK FOREIGN KEY (id_Equipement) REFERENCES Equipement(id)
);


