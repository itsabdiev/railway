CREATE TABLE IF NOT EXISTS Actions (
    id INTEGER AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR (255),
    primary key (id)
);

INSERT INTO Actions (title,description,status,content_type,date_created)
SELECT 'Do upper-body training','Sport','IN_PROGRESS','SPORT',CURRENT_TIMESTAMP,
       WHERE NOT EXISTS (SELECT * FROM Actions);
