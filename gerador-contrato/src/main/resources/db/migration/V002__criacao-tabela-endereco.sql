create table endereco (id bigint NOT NULL AUTO_INCREMENT , 
                       endereco_descricao varchar(255) not null, 
                       numero varchar(255) not null,  
                       cidade varchar(255) not null, 
                       uf varchar(255) not null, 
                       cep varchar(255) not null,
                        primary key (id)) engine=InnoDB;

