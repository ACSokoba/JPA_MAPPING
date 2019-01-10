CREATE TABLE `tp_jpaserie2`.`maires` (
  `maire_id` int NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(50) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `civilite` VARCHAR(5) NOT NULL,
  `dateDeNaissance` DATE ,
  PRIMARY KEY (`maire_id`));
  
  CREATE TABLE `tp_jpaserie2`.`communes` (
  `commune_id` int NOT NULL AUTO_INCREMENT,
  /*`code_commune` VARCHAR(50) NULL,*/

  `nom_commune` VARCHAR(45) NULL,
  `code_postal` VARCHAR(45) NULL,
  `libelle_acheminement` VARCHAR(45),
  `ligne5` VARCHAR(45) NOT NULL, 
  PRIMARY KEY (`commune_id`)
  /*FOREIGN KEY (departement_id) REFERENCES departements(id),
   FOREIGN KEY (maire_id) REFERENCES maires(id)*/);

  CREATE TABLE `tp_jpaserie2`.`departements` (
  `departement_id` int NOT NULL AUTO_INCREMENT,
  `code_departement` VARCHAR(50) UNIQUE,
  `nom_departement` VARCHAR(45) UNIQUE,
  PRIMARY KEY (`departement_id`));
  
  
  
/* ----------------------------------------------------------
-------------------Chargement des maires -------------------
-------------------------------------------------------------*/


LOAD DATA LOCAL INFILE 'C:\\Users\\Aboubakar C. Sokoba\\Desktop\\ressources\\maires-25-04-2014.csv' 
INTO TABLE maires
FIELDS TERMINATED BY ';'
IGNORE 4 LINES
(@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10, @col11)
set nom=@col6,prenom=@col7,civilite=@col8,dateDeNaissance=STR_TO_DATE(@col9,'%d/%m/%Y');



/* ----------------------------------------------------------
-------------------Chargement des departements -------------------
-------------------------------------------------------------*/

LOAD DATA LOCAL INFILE 'C:\\Users\\Aboubakar C. Sokoba\\Desktop\\ressources\\maires-25-04-2014.csv' 
INTO TABLE departements
FIELDS TERMINATED BY ';'
IGNORE 4 LINES
(@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10, @col11)
set 
 code_departement=@col1,
 nom_departement=@col2;
 
 
/* ----------------------------------------------------------
-------------------Chargement des communes -------------------
-------------------------------------------------------------*/



LOAD DATA LOCAL INFILE 'C:\\Users\\Aboubakar C. Sokoba\\Desktop\\ressources\\laposte_hexasmal.csv' INTO TABLE communes
FIELDS TERMINATED BY ';'
IGNORE 1 LINES
(@col1, @col2, @col3, @col4, @col5)
set code_postal=@col3,nom_commune=@col2,ligne5=@col5,libelle_acheminement=@col4;


/* ----------------------------------------------------------
-------------------Requetes de base -------------------
-------------------------------------------------------------*/


DROP TABLE departements;
DROP TABLE communes;
DROP TABLE maires;



SELECT * FROM tp_jpaserie2.maires;
SELECT COUNT(*) FROM maires where Prenom='Daniel';

SELECT COUNT(*) FROM maires where civilite='M';
SET @total = 35885;
SELECT * FROM maires where Prenom='Daniel';SELECT count(*) FROM tp_jpaserie2.maires;
SELECT count(*) FROM maires where dateDeNaissance between '1989-01-01' and '2001-01-01' ;
SELECT count(*) FROM maires where dateDeNaissance between '1979-01-01' and '1989-01-01' ;
SELECT count(*) FROM maires where dateDeNaissance between '1969-01-01' and '1979-01-01' ;
SELECT count(*) FROM maires where dateDeNaissance between '1959-01-01' and '1969-01-01' ;
SELECT count(*) FROM maires where dateDeNaissance between '1949-01-01' and '1959-01-01' ;
SELECT count(*) FROM maires where dateDeNaissance between '1939-01-01' and '1949-01-01' ;
SELECT count(*) FROM maires where dateDeNaissance between '1929-01-01' and '1939-01-01' ;
SELECT count(*) FROM maires where dateDeNaissance between '1919-01-01' and '1929-01-01' ;
SELECT count(*) FROM maires where dateDeNaissance between '1909-01-01' and '1919-01-01' ;

select  min(dateDeNaissance),nom,prenom from maires ;


SELECT * FROM tp_jpaserie2.communes;
SELECT * FROM tp_jpaserie2.communes WHERE ligne5<>'';
SELECT count(*) FROM tp_jpaserie2.communes WHERE libelle_acheminement<>nom_commune;
