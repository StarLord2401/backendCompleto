-- Inserções para a tabela 'Usuario' (não dependem de outras tabelas)
INSERT INTO Usuario(nome, login, senha, access_level) VALUES('Gabriel Kaizer', 'kaizer', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'ADMIN');
INSERT INTO Usuario(nome, login, senha, access_level) VALUES('Leo Soares', 'soares', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'ADMIN');

-- Inserções para a tabela 'Jogo' (dependem de 'Usuario')
INSERT INTO Jogo(nome, descricao, tamanho_baralho, usuario_id) VALUES('Jogo de Cartas', 'Um jogo divertido de cartas', 52, (SELECT id FROM Usuario WHERE login = 'kaizer'));
INSERT INTO Jogo(nome, descricao, tamanho_baralho, usuario_id) VALUES('Jogo de Tabuleiro', 'Um jogo clássico de tabuleiro', 30, (SELECT id FROM Usuario WHERE login = 'soares'));

-- Inserções para a tabela 'Frame' (dependem de 'Jogo')
INSERT INTO Frame(path, jogo_id) VALUES('path 1', (SELECT id FROM Jogo WHERE nome = 'Jogo de Cartas'));
INSERT INTO Frame(path, jogo_id) VALUES('path 2', (SELECT id FROM Jogo WHERE nome = 'Jogo de Tabuleiro'));
