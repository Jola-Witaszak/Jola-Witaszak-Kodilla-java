create table stats(
    stat_id int(11) auto_increment primary key,
    stat_date datetime not null,
    stat varchar(20) not null,
    value int(11) not null
);


create view bestsellers_count as
    select count(*) as bestsellers_number
from books
where bestseller > 0;


select * from bestsellers_count;


use kodilla_course;

delimiter $$
create event number_of_bestsellers
on schedule every 1 minute
do
    begin
        declare bestsellers_number int;

        call UpdateBestsellers();

        select * from bestsellers_count
            into bestsellers_number;

        insert into stats(stat_date, stat, value)
        values (curtime(), 'bestsellers', bestsellers_number);
    end$$

delimiter ;
