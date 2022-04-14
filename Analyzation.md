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

1. user id(primary key)(auto increase)
2. email address(unique)
3. password
4. banned(date)
5. verification code

### table posts

1. title
2. body
3. belongs to(ref: user id)

