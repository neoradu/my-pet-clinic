/*connect to mysql DB and run as root user*/

/*Create databases:*/
CREATE DATABASE pet_clinic_dev_db;
CREATE DATABASE pet_clinic_prod_db;

/*CREATE database users*/
CREATE user 'pet_clinic_dev_user'@'%' IDENTIFIED BY 'pass';/* pass this password by safer means*/
CREATE user 'pet_clinic_prod_user'@'%' IDENTIFIED BY 'pass';
/*% --> wild card comming from any host*/

/*Grant access to DML to databases*/
GRANT SELECT ON pet_clinic_dev_db.* to 'pet_clinic_dev_user'@'%';
GRANT INSERT ON pet_clinic_dev_db.* to 'pet_clinic_dev_user'@'%';
GRANT DELETE ON pet_clinic_dev_db.* to 'pet_clinic_dev_user'@'%';
GRANT UPDATE ON pet_clinic_dev_db.* to 'pet_clinic_dev_user'@'%';

GRANT SELECT ON pet_clinic_prod_db.* to 'pet_clinic_prod_user'@'%';
GRANT INSERT ON pet_clinic_prod_db.* to 'pet_clinic_prod_user'@'%';
GRANT DELETE ON pet_clinic_prod_db.* to 'pet_clinic_prod_user'@'%';
GRANT UPDATE ON pet_clinic_prod_db.* to 'pet_clinic_prod_user'@'%';

