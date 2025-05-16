-- bike_id -> mevo_bike_id, station_id -> mevo_station_id
-- dodanie nowych, wlasnych kluczy glownych: bike_id decimal(4), station_id decimal(4)

alter table history_bike_status drop constraint history_bike_status_bike_id_fkey;
alter table history_station_information drop constraint history_station_information_station_id_fkey;
alter table coordinate drop constraint coordinates_station_id_fkey;
alter table station_status drop constraint station_status_station_id_fkey;

alter table bike_information rename column bike_id to mevo_bike_id;
alter table bike_information drop constraint bike_status_pkey;
alter table bike_information add column bike_id DECIMAL(4);
alter table bike_information add constraint bike_information_pk primary key (bike_id);

alter table station_information rename column station_id to mevo_station_id;
alter table station_information drop constraint station_information_pkey;
alter table station_information add column station_id DECIMAL(4);
alter table station_information add constraint station_information_pk primary key (station_id);

alter table history_bike_status drop column bike_id;
alter table history_bike_status add column bike_id DECIMAL(4);
alter table history_bike_status add constraint history_bike_status_bike_id_fk foreign key (bike_id) references bike_information(bike_id);

alter table history_station_information add constraint history_station_information_station_id_fk foreign key (station_id) references station_information(station_id);
alter table coordinate add constraint coordinate_station_id_fk FOREIGN KEY (station_id) references station_information(station_id);
alter table station_status add constraint station_status_station_id_fk FOREIGN KEY (station_id) references station_information(station_id);
