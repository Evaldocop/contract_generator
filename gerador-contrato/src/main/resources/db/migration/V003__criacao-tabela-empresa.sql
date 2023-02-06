create table empresa (id bigint NOT NULL UNIQUE AUTO_INCREMENT , 
                       razao_social varchar(255), 
                       nome_fantasia varchar(255), 
                       cnpj varchar(255) UNIQUE, 
                       endereco_id bigint, 
                          primary key (id)) engine=InnoDB;
                       
alter table empresa  add constraint fk_empresa_endereco 
foreign key(endereco_id) references endereco (id);

