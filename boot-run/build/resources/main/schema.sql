drop sequence if exists prices_seq;
drop table if exists prices;

create table prices
(
    price      numeric(38, 2) not null,
    priority   integer        not null,
    end_date   timestamp(6)   not null,
    id         bigint         not null,
    brand_id   bigint         not null,
    price_list bigint         not null,
    product_id bigint         not null,
    start_date timestamp(6)   not null,
    currency   varchar(255)   not null,
    primary key (id)
);

create sequence prices_seq start with 1 increment by 50;