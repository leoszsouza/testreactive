CREATE TABLE IF NOT EXISTS person (
  id         UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  name TEXT
);