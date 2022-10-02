--changeset fialka:2
CREATE TYPE gender AS ENUM ('male', 'female');
alter table Person add column gender gender
