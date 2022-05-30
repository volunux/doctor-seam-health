drop table if exists doctor cascade;
drop table if exists address cascade;

create table if not exists doctor (
	id bigserial not null,
	email_address varchar(50) not null,
	first_name VARCHAR(20) not null,
	last_name VARCHAR(20) not null,
	phone_number VARCHAR(15) not null,
	address_id int8 not null,
	primary key (id)
);

create table if not exists address (
	id bigserial not null,
	home_address varchar(300) not null,
	local_government_area varchar(25) not null,
	state varchar(25) not null, 
	doctor_id int8,
	primary key(id)
);

alter table doctor
	add constraint uqk_email_address unique (email_address);
alter table doctor
	add constraint uqk_phone_number unique (phone_number);
alter table doctor
	add constraint uqk_address_id unique (address_id);
alter table doctor
	add constraint frk_doctor foreign key (address_id) references address;
alter table address
	add constraint frk_address foreign key (doctor_id) references doctor;