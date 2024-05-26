-- Wstawianie danych do tabeli address
insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'Cukierkowa', '20/4', 'Warszawa', '62-030');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (2, 'Lipowa', '4/14', 'Kraków', '12-345');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (3, 'Bobrza', '41/4', 'Wrocław', '23-456');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (4, 'Malinowa', '78/7', 'Łódź', '34-567');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (5, 'Tymiankowa', '41/142', 'Gdańsk', '45-678');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (6, 'Zielona', '10/3', 'Poznań', '56-789');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (7, 'Wesoła', '12/9', 'Katowice', '67-890');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (8, 'Słoneczna', '33/5', 'Szczecin', '78-901');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (9, 'Kwiatowa', '45/2', 'Lublin', '89-012');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (10, 'Leśna', '22/7', 'Bydgoszcz', '90-123');

-- Wstawianie danych do tabeli doctor
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (1, 'Jan', 'Kowalski', '123456789', 'jan_kowalski@gmail.com', '123456', 'SURGEON', 1);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (2, 'Anna', 'Nowak', '987654321','anna_nowak@gmail.com', '654321', 'GP', 2);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (3, 'Piotr', 'Wiśniewski', '456789123', 'piotr_wisniewski@gmail.com', '789123', 'SURGEON', 3);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (4, 'Maria', 'Lewandowska', '321654987', 'maria_lewandowska@gmail.com', '987654', 'DERMATOLOGIST', 4);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (5, 'Robert', 'Zieliński', '789123456', 'robert_zielinski@gmail.com', '321987', 'GP', 5);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (6, 'Monika', 'Kaczmarek', '123789456', 'monika_kaczmarek@gmail.com', '456321', 'GP', 6);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (7, 'Tomasz', 'Nowicki', '321987654', 'tomasz_nowicki@gmail.com', '789654', 'SURGEON', 7);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (8, 'Katarzyna', 'Pawlak', '987321654', 'katarzyna_pawlak@gmail.com', '654987', 'OCULIST', 8);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (9, 'Andrzej', 'Michalski', '456123789', 'andrzej_michalski@gmail.com', '321456', 'DERMATOLOGIST', 9);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (10, 'Joanna', 'Wójcik', '789456123', 'joanna_wojcik@gmail.com', '654123', 'GP', 10);

-- Wstawianie danych do tabeli patient
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (1, 'Marek', 'Kowalski', '123456789', 'marek_kowalski@gmail.com', '123456', '1990-01-01', '2023-12-01 10:00:00', 4);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (2, 'Kasia', 'Nowak', '987654321', 'kasia_nowak@gmail.com', '654321', '1995-02-02', '2024-01-10 15:00:00', 5);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (3, 'Tomasz', 'Wiśniewski', '456789123', 'tomasz_wisniewski@gmail.com', '789123', '1988-03-03', '2023-11-20 14:00:00', 6);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (4, 'Anna', 'Lewandowska', '321654987', 'anna_lewandowska@gmail.com', '987654', '1992-04-04', '2023-12-15 11:00:00', 7);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (5, 'Robert', 'Zieliński', '789123456', 'robert_zielinski@gmail.com', '321987', '1985-05-05', '2024-01-25 16:00:00', 8);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (6, 'Monika', 'Kaczmarek', '123789456', 'monika_kaczmarek@gmail.com', '456321', '1991-06-06', '2023-11-30 12:00:00', 9);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (7, 'Tomasz', 'Nowicki', '321987654', 'tomasz_nowicki@gmail.com', '789654', '1987-07-07', '2024-01-05 10:00:00', 10);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (8, 'Katarzyna', 'Pawlak', '987321654', 'katarzyna_pawlak@gmail.com', '654987', '1993-08-08', '2024-02-01 13:00:00', 1);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (9, 'Andrzej', 'Michalski', '456123789', 'andrzej_michalski@gmail.com', '321456', '1989-09-09', '2023-12-10 14:00:00', 2);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, next_visit_date_time, address_id)
            values (10, 'Joanna', 'Wójcik', '789456123', 'joanna_wojcik@gmail.com', '654123', '1986-10-10', '2024-01-20 15:00:00', 3);

-- Wstawianie danych do tabeli visit
insert into visit (id, description, time, doctor_id, patient_id)
            values (1, 'wizyta nfz', '2021-01-01 12:00:00', 1, 1);
insert into visit (id, description, time, doctor_id, patient_id)
            values (2, 'wizyta prywatna', '2021-02-02 13:00:00', 2, 2);
insert into visit (id, description, time, doctor_id, patient_id)
            values (3, 'konsultacja', '2021-03-03 14:00:00', 3, 3);
insert into visit (id, description, time, doctor_id, patient_id)
            values (4, 'badanie', '2021-04-04 15:00:00', 4, 4);
insert into visit (id, description, time, doctor_id, patient_id)
            values (5, 'kontrola', '2021-05-05 16:00:00', 5, 5);
insert into visit (id, description, time, doctor_id, patient_id)
            values (6, 'wizytacja', '2021-06-06 12:00:00', 6, 6);
insert into visit (id, description, time, doctor_id, patient_id)
            values (7, 'leczenie', '2021-07-07 10:00:00', 7, 7);
insert into visit (id, description, time, doctor_id, patient_id)
            values (8, 'wizyta kontrolna', '2021-08-08 13:00:00', 8, 8);
insert into visit (id, description, time, doctor_id, patient_id)
            values (9, 'konsultacja specjalistyczna', '2021-09-09 14:00:00', 9, 9);
insert into visit (id, description, time, doctor_id, patient_id)
            values (10, 'wizyta planowa', '2021-10-10 15:00:00', 10, 10);
insert into visit (id, description, time, doctor_id, patient_id)
            values (11, 'kontrola follow-up', '2022-01-01 13:00:00', 2, 2);

-- Wstawianie danych do tabeli medical_treatment
insert into medical_treatment (id, description, type, visit_id)
            values (1, 'leczenie chirurgiczne', 'USG', 1);
insert into medical_treatment (id, description, type, visit_id)
            values (2, 'konsultacja ogólna', 'GP', 2);
insert into medical_treatment (id, description, type, visit_id)
            values (3, 'konsultacja chirurgiczna', 'SURGEON', 3);
insert into medical_treatment (id, description, type, visit_id)
            values (4, 'badanie dermatologiczne', 'DERMATOLOGIST', 4);
insert into medical_treatment (id, description, type, visit_id)
            values (5, 'konsultacja ogólna', 'GP', 5);
insert into medical_treatment (id, description, type, visit_id)
            values (6, 'konsultacja ogólna', 'GP', 6);
insert into medical_treatment (id, description, type, visit_id)
            values (7, 'leczenie chirurgiczne', 'SURGEON', 7);
insert into medical_treatment (id, description, type, visit_id)
            values (8, 'wizyta okulistyczna', 'OCULIST', 8);
insert into medical_treatment (id, description, type, visit_id)
            values (9, 'badanie dermatologiczne', 'DERMATOLOGIST', 9);
insert into medical_treatment (id, description, type, visit_id)
            values (10, 'konsultacja ogólna', 'GP', 10);
insert into medical_treatment (id, description, type, visit_id)
            values (11, 'follow-up kontrola', 'GP', 11);
