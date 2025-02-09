INSERT INTO Pedido (id, cliente_id, productos_ids, estado) VALUES (1, 1, '1,2','Pendiente');
INSERT INTO Pedido (id, cliente_id, productos_ids, estado) VALUES (2, 1, '3,2,4','Pendiente');
INSERT INTO Pedido (id, cliente_id, productos_ids, estado) VALUES (3, 2, '1,2','Pendiente');
INSERT INTO Pedido (id, cliente_id, productos_ids, estado) VALUES (4, 2, '3,2','Pendiente');
INSERT INTO Pedido (id, cliente_id, productos_ids, estado) VALUES (5, 3, '1,2,4','Pendiente');
ALTER TABLE Pedido ALTER COLUMN ID RESTART WITH 6;



