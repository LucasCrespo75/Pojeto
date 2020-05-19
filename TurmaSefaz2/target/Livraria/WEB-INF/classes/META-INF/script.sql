DROP TABLE fuctura.hospital;

--Primeiro devemos adicionar a nossa chave primária.
--criar a tabela adicionando o ID como atributo identificado
CREATE TABLE fuctura.hospital (
    id     INT,     --atributo identificador
    nome_fantasia   VARCHAR(100), --like
    cnpj            VARCHAR(100), --like
    data_abertura   DATE,
    razao_social    VARCHAR(200), --like
    capacidade      INT,
    CONSTRAINT hospital_pk PRIMARY KEY ( id ) -- adicionando ID como atributo identificado. 
);


--Segundo criamos a tabela de de controle de sequencia. 
--Esta tabelas nos fornecerá um conjunto de número em sequencia começando com 1. Ou seja: 1,2,3,4,...999999999
DROP SEQUENCE fuctura.hospital_seq; --_seq é só nomenclatura para ajudar na leitura.
CREATE SEQUENCE fuctura.hospital_seq START WITH 1; --informar que o primeiro elemento da tabela será 1. O incremento padrão é 1.


--Por último, criaremos uma trigger ou um gatilho que toda vez que nós chamamos o comando de insert.
--Este gatinho será invocado e irá pegar o próximo número sequência da nossa sequence.
CREATE OR REPLACE TRIGGER fuctura.hospital_bir BEFORE --_bir é só nomenclatura para ajudar na leitura.
    INSERT ON fuctura.hospital
    FOR EACH ROW
BEGIN
    SELECT
        fuctura.hospital_seq.NEXTVAL
    INTO :new.id --bater com o nome da chave primaria, utilizada no create. Neste caso é ID.
    FROM
        dual;
END;
/


--Sempre que for inserir na tabela você deve informar as colunas
INSERT INTO fuctura.hospital(
    nome_fantasia, 
    cnpj, 
    data_abertura,
    razao_social, 
    capacidade
) VALUES (
    'Hospital Alfa',
    '03.337.575/0001-92',
    '18-04-2019',
    'Hospital Alfa',
    100
);

-- Scripts para criação do projeto --


CREATE TABLE usuario (
ID_CPF INT PRIMARY KEY,
email VARCHAR(100),
senha VARCHAR(100)
);

drop table veiculo ;
CREATE TABLE veiculo (
nome VARCHAR(100),
ID_modelo VARCHAR(100) PRIMARY KEY,
ano DATE
);

drop table pecas;
CREATE TABLE pecas(
ID_nome VARCHAR(100),
marca_peca VARCHAR(100),
ano_peca DATE,
marca_veiculo VARCHAR(100) PRIMARY KEy
);

ALTER TABLE pecas
ADD FOREIGN KEY (marca_veiculo) 
REFERENCES veiculo(ID_modelo);
     

CREATE SEQUENCE S_PECAS 
	MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;


