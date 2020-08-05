
INSERT INTO ROLES (id, label) values(1, 'USER');
INSERT INTO ROLES (id, label) values(2, 'ADMIN');



INSERT INTO tbl_utilisateurs (username, firstname, gender, lastname,password, profile, telephone)
values('hilmi.reda@gmail.com', 'reda', 'Male', 'Hilmi','root', 'Trainer', '0619416454');

INSERT INTO tbl_users_roles (user_username, authority)
values ('hilmi.reda@gmail.com', 'USER');



     INSERT INTO tbl_utilisateurs (username, firstname, gender, lastname,
    							  password, profile, telephone)


    	values('hilmi.reda@officiel.com', 'reda', 'Male', 'Hilmi',
    							  'root', 'Other', '0619416454');


     INSERT INTO tbl_users_roles (user_username, authority)
                                values ('hilmi.reda@officiel.com', 'ADMIN');