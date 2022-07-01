
CREATE TABLE PESSOA2 (
  ID_PESSOA2 NUMBER NOT NULL,
  nome VARCHAR2(255) NULL,
  data_nascimento DATE,
  cpf VARCHAR2(11) NOT NULL,
  PRIMARY KEY(ID_PESSOA2)
);

CREATE SEQUENCE SEQ_PESSOA2
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


INSERT INTO PESSOA2
(ID_PESSOA2, NOME, DATA_NASCIMENTO, CPF)
VALUES(SEQ_PESSOA2.nextval, 'Maicon Machado Gerardi', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '48863250090');

INSERT INTO PESSOA2
(ID_PESSOA2, NOME, DATA_NASCIMENTO, CPF)
VALUES(SEQ_PESSOA2.nextval, 'Pedro Dantas', TO_DATE('08-09-1980', 'dd-mm-yyyy'), '29629873036');

INSERT INTO PESSOA2
(ID_PESSOA2, NOME, DATA_NASCIMENTO, CPF)
VALUES(SEQ_PESSOA2.nextval, 'Bruna Da Silva', TO_DATE('06-01-1991', 'dd-mm-yyyy'), '01468462067');

INSERT INTO PESSOA2
(ID_PESSOA2, NOME, DATA_NASCIMENTO, CPF)
VALUES(SEQ_PESSOA2.nextval, 'Fernanda Rosa', TO_DATE('06-05-1970', 'dd-mm-yyyy'), '01468462067');



------ contato

CREATE TABLE CONTATO (
  ID_CONTATO NUMBER NOT NULL,
  ID_PESSOA2 NUMBER NOT NULL,
  tipo NUMBER,
  numero VARCHAR2(14),
  descricao VARCHAR2(100),
  PRIMARY KEY(ID_CONTATO),
  CONSTRAINT FK_CONTATO_PESSOA2 FOREIGN KEY (ID_PESSOA2) REFERENCES PESSOA2 (ID_PESSOA2)
);


CREATE SEQUENCE SEQ_CONTATO
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

-- contatos do maicon
INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA2, TIPO, NUMERO, DESCRICAO)
VALUES(SEQ_CONTATO.nextval, 1, 1, '51955565585', 'whatsapp');

INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA2, TIPO, NUMERO, DESCRICAO)
VALUES(SEQ_CONTATO.nextval, 1, 2, '48335698566', 'trabalho');

-- contatos do pedro
INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA2, TIPO, NUMERO, DESCRICAO)
VALUES(SEQ_CONTATO.nextval, 2, 1, '51955565585', 'celular');

INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA2, TIPO, NUMERO, DESCRICAO)
VALUES(SEQ_CONTATO.nextval, 2, 2, '48335698566', 'casa');

-- contatos da bruna
INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA2, TIPO, NUMERO, DESCRICAO)
VALUES(SEQ_CONTATO.nextval, 3, 1, '51995866695', 'whatsapp');

-- contatos da bruna
INSERT INTO CONTATO
(ID_CONTATO, ID_PESSOA2, TIPO, NUMERO, DESCRICAO)
VALUES(SEQ_CONTATO.nextval, 3, 1, '51995866695', 'whatsapp');

-- contatos da fernanda



------- endereço
CREATE TABLE ENDERECO_PESSOA2 (
  ID_ENDERECO2 NUMBER NOT NULL,
  tipo NUMBER NOT NULL,
  logradouro VARCHAR2(200) NOT NULL,
  numero NUMBER NOT NULL,
  complemento VARCHAR2(200) NULL,
  cep VARCHAR2(8) NOT NULL,
  cidade VARCHAR2(300) NOT NULL,
  estado VARCHAR2(100) NOT NULL,
  pais VARCHAR2(100) NOT NULL,
  PRIMARY KEY(ID_ENDERECO2)
);

CREATE SEQUENCE SEQ_ENDERECO_CONTATO
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


INSERT INTO ENDERECO_PESSOA2
(ID_ENDERECO2, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(SEQ_ENDERECO_CONTATO.nextval, 1, 'Rua José Dos Santos', 120, 'casa', '88080700', 'Florianópolis', 'SC', 'Brasil');

INSERT INTO ENDERECO_PESSOA2
(ID_ENDERECO2, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(SEQ_ENDERECO_CONTATO.nextval, 2, 'Rua Pedro Canvas', 800, 'apto 2', '88805500', 'Porto Alegre', 'RS', 'Brasil');

INSERT INTO ENDERECO_PESSOA2
(ID_ENDERECO2, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(SEQ_ENDERECO_CONTATO.nextval, 1, 'Rua Pedro Fantin', 800, 'apt 52', '88080700', 'Florianópolis', 'SC', 'Brasil');

INSERT INTO ENDERECO_PESSOA2
(ID_ENDERECO2, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(SEQ_ENDERECO_CONTATO.nextval, 1, 'Rua Mario Quintana', 50, NULL, '88805800', 'Santos', 'SP', 'Brasil');

INSERT INTO ENDERECO_PESSOA2
(ID_ENDERECO2, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(SEQ_ENDERECO_CONTATO.nextval, 2, 'Avenida Brasil', 1855, NULL, '88754566', 'Rio De Janeiro', 'RJ', 'Brasil');

INSERT INTO ENDERECO_PESSOA2
(ID_ENDERECO2, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, CIDADE, ESTADO, PAIS)
VALUES(SEQ_ENDERECO_CONTATO.nextval, 1, 'Avenida Luis Carvalho', 444, NULL, '88987788', 'Rio De Janeiro', 'RJ', 'Brasil');


CREATE TABLE PESSOA2_X_PESSOA_ENDERECO (
  ID_PESSOA2 NUMBER NOT NULL,
  ID_ENDERECO2 NUMBER NOT NULL,
  PRIMARY KEY(ID_PESSOA2, ID_ENDERECO2),
  CONSTRAINT FK_CE_PESSOA2 FOREIGN KEY (ID_PESSOA2) REFERENCES PESSOA2 (ID_PESSOA2),
  CONSTRAINT FK_CE_ENDERECO_PESSOA2 FOREIGN KEY (ID_ENDERECO2) REFERENCES ENDERECO_PESSOA2 (ID_ENDERECO2)
);


-- enderecos maicon
INSERT INTO PESSOA2_X_PESSOA_ENDERECO
(ID_PESSOA2, ID_ENDERECO2)
VALUES(1, 1);

INSERT INTO PESSOA2_X_PESSOA_ENDERECO
(ID_PESSOA2, ID_ENDERECO2)
VALUES(1, 2);

INSERT INTO PESSOA2_X_PESSOA_ENDERECO
(ID_PESSOA2, ID_ENDERECO2)
VALUES(1, 3);

-- enderecos bruna
INSERT INTO PESSOA2_X_PESSOA_ENDERECO
(ID_PESSOA2, ID_ENDERECO2)
VALUES(3, 3);

-- fernanda
INSERT INTO PESSOA2_X_PESSOA_ENDERECO
(ID_PESSOA2, ID_ENDERECO2)
VALUES(4, 4);

INSERT INTO PESSOA2_X_PESSOA_ENDERECO
(ID_PESSOA2, ID_ENDERECO2)
VALUES(4, 5);

-----homework 
SELECT *
FROM PESSOA2 p 
RIGHT OUTER JOIN CONTATO c ON (p.ID_PESSOA2 = c.ID_PESSOA2);

SELECT pxpe.ID_PESSOA2, p.NOME, ep.LOGRADOURO
FROM PESSOA2 p
RIGHT OUTER JOIN PESSOA2_X_PESSOA_ENDERECO pxpe ON (pxpe.ID_PESSOA2 = p.ID_PESSOA2)
RIGHT OUTER JOIN ENDERECO_PESSOA2 ep ON (ep.ID_ENDERECO2 = pxpe.ID_ENDERECO2);

SELECT p.NOME, c.NUMERO, ep.LOGRADOURO, pxpe.ID_PESSOA2
FROM PESSOA2 p 
RIGHT OUTER JOIN CONTATO c ON (c.ID_PESSOA2 = p.ID_PESSOA2)
RIGHT OUTER JOIN PESSOA2_X_PESSOA_ENDERECO pxpe ON (pxpe.ID_PESSOA2 = p.ID_PESSOA2)
RIGHT OUTER JOIN ENDERECO_PESSOA2 ep ON (ep.ID_ENDERECO2 = pxpe.ID_ENDERECO2);

SELECT *
FROM PESSOA2 p
FULL OUTER JOIN CONTATO c ON (p.ID_PESSOA2 = c.ID_PESSOA2);

SELECT pxpe.ID_PESSOA2, p.NOME, ep.LOGRADOURO 
FROM PESSOA2 p
FULL OUTER JOIN PESSOA2_X_PESSOA_ENDERECO pxpe ON (pxpe.ID_PESSOA2 = p.ID_PESSOA2) 
FULL OUTER JOIN ENDERECO_PESSOA2 ep ON (ep.ID_ENDERECO2 = pxpe.ID_ENDERECO2);

SELECT p.NOME, c.NUMERO, ep.LOGRADOURO, pxpe.ID_PESSOA2
FROM PESSOA2 p
FULL OUTER JOIN CONTATO c ON (c.ID_PESSOA2 = p.ID_PESSOA2)
FULL OUTER JOIN PESSOA2_X_PESSOA_ENDERECO pxpe ON (pxpe.ID_PESSOA2 = p.ID_PESSOA2)
FULL OUTER JOIN ENDERECO_PESSOA2 ep ON (ep.ID_ENDERECO2 = pxpe.ID_ENDERECO2);

SELECT p.NOME, p.ID_PESSOA2
FROM PESSOA2 p 
WHERE EXISTS (SELECT pxpe.ID_PESSOA2
						FROM PESSOA2_X_PESSOA_ENDERECO pxpe
						WHERE pxpe.ID_PESSOA2 = p.ID_PESSOA2);
					
SELECT p.NOME, p.ID_PESSOA2, ep.ID_ENDERECO2, ep.LOGRADOURO
FROM PESSOA2 p
FULL JOIN PESSOA2_X_PESSOA_ENDERECO pxpe ON (p.ID_PESSOA2 = pxpe.ID_PESSOA2)
FULL JOIN ENDERECO_PESSOA2 ep ON (pxpe.ID_ENDERECO2 = ep.ID_ENDERECO2);