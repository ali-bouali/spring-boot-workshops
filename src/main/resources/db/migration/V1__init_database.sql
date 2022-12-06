create table if not exists address
(
    id           integer not null
    primary key,
    house_number varchar(255),
    street_name  varchar(255),
    zip_code     varchar(255)
    );

create table if not exists department
(
    id   integer not null
    primary key,
    name varchar(255)
    );

create table if not exists employee
(
    id            integer      not null
    primary key,
    birthdate     date         not null,
    email         varchar(255) not null
    constraint uk_fopic1oh5oln2khj8eat6ino0
    unique,
    firstname     varchar(255) not null,
    identifier    varchar(255) not null
    constraint uk_5rh0wqupnwpehb050wgokpc4n
    unique,
    lastname      varchar(255) not null,
    role          varchar(255) not null,
    address_id    integer
    constraint fkga73hdtpb67twlr9c1i337tyt
    references address,
    department_id integer
    constraint fkbejtwvg9bxus2mffsm3swj3u9
    references department
    );

create table if not exists mission
(
    id       integer not null
    primary key,
    duration integer not null,
    name     varchar(255)
    );

create table if not exists employee_mission
(
    employee_id integer not null
    constraint fkn6kayjl3tuml7x7x79tgd5uiq
    references employee,
    mission_id  integer not null
    constraint fkfgq6xw9slvmn8axdlck1asln7
    references mission
);
