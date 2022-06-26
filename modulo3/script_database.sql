Use db_projeto;

Create table tb_paciente(
		id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(40),
        usuario varchar(10),
        senha varchar(20),
        cpf  varchar(20),
        endereco varchar(40),
        cel varchar(10),
        nome_pet varchar(40),
        idade_pet int, 
        raca varchar(10),
        descricao varchar(200)
        
        

)

SELECT * FROM tb_paciente;

INSERT INTO tb_paciente(usuario, senha) VALUES("admin", "12345");