select * from books;

select id, name, author from books
where name = 'Clean Code' and author='Robert C.Martin'
order by id desc;

select id, name, author from books
where name = 'Head First Java' and author = 'Kathy Sierra'
order by id desc;

select id, name, author from books
where name = 'The Scrum Field Guide' and author = 'Mitch Lacey'
order by id desc;

select id, name, author from books
where name = 'Code Master Luis' and author = 'Louie Vee I'
order by id desc;

select id, name, author from books
where name = 'Java is love. Java is life.' and author = 'Me'
order by id desc;