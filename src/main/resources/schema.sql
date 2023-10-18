CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS "decks" CASCADE;
DROP TABLE IF EXISTS "flash_cards" CASCADE;
DROP TABLE IF EXISTS "flash_cards_bag" CASCADE;

CREATE TABLE decks (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    name varchar NOT NULL
);

CREATE TABLE flash_cards (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    word varchar NOT NULL,
    translation varchar NOT NULL,
    deck_id uuid NOT NULL,

    CONSTRAINT fk_deckId FOREIGN KEY(deck_id) REFERENCES decks(id)
);

CREATE TABLE flash_cards_bag (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    word varchar NOT NULL,
    translation varchar NOT NULL
);
