create table contrato (id bigint NOT NULL AUTO_INCREMENT, 
                       val_mensl_pri_faixa_lucro DECIMAL(19,2) DEFAULT NULL, 
                       val_mensl_seg_faixa_lucro DECIMAL(19,2) DEFAULT NULL, 
                       val_mensl_ter_faixa_lucro DECIMAL(19,2) DEFAULT NULL,  
                       val_final DECIMAL(19,2) DEFAULT NULL,
                       qntd_lojas bigint not null, 
                       contratada_id bigint not null, 
                       contratante_id bigint not null, 
                       primeira_testemunha_id bigint not null, 
                       segunda_testemunha_id bigint not null, 
                       valor_por_extenso varchar(255) not null,
                       data_inicio date,
                       primary key (id)) engine=InnoDB;

