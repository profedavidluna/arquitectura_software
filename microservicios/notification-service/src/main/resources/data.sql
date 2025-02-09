INSERT INTO Notificacion (id, email, mensaje) VALUES (1, 'usuario1@gmail.com','Mensaje Pendiente');
INSERT INTO Notificacion (id, email, mensaje) VALUES (2, 'usuario2@gmail.com','Mensaje Pendiente');
INSERT INTO Notificacion (id, email, mensaje) VALUES (3, 'usuario3@gmail.com','Mensaje Pendiente');
ALTER TABLE Notificacion ALTER COLUMN ID RESTART WITH 4;



