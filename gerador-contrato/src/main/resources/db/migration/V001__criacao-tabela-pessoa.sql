create table pessoa (id bigint NOT NULL UNIQUE AUTO_INCREMENT, 
                     cpf varchar(255) not null UNIQUE, 
                     nome varchar(255) not null,                   
                     primary key (id)) engine=InnoDB;
