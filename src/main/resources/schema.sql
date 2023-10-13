CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS "flash_cards";
DROP TABLE IF EXISTS "flash_cards_bag";

CREATE TABLE flash_cards (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    word varchar NOT NULL,
    translation varchar NOT NULL
);

CREATE TABLE flash_cards_bag (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    word varchar NOT NULL,
    translation varchar NOT NULL
);
