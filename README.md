# MEVO GBFS Backend (Spring Boot + PostgreSQL)

Backend service that pulls public **MEVO GBFS** feeds and stores them in **PostgreSQL**.  
Schema is managed via **Flyway** migrations.

## Goals (scope)
- Sync GBFS data every **5–10 min** and keep **current state + history** (on change).
- Expose read features: **available stations**, **nearest stations (with live bikes/docks)**.
- (Planned) **notifications** for favourite stations (bikes appearing/disappearing) + basic **peak-hours analytics**.
- (Next phase) track bikes outside stations via `free_bike_status.json`.

## Data sources (GBFS)
Base URL: `https://gbfs.urbansharing.com/rowermevo.pl/`
- `station_information.json` — station metadata (name, address, lat/lon, capacity)
- `station_status.json` — live station status (bikes/docks, last_reported)
- `free_bike_status.json` — bikes + positions (planned)

## Requirements
- Java 17+
- Maven
- PostgreSQL

## Configuration
`application.properties` (example):
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mevo
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.show-sql=true
spring.flyway.enabled=true
spring.flyway.locations=classpath:db.migration


