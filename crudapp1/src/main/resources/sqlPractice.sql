-- One to Many

CREATE TABLE Director(
                         director_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                         name varchar(100) NOT NULL UNIQUE,
                         age int CHECK (age > 10)
);


CREATE TABLE Movie(
                      movie_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                      director_id int NOT NULL REFERENCES director(director_id),
                      name varchar(200) NOT NULL,
                      year_of_production int CHECK(year_of_production > 1900)
);


INSERT INTO Director(name, age) VALUES ('Quentin Tarantino', 57);
INSERT INTO Director(name, age) VALUES ('Martin Scorsese', 78);
INSERT INTO Director(name, age) VALUES ('Guy Ritchie', 52);
INSERT INTO Director(name, age) VALUES ('Woody Allen', 85);
INSERT INTO Director(name, age) VALUES ('David Lynch', 74);
INSERT INTO Director(name, age) VALUES ('Christopher Nolan', 50);


INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Reservoir Dogs', 1992);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Pulp Fiction', 1994);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'The Hateful Eight', 2015);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Once Upon a Time in Hollywood', 2019);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'Taxi Driver', 1976);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'Goodfellas', 1990);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'The Wolf of Wall Street', 2013);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (3, 'Lock, Stock and Two Smoking Barrels', 1998);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (3, 'Snatch', 2000);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (4, 'Midnight in Paris', 2011);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (6, 'Inception', 2010);

-- У режиссера с id=5 нет ни одного фильма в нашей БД

-- пробуем вставить фильм с несуществующим режиссером - ПОЛУЧАЕМ ОШИБКУ (на это и нужна REFERENCES)
INSERT INTO Movie(director_id, name, year_of_production) VALUES (10, 'bla bla', 2020);

-- Join'им

-- Выводим всех режиссеров, у которых есть фильмы и для каждого режиссера выводим его фильмы
SELECT * FROM Director JOIN Movie ON Director.director_id = Movie.director_id;

-- Выводим только полезную информацию
SELECT Director.name, Movie.name FROM Director JOIN Movie ON Director.director_id = Movie.director_id;

-- ! В таблицах Movie и Director строки могут располагаться в любом порядке, JOIN в любом случае спарит нужные строки по условию

-- LEFT JOIN
SELECT Director.name, Movie.name FROM Director LEFT JOIN Movie ON Director.director_id = Movie.director_id;

-- Появился Дэвид Линч, у которого нет фильма в нашей БД.


-- One to One

CREATE TABLE Citizen(
                        citizen_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                        name varchar(100) NOT NULL,
                        age int CHECK (age > 0)
);

CREATE TABLE Passport(
                         citizen_id int PRIMARY KEY REFERENCES Citizen(citizen_id),
                         passport_number int
);


INSERT INTO Citizen(name, age) VALUES ('Bob', 12);
INSERT INTO Citizen(name, age) VALUES ('Tom', 24);
INSERT INTO Citizen(name, age) VALUES ('Katy', 39);
INSERT INTO Citizen(name, age) VALUES ('Alice', 45);

INSERT INTO Passport(citizen_id, passport_number) VALUES (1, 12345);
INSERT INTO Passport(citizen_id, passport_number) VALUES (2, 75124);
INSERT INTO Passport(citizen_id, passport_number) VALUES (3, 91245);
INSERT INTO Passport(citizen_id, passport_number) VALUES (4, 19259);


-- не можем назначить одному человеку несколько паспортов
INSERT INTO Passport(citizen_id, passport_number) VALUES (3, 12455);

-- и также не можем назначить паспорт несуществующему человеку
INSERT INTO Passport(citizen_id, passport_number) VALUES (10, 12455);

-- Inner Join
SELECT name, passport_number FROM citizen JOIN passport ON citizen.citizen_id = passport.citizen_id;

-- LEFT JOIN
-- Добавим человека без паспорта
INSERT INTO Citizen(name, age) VALUES ('Jane', 1);

SELECT name, passport_number FROM citizen LEFT JOIN passport ON citizen.citizen_id = passport.citizen_id;


-- Many to Many - Actors to Movies

CREATE TABLE Actor(
                      actor_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                      name varchar(100) NOT NULL UNIQUE,
                      age int CHECK (age > 0)
);

INSERT INTO Actor(name, age) VALUES ('Harvey Keitel', 81);
INSERT INTO Actor(name, age) VALUES ('Robert De Niro', 77);
INSERT INTO Actor(name, age) VALUES ('Leonardo DiCaprio', 46);
INSERT INTO Actor(name, age) VALUES ('Jason Statham', 53);
INSERT INTO Actor(name, age) VALUES ('Joe Pesci', 77);
INSERT INTO Actor(name, age) VALUES ('Samuel L. Jackson', 72);


-- Создаем связывающую таблицу (JOIN TABLE)

CREATE TABLE Actor_Movie(
                            actor_id int REFERENCES Actor(actor_id),
                            movie_id int REFERENCES Movie(movie_id),
                            PRIMARY KEY(actor_id, movie_id)
);


INSERT INTO Actor_Movie VALUES(1, 1);
INSERT INTO Actor_Movie VALUES(1, 2);
INSERT INTO Actor_Movie VALUES(2, 5);
INSERT INTO Actor_Movie VALUES(2, 6);
INSERT INTO Actor_Movie VALUES(3, 4);
INSERT INTO Actor_Movie VALUES(3, 7);
INSERT INTO Actor_Movie VALUES(3, 11);
INSERT INTO Actor_Movie VALUES(4, 8);
INSERT INTO Actor_Movie VALUES(4, 9);
INSERT INTO Actor_Movie VALUES(5, 6);
INSERT INTO Actor_Movie VALUES(6, 2);
INSERT INTO Actor_Movie VALUES(6, 3);

-- Пробуем вставить дубликат по двум колонкам - ошибка
INSERT INTO Actor_Movie VALUES(6, 3);


-- Чтобы узнать, какой актер снимался в каком фильме, нам надо сделать два Join'а
-- Join для случая отношения Многие ко многим
SELECT Actor.name, Movie.name FROM Actor JOIN actor_movie ON actor.actor_id = actor_movie.actor_id JOIN movie ON actor_movie.movie_id = movie.movie_id;