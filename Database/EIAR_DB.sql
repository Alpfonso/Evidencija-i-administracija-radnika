BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "zaposlenici" (
	"id"	INTEGER,
	"ime"	varchar(255),
	"prezime"	varchar(255),
	"datum_rodenja"	date,
	"grad_stanovanja"	varchar(255),
	"ulica_i_broj"	varchar(255),
	"email"	varchar(255),
	"OIB"	int,
	"telefon"	int,
	"obrazovanje"	varchar(255),
	"razina_ovlasti"	varchar(255),
	"radno_vrijeme_start"	datetime,
	"radno_vrijeme_end"	datetime,
	"slobodni_dani"	int,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "projekti" (
	"id"	INTEGER,
	"ime"	varchar(255),
	"nadlezni_zaposlenik"	int,
	"datum_pocetka"	datetime,
	"krajnji_rok"	datetime,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "zadaci" (
	"id"	INTEGER,
	"ime"	varchar(255),
	"zadano_zaposleniku"	int,
	"projekt"	int,
	FOREIGN KEY("projekt") REFERENCES "projekti"("id"),
	FOREIGN KEY("zadano_zaposleniku") REFERENCES "zaposlenici"("id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "ticketi" (
	"id"	INTEGER,
	"prijavio"	int,
	"opis"	varchar(255),
	"zadatak"	int,
	"vrijeme_i_datum"	timestamp,
	"rijesen"	boolean DEFAULT false,
	"rijesio"	int,
	FOREIGN KEY("prijavio") REFERENCES "zaposlenici"("id"),
	FOREIGN KEY("rijesio") REFERENCES "zaposlenici"("id"),
	FOREIGN KEY("zadatak") REFERENCES "zadaci"("id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE INDEX IF NOT EXISTS "stupnjevi_ovlasti" ON "zaposlenici" (
	"razina_ovlasti"
);
COMMIT;
