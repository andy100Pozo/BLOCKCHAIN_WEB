INSERT INTO userdetail (username, password, rol, nomcompleto, dni, saldo, firmadigital, email) VALUES
('admin', '123', 'ADMIN', 'Admin', '12345678', 1000, 'firma1', 'xxxxxxxxxx@gmail.com'),
('hernan', '123', 'USER', 'hernan jesus', '11111111', 500, 'firma2', 'rodriguez100hernan@gmail.com'),
('lucia', '123', 'USER', 'Lucia Garcia', '22222222', 600, 'firma3', 'lucia.garcia@mail.com'),
('juan', '123', 'USER', 'Juan Torres', '33333333', 700, 'firma4', 'juan.torres@mail.com'),
('maria', '123', 'USER', 'Maria Flores', '44444444', 800, 'firma5', 'maria.flores@mail.com'),
('andres', '123', 'USER', 'Andres Soto', '55555555', 900, 'firma6', 'andres.soto@mail.com');


-- Mineros
INSERT INTO miner (nombre, dni, clave) VALUES
('Miner Uno', '00011122', 'clave1'),
('Miner Dos', '00022233', 'clave2'),
('Miner Tres', '00033344', 'clave3');
