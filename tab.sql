-- >>>>>>>>>>创建用户表<<<<<<<<<<<
drop table if exists `user_info`;
create table `user_info`  (
  `user_id` bigint not null comment '用戶id',
  `user_name` varchar(255) comment '用戶姓名',
  `user_sex` varchar(255) comment '用戶性別',
  `user_age` int(8) not null comment '用戶年齡',
  primary key (`user_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

-- >>>>>>>>>>创建商品表1<<<<<<<<<<<
drop table if exists `shoping_00`;
create table `shoping_00`  (
  `shoping_id` bigint not null comment '商品id',
  `shoping_name` varchar(255) comment '商品名称',
  `shoping_price` int(8) not null comment '商品价格',
  primary key (`shoping_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

-- >>>>>>>>>>创建商品表2<<<<<<<<<<<
drop table if exists `shoping_01`;
create table `shoping_01`  (
  `shoping_id` bigint not null comment '商品id',
  `shoping_name` varchar(255) comment '商品名称',
  `shoping_price` int(8) not null comment '商品价格',
  primary key (`shoping_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

-- >>>>>>>>>>创建订单表<<<<<<<<<<<
drop table if exists `order`;
create table `order`  (
  `order_id` bigint not null comment  '订单号',
  `order_price` int(8) not null comment '订单总金额',
  `user_id` bigint not null comment '用戶id',
  primary key (`order_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

-- >>>>>>>>>>创建订单详情表<<<<<<<<<<<
drop table if exists `order_info`;
create table `order_info`  (
  `order_info_id` bigint not null comment  '订单详情号',
  `order_id`  bigint not null comment '订单号',
  `shoping_name` varchar(255)  comment '商品名称',
  `shoping_price` int(8) not null comment '商品价格',
  primary key (`order_info_id`) using btree,
  index `key_order_id`(`order_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;


-- >>>>>>>>>>创建分片容量的范围分片算法demo表<<<<<<<<<<<
drop table if exists `volume_range_0`;
create table `volume_range_0`  (
  `order_id` bigint not null comment  '订单号',
  `order_price` int(8) not null comment '订单总金额',
  `user_id` bigint not null comment '用戶id',
  primary key (`order_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

drop table if exists `volume_range_1`;
create table `volume_range_1`  (
  `order_id` bigint not null comment  '订单号',
  `order_price` int(8) not null comment '订单总金额',
  `user_id` bigint not null comment '用戶id',
  primary key (`order_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

drop table if exists `volume_range_2`;
create table `volume_range_2`  (
  `order_id` bigint not null comment  '订单号',
  `order_price` int(8) not null comment '订单总金额',
  `user_id` bigint not null comment '用戶id',
  primary key (`order_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;