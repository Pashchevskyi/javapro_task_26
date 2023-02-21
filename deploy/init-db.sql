DROP DATABASE IF EXISTS simple_store;

CREATE DATABASE simple_store;

CREATE TABLE IF NOT EXISTS public.orders
(
    id bigint NOT NULL,
    cost double precision NOT NULL,
    date timestamp(6) without time zone,
    CONSTRAINT orders_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.orders
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.products
(
    id bigint NOT NULL DEFAULT 'nextval('products_id_seq'::regclass)',
    cost double precision NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT products_pkey PRIMARY KEY (id),
    CONSTRAINT orders_foreign_key FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.products
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.orders_products
(
    order_id bigint NOT NULL,
    product_id bigint NOT NULL,
    CONSTRAINT uk_qmviv5y7625wak8tjq4nirybh UNIQUE (product_id),
    CONSTRAINT fke4y1sseio787e4o5hrml7omt5 FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT fkqgxvu9mvqx0bv2ew776laoqvv FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT oppk PRIMARY KEY(order_id, product_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.orders_products
    OWNER to postgres;