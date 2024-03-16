# Netflix Eureka - Mikroservisna Aplikacija za Upravljanje Zaposlenima i Odeljenjima

Spring Boot, Spring Cloud Netflix Eureka za servisni registar i Kafku za asinhronu komunikaciju između servisa.

## Moduli

Aplikacija se sastoji od tri modula:

1. **employee-service**: Servis za upravljanje zaposlenima.
2. **department-service**: Servis za upravljanje odeljenjima.
3. **service-registry**: Eureka service registry

## Glavne Karakteristike

- **Registracija zaposlenih i odeljenja**: Mogućnost kreiranja novih zapisa za zaposlene i odeljenja.
- **Dobijanje informacija o zaposlenima i odeljenjima**: Pruža informacije o specifičnim zaposlenima i odeljenjima na osnovu ID-a ili koda odeljenja.
- **Komunikacija između servisa**: `employee-service` komunicira sa `department-service` koristeći Feign klijenta za dobijanje informacija o odeljenjima.
- **Asinhrona obrada**: Upotreba Apache Kafka za asinhronu komunikaciju između servisa.

## Tehnologije

- **Spring Boot**: Za razvoj mikroservisa.
- **Spring Cloud Netflix Eureka**: Za registraciju i otkrivanje servisa.
- **Apache Kafka**: Za asinhronu komunikaciju između servisa.
- **MySQL**: Baza podataka za skladištenje informacija o zaposlenima i odeljenjima.

## Pokretanje Aplikacije

Svaki modul se pokreće kao zaseban Spring Boot aplikacija. Potrebno je prvo pokrenuti `service-registry` modul, a zatim `department-service` i `employee-service`.
