CREATE TABLE STATION_INFORMATION (
                                     STATION_ID DECIMAL(4) PRIMARY KEY,
                                     NAME VARCHAR(6),
                                     ADDRESS VARCHAR,
                                     LAT DECIMAL(2,7),
                                     LON DECIMAL(2,7),
                                     IS_VIRTUAL_STATION BOOLEAN,
                                     CAPACITY INTEGER
);

CREATE TABLE history_station_information (
                                             history_station_status_id UUID PRIMARY KEY,
                                             station_id DECIMAL(4) REFERENCES station_information(station_id),
                                             address VARCHAR,
                                             lat DECIMAL(2,7),
                                             lon DECIMAL(2,7),
                                             is_virtual_station BOOLEAN,
                                             capacity INTEGER
);

CREATE TABLE bike_status (
                             bike_id CHAR(29) PRIMARY KEY,
                             lat DECIMAL(2,7),
                             lon DECIMAL(2,7),
                             status VARCHAR CHECK (status IN ('disabled', 'taken', 'reserved', 'free')),
                             is_ebike BOOLEAN,
                             last_reported TIMESTAMPTZ,
                             current_range_meters INTEGER
);

CREATE TABLE history_bike_status (
                                     history_bike_status_id UUID PRIMARY KEY,
                                     bike_id CHAR(29) REFERENCES bike_status(bike_id),
                                     lat DECIMAL(2,7),
                                     lon DECIMAL(2,7),
                                     status VARCHAR CHECK (status IN ('disabled', 'taken', 'reserved', 'free')),
                                     change_datetime TIMESTAMPTZ,
                                     range_meters INTEGER
);


CREATE TABLE coordinates (
                             coordinate_id DECIMAL(6) PRIMARY KEY,
                             station_id DECIMAL(4) REFERENCES station_information(station_id),
                             lat DECIMAL(2,15),
                             lon DECIMAL(2,15)
);

CREATE TABLE station_status (
                                station_id DECIMAL(4) REFERENCES station_information(station_id),
                                is_installed BOOLEAN,
                                is_renting BOOLEAN,
                                is_returning BOOLEAN,
                                last_reported TIMESTAMPTZ,
                                num_bikes_available INTEGER,
                                num_ebikes_available INTEGER,
                                num_docks_available INTEGER
);
