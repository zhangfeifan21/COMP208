## module analyzation

### user module

1. register(verification code)
2. login(if not banned)
3. change password(after login)
4. view posts(after login)(mine and all)(delete mine)
5. forget login(verification code)
6. post(after login)

### admin module

1. login(admin password)
2. view posts(delete)
3. view users(ban)

## table analyzation

### table users

1. user_id(primary key)(auto increase)
2. email_address(unique)
3. password
4. banned_until(date)
5. verification_code

### table posts

1. title
2. body
3. belongs to(ref: user id)

### SQL queries
create table users
(
user_id           int auto_increment
primary key,
email_address     varchar(50) not null,
password          varchar(20) not null,
verification_code int         null,
banned_until      datetime    null,
constraint users_email_address_uindex
unique (email_address)
);

create table parties
(
belongs_to     int           not null,
title          varchar(50)   not null,
description    varchar(2000) null,
max_member     int           null,
current_member int           null,
place          varchar(100)  null,
start_time     datetime      null,
party_id       int auto_increment
primary key,
constraint posts_users_user_id_fk
foreign key (belongs_to) references users (user_id)
on update cascade on delete cascade
);

create table users_parties
(
user_id  int null,
party_id int null,
constraint users_parties_parties_party_id_fk
foreign key (party_id) references parties (party_id)
on update cascade on delete cascade,
constraint users_parties_users_user_id_fk
foreign key (user_id) references users (user_id)
on update cascade on delete cascade
);

