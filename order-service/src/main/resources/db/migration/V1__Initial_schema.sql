CREATE TABLE orders (
      id                        BIGSERIAL PRIMARY KEY NOT NULL,
      product_code              varchar(255) NOT NULL,
      product_name              varchar(255),
      product_size              varchar(255),
      product_quantity          int NOT NULL,
      product_price             numeric(20, 2),
      product_description       varchar(255),
      product_color             varchar(255),
      status                    varchar(255) NOT NULL,
      created_date              timestamp NOT NULL,
      last_modified_date        timestamp NOT NULL,
      version                   integer NOT NULL
);