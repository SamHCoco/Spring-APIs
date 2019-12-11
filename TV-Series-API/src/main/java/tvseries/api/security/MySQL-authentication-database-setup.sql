DROP TABLE users;

CREATE TABLE IF NOT EXISTS users(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(15) NOT NULL UNIQUE,
    `password` VARCHAR(15) NOT NULL,
    roles TEXT NOT NULL
);

INSERT INTO users(user_name, `password`, roles) 
	VALUES("dev", "devpassword", "ROLE_USER,ROLE_ADMIN"),
		  ("user1", "password1", "ROLE_USER"),
          ("user2", "password2", "ROLE_USER"),
          ("user3", "password3", "ROLE_USER");