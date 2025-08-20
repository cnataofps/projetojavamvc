DROP DATABASE IF EXISTS bdProdutos;

CREATE DATABASE bdProduto;

SHOW DATABASES;

USE bdProduto;


DROP TABLE IF EXISTS produtos;

CREATE TABLE produtos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  descricao varchar(255) DEFAULT NULL,
  quantidade int DEFAULT NULL,
  valor double DEFAULT NULL,
  PRIMARY KEY (id)
);


LOCK TABLES produtos WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;

INSERT INTO produtos VALUES
(1,'Teclado','Teclado Gamer Fallen',50, 250),
(2,'Mouse','Mouse Gamer Logitech',15, 700),
(3,'Mouse Pad','Mouse Pad Gamer Hyperx', 100, 287),
(4,'Monitor','Monitor Gamer 244hz', 59, 2000);

/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

SELECT * FROM produtos;
