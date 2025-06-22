create sequence station_information_seq minvalue 1;
alter table station_information alter column station_id set default nextval('station_information_seq');

create sequence coordinate_seq minvalue 1;
alter table coordinate alter column coordinate_id set default nextval('coordinate_seq');