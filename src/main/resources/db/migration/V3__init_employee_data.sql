insert into employee (id, birthdate, email, firstname, identifier, lastname, role)
values (
        nextVal('hibernate_sequence'),
        current_date,
        'bouali.social@gmail.com',
        'ali',
        '12134',
        'bouali',
        'ROLE_ADMIN'
        );
