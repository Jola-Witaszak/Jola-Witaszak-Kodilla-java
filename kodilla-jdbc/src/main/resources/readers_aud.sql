create table readers_aud
(
    event_id      int auto_increment
        primary key,
    event_date    datetime     not null,
    event_type    varchar(10)  null,
    reader_id     int          not null,
    old_firstname varchar(255) null,
    new_firstname varchar(255) null,
    old_lastname  varchar(255) null,
    new_lastname  varchar(255) null,
    old_peselid   varchar(11)  null,
    new_peselid   varchar(11)  null,
    old_vip_level varchar(20)  null,
    new_vip_level varchar(20)  null
);

INSERT INTO kodilla_course.readers_aud (event_id, event_date, event_type, reader_id, old_firstname, new_firstname, old_lastname, new_lastname, old_peselid, new_peselid, old_vip_level, new_vip_level) VALUES (1, '2021-04-29 17:10:10', 'insert', 11, null, 'James', null, 'Gosling', null, '83061509442', null, null);
INSERT INTO kodilla_course.readers_aud (event_id, event_date, event_type, reader_id, old_firstname, new_firstname, old_lastname, new_lastname, old_peselid, new_peselid, old_vip_level, new_vip_level) VALUES (2, '2021-04-29 17:12:15', 'insert', 12, null, 'James', null, 'Gosling', null, '83061509442', null, 'Not set');
INSERT INTO kodilla_course.readers_aud (event_id, event_date, event_type, reader_id, old_firstname, new_firstname, old_lastname, new_lastname, old_peselid, new_peselid, old_vip_level, new_vip_level) VALUES (3, '2021-04-29 17:12:51', 'delete', 11, null, null, null, null, null, null, null, null);
INSERT INTO kodilla_course.readers_aud (event_id, event_date, event_type, reader_id, old_firstname, new_firstname, old_lastname, new_lastname, old_peselid, new_peselid, old_vip_level, new_vip_level) VALUES (4, '2021-04-29 17:50:58', 'update', 12, 'James', 'James', 'Gosling', 'Gosling', '83061509442', '83061509442', 'Bronze customer', 'Silver customer');