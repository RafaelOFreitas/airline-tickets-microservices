-- Aeronaves para GOL
insert into tb_aeronave (data_ultima_atualizacao_aeronave, data_registro_aeronave, modelo_aeronave, status_aeronave, tipo_aeronave, fk_companhia, fk_rota, matricula_aeronave)
values (timezone('utc', now()), timezone('utc', now()), 'BOEING 737-700', 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 1, 'PR-GOLA'),
       (timezone('utc', now()), timezone('utc', now()), 'BOEING 737-700', 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 2, 'PR-GOLB'),
       (timezone('utc', now()), timezone('utc', now()), 'BOEING 737-800', 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 3, 'PR-GOLC'),
       (timezone('utc', now()), timezone('utc', now()), 'BOEING 737-800', 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 4, 'PR-GOLD'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 737 MAX', 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 5, 'PR-GOLE'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 737 MAX', 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 6, 'PR-GOLF'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 737 MAX', 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 1, 'PR-GOLG'),
       (timezone('utc', now()), timezone('utc', now()), 'Praetor 500', 'ATIVA', 'EXECUTIVA', '23a7dc61-9342-4775-8a94-3461445c7b29', 7, 'PR-GOLF');

insert into tb_secao (matricula_aeronave, fk_companhia, fk_rota, quantidade_fila_secao, quantidade_assento_secao, classe_secao)
values ('PR-GOLA', '23a7dc61-9342-4775-8a94-3461445c7b29', 1, 10, 4, 'PRIMEIRA'),
       ('PR-GOLA', '23a7dc61-9342-4775-8a94-3461445c7b29', 1, 14, 6, 'ECONOMICA'),
       ('PR-GOLB', '23a7dc61-9342-4775-8a94-3461445c7b29', 2, 10, 4, 'PRIMEIRA'),
       ('PR-GOLB', '23a7dc61-9342-4775-8a94-3461445c7b29', 2, 14, 6, 'ECONOMICA'),
       ('PR-GOLC', '23a7dc61-9342-4775-8a94-3461445c7b29', 3, 3, 3, 'EXECUTIVA'),
       ('PR-GOLC', '23a7dc61-9342-4775-8a94-3461445c7b29', 3, 10, 4, 'PRIMEIRA'),
       ('PR-GOLC', '23a7dc61-9342-4775-8a94-3461445c7b29', 3, 20, 6, 'ECONOMICA'),
       ('PR-GOLD', '23a7dc61-9342-4775-8a94-3461445c7b29', 4, 3, 3, 'EXECUTIVA'),
       ('PR-GOLD', '23a7dc61-9342-4775-8a94-3461445c7b29', 4, 10, 4, 'PRIMEIRA'),
       ('PR-GOLD', '23a7dc61-9342-4775-8a94-3461445c7b29', 4, 20, 6, 'ECONOMICA'),
       ('PR-GOLE', '23a7dc61-9342-4775-8a94-3461445c7b29', 5, 3, 3, 'EXECUTIVA'),
       ('PR-GOLE', '23a7dc61-9342-4775-8a94-3461445c7b29', 5, 10, 4, 'PRIMEIRA'),
       ('PR-GOLE', '23a7dc61-9342-4775-8a94-3461445c7b29', 5, 20, 6, 'ECONOMICA'),
       ('PR-GOLF', '23a7dc61-9342-4775-8a94-3461445c7b29', 6, 3, 3, 'EXECUTIVA'),
       ('PR-GOLF', '23a7dc61-9342-4775-8a94-3461445c7b29', 6, 10, 4, 'PRIMEIRA'),
       ('PR-GOLF', '23a7dc61-9342-4775-8a94-3461445c7b29', 6, 20, 6, 'ECONOMICA'),
       ('PR-GOLF', '23a7dc61-9342-4775-8a94-3461445c7b29', 7, 2, 3, 'EXECUTIVA');

-- Aeronaves para TAM
insert into tb_aeronave (data_ultima_atualizacao_aeronave, data_registro_aeronave, modelo_aeronave, status_aeronave, tipo_aeronave, fk_companhia, fk_rota, matricula_aeronave)
values (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 'PT-MHCA'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 8, 'PT-MHCB'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 9, 'PT-MHCC'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 10, 'PT-MHCD'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 11, 'PT-MHCE'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 12, 'PT-MHCF'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 320-200', 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 'PT-MHCG'),
       (timezone('utc', now()), timezone('utc', now()), 'Praetor 500', 'ATIVA', 'EXECUTIVA', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 'PT-MHCH');

insert into tb_secao (matricula_aeronave, fk_companhia, fk_rota, quantidade_fila_secao, quantidade_assento_secao, classe_secao)
values ('PT-MHCA', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 10, 4, 'PRIMEIRA'),
       ('PT-MHCA', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 14, 6, 'ECONOMICA'),
       ('PT-MHCB', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 8, 10, 4, 'PRIMEIRA'),
       ('PT-MHCB', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 8, 14, 6, 'ECONOMICA'),
       ('PT-MHCC', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 9, 3, 3, 'EXECUTIVA'),
       ('PT-MHCC', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 9, 10, 4, 'PRIMEIRA'),
       ('PT-MHCC', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 9, 20, 6, 'ECONOMICA'),
       ('PT-MHCD', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 10, 3, 3, 'EXECUTIVA'),
       ('PT-MHCD', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 10, 10, 4, 'PRIMEIRA'),
       ('PT-MHCD', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 10, 20, 6, 'ECONOMICA'),
       ('PT-MHCE', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 11, 3, 3, 'EXECUTIVA'),
       ('PT-MHCE', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 11, 10, 4, 'PRIMEIRA'),
       ('PT-MHCE', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 11, 20, 6, 'ECONOMICA'),
       ('PT-MHCF', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 12, 3, 3, 'EXECUTIVA'),
       ('PT-MHCF', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 12, 10, 4, 'PRIMEIRA'),
       ('PT-MHCF', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 12, 20, 6, 'ECONOMICA'),
       ('PT-MHCH', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 2, 3, 'EXECUTIVA');

-- Aeronaves para Azul
insert into tb_aeronave (data_ultima_atualizacao_aeronave, data_registro_aeronave, modelo_aeronave, status_aeronave, tipo_aeronave, fk_companhia, fk_rota, matricula_aeronave)
values (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 13, 'AZ-MHCA'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 14, 'AZ-MHCB'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 15, 'AZ-MHCC'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 16, 'AZ-MHCD'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 17, 'AZ-MHCE'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321','ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 18, 'AZ-MHCF'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 320', 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 13, 'AZ-MHCG'),
       (timezone('utc', now()), timezone('utc', now()), 'Praetor 600', 'ATIVA', 'EXECUTIVA', '774ccac5-32b4-4266-a47f-2e1604c15218', 14, 'AZ-MHCH');

-- Aeronaves para Latam
insert into tb_aeronave (data_ultima_atualizacao_aeronave, data_registro_aeronave, modelo_aeronave, status_aeronave, tipo_aeronave, fk_companhia, fk_rota, matricula_aeronave)
values (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 19, 'PM-MHCA'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 20, 'PM-MHCB'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 21, 'PM-MHCC'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 22, 'PM-MHCD'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 23, 'PM-MHCE'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 24, 'PM-MHCF'),
       (timezone('utc', now()), timezone('utc', now()), 'Phenom-300e', 'ATIVA', 'EXECUTIVA', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 19, 'PM-MHCG');