create definer = root@localhost procedure UpdateBestsellers()
begin
    declare getBookId, booksRented int;
    declare finished int default 0;

    declare bookCursor cursor for select book_id from books;
    declare continue handler for not found set finished = 1;

    open bookCursor;
    while (finished = 0) do
            fetch bookCursor into getBookId;
            if (finished = 0) then

                select count(*) from rents
                where book_id = getBookId and month(now()) = month(rent_date)
                into booksRented;

                update books set bestseller = 1
                where book_id = getBookId and booksRented > 2;

                commit;

            end if ;
        end while ;
    close bookCursor;
end;

