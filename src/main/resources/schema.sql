CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS "flash_cards";

CREATE TABLE flash_cards (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    word varchar NOT NULL,
    translation varchar NOT NULL
);