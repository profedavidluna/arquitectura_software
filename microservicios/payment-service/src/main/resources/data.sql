INSERT INTO Pago(id, pedido_id, monto,estado) VALUES (1, 1,900,'Pendiente');
INSERT INTO Pago(id, pedido_id, monto,estado) VALUES (2, 2,278,'Pendiente');
INSERT INTO Pago(id, pedido_id, monto,estado) VALUES (3, 3,765,'Pendiente');
INSERT INTO Pago(id, pedido_id, monto,estado) VALUES (4, 4,1260,'Pendiente');
ALTER TABLE Pago ALTER COLUMN ID RESTART WITH 5;
