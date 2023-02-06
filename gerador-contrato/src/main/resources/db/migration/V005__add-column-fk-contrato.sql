ALTER TABLE `testeselecao`.`contrato` 
ADD INDEX `fk_contrato_empresa_contratante_idx` (`contratante_id` ASC);
;
ALTER TABLE `testeselecao`.`contrato` 
ADD CONSTRAINT `fk_contrato_empresa_contratante`
  FOREIGN KEY (`contratante_id`)
  REFERENCES `testeselecao`.`empresa` (`id`);
  
  
  
ALTER TABLE `testeselecao`.`contrato` 
ADD INDEX `fk_contrato_empresa_contratada_idx` (`contratante_id` ASC);
;
ALTER TABLE `testeselecao`.`contrato` 
ADD CONSTRAINT `fk_contrato_empresa_contratada`
  FOREIGN KEY (`contratada_id`)
  REFERENCES `testeselecao`.`empresa` (`id`);
  
ALTER TABLE `testeselecao`.`contrato` 
ADD INDEX `fk_contrato_primeira_testemunha_idx` (`primeira_testemunha_id` ASC);
;
ALTER TABLE `testeselecao`.`contrato` 
ADD CONSTRAINT `fk_contrato_primeira_testemunha`
  FOREIGN KEY (`primeira_testemunha_id`)
  REFERENCES `testeselecao`.`pessoa` (`id`);
  
ALTER TABLE `testeselecao`.`contrato` 
ADD INDEX `fk_contrato_segunda_testemunha_idx` (`segunda_testemunha_id` ASC);
;
ALTER TABLE `testeselecao`.`contrato` 
ADD CONSTRAINT `fk_contrato_segunda_testemunha`
  FOREIGN KEY (`segunda_testemunha_id`)
  REFERENCES `testeselecao`.`pessoa` (`id`);









