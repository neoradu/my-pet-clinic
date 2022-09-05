use pet_clinic_prod_db;
use pet_clinic_dev_db;
create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB;
create table pets (id bigint not null auto_increment, birth_date date, name varchar(255), owner_id bigint, type_id bigint, primary key (id)) engine=InnoDB;
create table specialities (id bigint not null auto_increment, desciption varchar(255), primary key (id)) engine=InnoDB;
create table types (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table vet_specialities (vet_id bigint not null, speciality_id bigint not null, primary key (vet_id, speciality_id)) engine=InnoDB;
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table visits (id bigint not null auto_increment, visit_date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB;
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id);
alter table pets add constraint FKtmmh1tq8pah5vxf8kuqqplo4p foreign key (type_id) references types (id);
alter table vet_specialities add constraint FKbwgby4n775up01sd73p4girh8 foreign key (speciality_id) references specialities (id);
alter table vet_specialities add constraint FKeuarcu29fuywwvcv31bfgf500 foreign key (vet_id) references vets (id);
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id);


DROP TABLE IF EXISTS visits;
DROP TABLE IF EXISTS vet_specialities;
DROP TABLE IF EXISTS vets; 

DROP TABLE IF EXISTS specialities; 
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS types;
DROP TABLE IF EXISTS owners;




