
explain select * from readers where firstname = 'John';

create index find_user on readers(firstname, lastname);

create index find_book on books(title(3));

explain select * from readers where firstname = 'John';
