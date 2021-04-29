create trigger readers_delete
	after delete
	on readers
	for each row
	begin
        insert into readers_aud(event_date, event_type, reader_id)
        values(curtime(), 'delete', old.reader_id);
    end;

