DELETE FROM DOCTOR;
DELETE FROM ADDRESS;

INSERT INTO ADDRESS(home_address, local_government_area, state)
			VALUES('Mobil Filing Station, Independence Way', 'Kaduna North', 'Kaduna State');
INSERT INTO ADDRESS(home_address, local_government_area, state)
			VALUES('Nasarawa, Ministry of Local Government Affairs', 'Kaduna South', 'Kaduna State');
INSERT INTO ADDRESS(home_address, local_government_area, state)
			VALUES('Federal Road Safety Corps', 'Shiroro', 'Niger State State');
INSERT INTO ADDRESS(home_address, local_government_area, state)
			VALUES('Gwarimpa, Michael Okpara Way', 'F.C.T', 'Federal Capital Territory');
INSERT INTO ADDRESS(home_address, local_government_area, state)
			VALUES('Mobil Filing Station, Independence Way', 'Kaduna North', 'Kaduna State');
INSERT INTO ADDRESS(home_address, local_government_area, state)
			VALUES('Ebuta Metta, Ikoyi', 'Ikeja', 'Lagos State');

INSERT INTO DOCTOR(first_name, last_name, phone_number, email_address, address_id)
				VALUES('Ulberg', 'Lurich', '+2348012345678', 'lurich@gmail.com', 1);
INSERT INTO DOCTOR(first_name, last_name, phone_number, email_address, address_id)
				VALUES('Aklas', 'Numanberg', '+2347012345678', 'akmanberg@yahoo.com', 2);
INSERT INTO DOCTOR(first_name, last_name, phone_number, email_address, address_id)
				VALUES('Dumgerk', 'Halaand', '+2349012345678', 'dumgerk@outlook.com', 3);
INSERT INTO DOCTOR(first_name, last_name, phone_number, email_address, address_id)
				VALUES('David', 'Cameron', '+2349112345678', 'me@cameron.com', 4);
INSERT INTO DOCTOR(first_name, last_name, phone_number, email_address, address_id)
				VALUES('John', 'Maxwell', '+2348112345678', 'johnmaxwell@gmail.com', 5);
INSERT INTO DOCTOR(first_name, last_name, phone_number, email_address, address_id)
				VALUES('Rick', 'Samson', '+2349023456789', 'rick@gmail.com', 6);
				
UPDATE address set doctor_id = 1 where id = 1;
UPDATE address set doctor_id = 2 where id = 2;
UPDATE address set doctor_id = 3 where id = 3;
UPDATE address set doctor_id = 4 where id = 4;
UPDATE address set doctor_id = 5 where id = 5;
UPDATE address set doctor_id = 6 where id = 6;
