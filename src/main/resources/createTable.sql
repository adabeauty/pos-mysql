use pos;
create table items(
  itemId int auto_increment,
  barcode varchar(14) not null,
  name varchar(20) not null,
  unit varchar(4) not null,
  price double,
  primary key(itemId)
);

create table promotions(
  promotionId int auto_increment,
  description varchar(200) not null,
  type varchar(20) not null,
  primary key(promotionId)
);

create table relationship(
  itemId int references items(itemId),
  promotionId int references promotions(promotionId),
  primary key(itemId, promotionId)
);