 -- drop table categoria;
-- drop sequence categoria_id_seq;
 create sequence categoria_id_seq
 increment 1
 minvalue 1
 maxvalue 9223372036854775807
 start 1
 cache 1;


create table categoria (
  codigo BIGINT default nextval('categoria_id_seq'::regclass),
  nome VARCHAR(50) not null
  ) ;

 alter table categoria add constraint categoria_pk primary key (codigo);
 create index categoria_index01 on categoria using btree (codigo);


insert into categoria (nome) values ('Lazer');
insert into categoria (nome) values ('Alimentação');
insert into categoria (nome) values ('Supermercado');
insert into categoria (nome) values ('Farmácia');
insert into categoria (nome) values ('Outros');