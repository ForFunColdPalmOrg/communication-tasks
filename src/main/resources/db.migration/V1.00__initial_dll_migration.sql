create table if not exists team (
    id smallint generated always as identity not null primary key,
    name varchar(20) not null,
    parent smallint
);

create table if not exists position (
    id smallint generated always as identity not null primary key,
    name varchar(20) not null
);

create table if not exists employee (
    id integer generated always as identity not null primary key,
    user_name varchar(8) not null,
    team smallint not null constraint employee_team_fkey references team,
    position smallint not null constraint employee_position_fkey references position
);

create table if not exists task (
    id bigint generated always as identity not null primary key,
    deadline timestamp,
    created_by integer not null constraint task_employee_created_fkey references employee,
    assigned_to integer constraint task_employee_assigned_fkey references employee,
    state smallint not null,
    created_at timestamp not null,
    team_id smallint not null constraint task_team_fkey references team,
    description varchar(250),
    tax_code varchar(10),
    last_name varchar(50),
    name varchar(50),
    middle_name varchar(50),
    phone varchar(10),
    email varchar(100),
    offer_id integer
);