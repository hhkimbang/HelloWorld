CREATE TABLE IF NOT EXISTS book_class (
	class_id INT NOT NULL,
	class_type INT NOT NULL,
	class_description VARCHAR(100) 
	)
DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE book_class ADD CONSTRAINT class_pk PRIMARY KEY (class_id);

INSERT INTO book_class (class_id, class_type, class_description) VALUES 
	(1, 1, 'sach giao khoa'),
	(2, 2, 'sach tham khao');