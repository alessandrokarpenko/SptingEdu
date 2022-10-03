create table item(
                     id int primary key generated by default as identity,
                     person_id int REFERENCES person(id) on delete set null,
                     item_name varchar(100) not null
);


insert into person(name, age) VALUES ('Tom', 35);
insert into person(name, age) VALUES ('Bob', 52);
insert into person(name, age) VALUES ('Katy', 14);

insert into item(person_id, item_name) VALUES(1, 'book');
insert into item(person_id, item_name) VALUES(1, 'airPods');
insert into item(person_id, item_name) VALUES(2, 'iphone');
insert into item(person_id, item_name) VALUES(3, 'kindle');
insert into item(person_id, item_name) VALUES(3, 'tv');
insert into item(person_id, item_name) VALUES(3, 'playstation');

select * from person;
select * from item;


create table person(
    id int primary key generated by default as identity,
    name varchar(100) not null,
    age int
);

create table passport(
    person_id int primary key references person(id) on DELETE cascade,
    passport_number int not null
);

create table person(
                       id int primary key generated by default as identity,
                       name varchar(100) not null,
                       age int
);

create table passport(
                         id int primary key generated by default as identity,
                         person_id int unique references person(id) on DELETE cascade,
                         passport_number int not null
);


create table actor(
                      id int generated by default as identity primary key,
                      name varchar(100) not null unique,
                      age int check ( age > 0 )
);

create table movie(
                      id int generated by default as identity primary key,
                      name varchar(200) not null,
                      year_of_production int check ( year_of_production > 1900 )
);

create table actor_movie
(
    actor_id int references actor (id),
    movie_id int references movie (id)
);
