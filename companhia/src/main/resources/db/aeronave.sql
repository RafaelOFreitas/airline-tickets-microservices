-- Aeronaves para GOL
insert into tb_aeronave (data_ultima_atualizacao_aeronave, data_registro_aeronave, modelo_aeronave, quantidade_assento_fila_aeronave, quantidade_fila_aeronave, status_aeronave, tipo_aeronave, fk_companhia, fk_rota, matricula_aeronave)
values (timezone('utc', now()), timezone('utc', now()), 'BOEING 737-700', 6, 24, 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 1, 'PT-MHCA'),
       (timezone('utc', now()), timezone('utc', now()), 'BOEING 737-700', 6, 24, 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 2, 'PR-GOLB'),
       (timezone('utc', now()), timezone('utc', now()), 'BOEING 737-800', 6, 33, 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 3, 'PR-GOLC'),
       (timezone('utc', now()), timezone('utc', now()), 'BOEING 737-800', 6, 33, 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 4, 'PR-GOLD'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 737 MAX', 6, 33, 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 5, 'PR-GOLE'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 737 MAX', 6, 33, 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 6, 'PR-GOLF'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 737 MAX', 6, 33, 'ATIVA', 'COMERCIAL', '23a7dc61-9342-4775-8a94-3461445c7b29', 1, 'PR-GOLG'),
       (timezone('utc', now()), timezone('utc', now()), 'Praetor 500', 2, 3, 'ATIVA', 'EXECUTIVA', '23a7dc61-9342-4775-8a94-3461445c7b29', 7, 'PR-MHCH');

-- Aeronaves para TAM
insert into tb_aeronave (data_ultima_atualizacao_aeronave, data_registro_aeronave, modelo_aeronave, quantidade_assento_fila_aeronave, quantidade_fila_aeronave, status_aeronave, tipo_aeronave, fk_companhia, fk_rota, matricula_aeronave)
values (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 6, 24, 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 'PT-MHCA'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 6, 24, 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 8, 'PT-MHCB'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 6, 33, 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 9, 'PT-MHCC'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 6, 33, 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 10, 'PT-MHCD'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 6, 33, 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 11, 'PT-MHCE'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 6, 20, 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 12, 'PT-MHCF'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 320-200', 6, 20, 'ATIVA', 'COMERCIAL', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 'PT-MHCG'),
       (timezone('utc', now()), timezone('utc', now()), 'Praetor 500', 2, 3, 'ATIVA', 'EXECUTIVA', 'f8f82c6f-4bbf-4f51-917b-aac25538d738', 7, 'PT-MHCH');

-- Aeronaves para Azul
insert into tb_aeronave (data_ultima_atualizacao_aeronave, data_registro_aeronave, modelo_aeronave, quantidade_assento_fila_aeronave, quantidade_fila_aeronave, status_aeronave, tipo_aeronave, fk_companhia, fk_rota, matricula_aeronave)
values (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 6, 24, 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 13, 'AZ-MHCA'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 6, 24, 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 14, 'AZ-MHCB'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 6, 33, 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 15, 'AZ-MHCC'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 6, 33, 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 16, 'AZ-MHCD'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 6, 33, 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 17, 'AZ-MHCE'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 6, 20, 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 18, 'AZ-MHCF'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 320', 6, 20, 'ATIVA', 'COMERCIAL', '774ccac5-32b4-4266-a47f-2e1604c15218', 13, 'AZ-MHCG'),
       (timezone('utc', now()), timezone('utc', now()), 'Praetor 600', 2, 2, 'ATIVA', 'EXECUTIVA', '774ccac5-32b4-4266-a47f-2e1604c15218', 14, 'AZ-MHCH');

-- Aeronaves para Latam
insert into tb_aeronave (data_ultima_atualizacao_aeronave, data_registro_aeronave, modelo_aeronave, quantidade_assento_fila_aeronave, quantidade_fila_aeronave, status_aeronave, tipo_aeronave, fk_companhia, fk_rota, matricula_aeronave)
values (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 6, 24, 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 19, 'PM-MHCA'),
       (timezone('utc', now()), timezone('utc', now()), 'Boeing 767-300', 6, 24, 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 20, 'PM-MHCB'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 6, 33, 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 21, 'PM-MHCC'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 350', 6, 33, 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 22, 'PM-MHCD'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 6, 33, 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 23, 'PM-MHCE'),
       (timezone('utc', now()), timezone('utc', now()), 'Airbus 321', 6, 20, 'ATIVA', 'COMERCIAL', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 24, 'PM-MHCF'),
       (timezone('utc', now()), timezone('utc', now()), 'Phenom-300e', 2, 3, 'ATIVA', 'EXECUTIVA', 'a0ce4bda-317e-406e-8392-ba7ca282e626', 19, 'PM-MHCG');