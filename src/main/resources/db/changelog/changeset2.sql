--changeset fialka:2
-- CREATE TYPE gender AS ENUM ('Male', 'Female');
alter table Person add column gender varchar;
