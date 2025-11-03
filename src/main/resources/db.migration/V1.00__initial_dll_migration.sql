create table if not exists customer (
    id integer generated always as identity not null primary key,
    tax_code varchar(10),
    last_name varchar(250) not null,
    name varchar(250),
    middle_name varchar(250),
    phone varchar(10),
    email varchar(250)
);

create table if not exists employee (
    id integer generated always as identity not null primary key,
    user_name varchar(8) not null,
    team smallint not null,
    position smallint not null
);

create table if not exists task (
    id bigint generated always as identity not null primary key,
    customer_id integer not null constraint task_customer_fkey references customer,
    deadline timestamp,
    created_by integer not null constraint task_employee_created_fkey references employee,
    assigned_to integer constraint task_employee_assigned_fkey references employee,
    state smallint not null,
    created_at timestamp not null,
    description varchar(250)
);