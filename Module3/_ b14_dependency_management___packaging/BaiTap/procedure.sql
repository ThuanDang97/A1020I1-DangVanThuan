DELIMITER $$
	CREATE PROCEDURE `delete_user`(in user_id int)
begin
	delete from users where id = user_id;
end
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `find_all_user`()
begin
	select * from users;
end
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `get_user_by_id`(IN user_id INT)
BEGIN

    SELECT users.`name`, users.email, users.country

    FROM users

    where users.id = user_id;

    END
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `insert_user`(

	IN user_name varchar(50),

	IN user_email varchar(50),

	IN user_country varchar(50)

)
BEGIN

    INSERT INTO users(`name`, email, country) VALUES(user_name, user_email, user_country);

    END
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `update_user`(in user_id int, in user_name varchar(50), in user_email varchar(50), in user_country varchar(50) )
begin
	update users
    set `name` = user_name, email = user_email, country = user_country
    where id = user_id;
end
DELIMITER ;