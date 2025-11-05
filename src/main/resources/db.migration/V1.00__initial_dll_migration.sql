create table if not exists employee (
    id integer generated always as identity not null primary key,
    user_name varchar(8) not null,
    team smallint not null,
    position smallint not null
);

create table if not exists task (
    id bigint generated always as identity not null primary key,
    deadline timestamp,
    created_by integer not null constraint task_employee_created_fkey references employee,
    assigned_to integer constraint task_employee_assigned_fkey references employee,
    state smallint not null,
    created_at timestamp not null,
    description varchar(250),
    tax_code varchar(10),
    last_name varchar(50),
    name varchar(50),
    middle_name varchar(50),
    phone varchar(10),
    email varchar(100),
    offer_id integer
);