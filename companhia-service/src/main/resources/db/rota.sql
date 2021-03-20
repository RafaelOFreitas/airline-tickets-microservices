-- Rotas para GOL
insert into tb_rota (fk_companhia, data_ultima_atualizacao_rota, data_registro_rota, destino_rota, origem_rota)
values ('23a7dc61-9342-4775-8a94-3461445c7b29', timezone('utc', now()), timezone('utc', now()), 'Aracaju (AJU)', 'Araçatuba (ARU)'),
       ('23a7dc61-9342-4775-8a94-3461445c7b29', timezone('utc', now()), timezone('utc', now()), 'Araçatuba (ARU)', 'São Paulo (GRU)'),
       ('23a7dc61-9342-4775-8a94-3461445c7b29', timezone('utc', now()), timezone('utc', now()), 'Vitória (VIX)', 'Salvador (SSA)'),
       ('23a7dc61-9342-4775-8a94-3461445c7b29', timezone('utc', now()), timezone('utc', now()), 'Porto Alegre (POA)', 'Guarulhos (GRU)'),
       ('23a7dc61-9342-4775-8a94-3461445c7b29', timezone('utc', now()), timezone('utc', now()), 'Recife (REC)', 'Guarulhos (GRU)'),
       ('23a7dc61-9342-4775-8a94-3461445c7b29', timezone('utc', now()), timezone('utc', now()), 'Uberlândia (UDI)', 'Guarulhos (GRU)');

-- Rotas para TAM
insert into tb_rota (fk_companhia, data_ultima_atualizacao_rota, data_registro_rota, destino_rota, origem_rota)
values ('f8f82c6f-4bbf-4f51-917b-aac25538d738', timezone('utc', now()), timezone('utc', now()), 'Aracaju (AJU)', 'Araçatuba (ARU)'),
       ('f8f82c6f-4bbf-4f51-917b-aac25538d738', timezone('utc', now()), timezone('utc', now()), 'Araçatuba (ARU)', 'São Paulo (GRU)'),
       ('f8f82c6f-4bbf-4f51-917b-aac25538d738', timezone('utc', now()), timezone('utc', now()), 'Vitória (VIX)', 'Salvador (SSA)'),
       ('f8f82c6f-4bbf-4f51-917b-aac25538d738', timezone('utc', now()), timezone('utc', now()), 'Porto Alegre (POA)', 'Guarulhos (GRU)'),
       ('f8f82c6f-4bbf-4f51-917b-aac25538d738', timezone('utc', now()), timezone('utc', now()), 'Recife (REC)', 'Guarulhos (GRU)'),
       ('f8f82c6f-4bbf-4f51-917b-aac25538d738', timezone('utc', now()), timezone('utc', now()), 'Uberlândia (UDI)', 'Guarulhos (GRU)');

-- Rotas para Azul
insert into tb_rota (fk_companhia, data_ultima_atualizacao_rota, data_registro_rota, destino_rota, origem_rota)
values ('774ccac5-32b4-4266-a47f-2e1604c15218', timezone('utc', now()), timezone('utc', now()), 'Belém (BEL)', 'São Luís (SLZ)'),
       ('774ccac5-32b4-4266-a47f-2e1604c15218', timezone('utc', now()), timezone('utc', now()), 'Belo Horizonte (CNF)', 'Rio de Janeiro (SDU)'),
       ('774ccac5-32b4-4266-a47f-2e1604c15218', timezone('utc', now()), timezone('utc', now()), 'Brasília (BSB)', 'São Paulo/Campinas (VCP)'),
       ('774ccac5-32b4-4266-a47f-2e1604c15218', timezone('utc', now()), timezone('utc', now()), 'Florianópolis (FLN)', 'São Paulo/Campinas (VCP)'),
       ('774ccac5-32b4-4266-a47f-2e1604c15218', timezone('utc', now()), timezone('utc', now()), 'Goiânia (GYN)', 'Palmas (PMW)'),
       ('774ccac5-32b4-4266-a47f-2e1604c15218', timezone('utc', now()), timezone('utc', now()), 'Juazeiro do Norte (JDO)', 'Recife (REC)');

-- Rotas para Latam
insert into tb_rota (fk_companhia, data_ultima_atualizacao_rota, data_registro_rota, destino_rota, origem_rota)
values ('a0ce4bda-317e-406e-8392-ba7ca282e626', timezone('utc', now()), timezone('utc', now()), 'Chapecó (XAP)', 'São Paulo (GRU)'),
       ('a0ce4bda-317e-406e-8392-ba7ca282e626', timezone('utc', now()), timezone('utc', now()), 'Cuiabá (CGB)', 'Brasília (BSB)'),
       ('a0ce4bda-317e-406e-8392-ba7ca282e626', timezone('utc', now()), timezone('utc', now()), 'Belém (BEL)', 'Brasília (BSB)'),
       ('a0ce4bda-317e-406e-8392-ba7ca282e626', timezone('utc', now()), timezone('utc', now()), 'Campo Grande (CGR)', 'São Paulo (CGH)'),
       ('a0ce4bda-317e-406e-8392-ba7ca282e626', timezone('utc', now()), timezone('utc', now()), 'Fortaleza (FOR)', 'Rio de Janeiro (GIG)'),
       ('a0ce4bda-317e-406e-8392-ba7ca282e626', timezone('utc', now()), timezone('utc', now()), 'Ilhéus (IOS)', 'São Paulo (CGH)');