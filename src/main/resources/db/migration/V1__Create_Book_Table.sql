CREATE TABLE IF NOT EXISTS public.book (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  author VARCHAR(128) NOT NULL,
  isbn VARCHAR(16) NOT NULL,
  title VARCHAR(128),
  price NUMERIC(6,2),
  CONSTRAINT books_pkey PRIMARY KEY(id)
);

