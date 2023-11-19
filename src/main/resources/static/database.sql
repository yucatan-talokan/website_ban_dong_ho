use websitebandongho;

CREATE TABLE BRANDS
(
    id   integer AUTO_INCREMENT primary key ,
    name NVARCHAR(255)
)engine =InnoDB;
CREATE TABLE CATEGORIES
(
    id   integer AUTO_INCREMENT primary key,
    name NVARCHAR(255)
)engine =InnoDB;
CREATE TABLE MOVEMENTS
(
    id   integer AUTO_INCREMENT primary key,
    name NVARCHAR(255) 
 
)engine =InnoDB;
CREATE TABLE STRAPS
(
    Id   integer AUTO_INCREMENT primary key,
    Name NVARCHAR(255)
)engine =InnoDB;
CREATE TABLE PRODUCTS
(
    Id         integer AUTO_INCREMENT primary key,
    ShortName nvarchar(255),
    Name       NVARCHAR(255),
    Image      VARCHAR(255),
    Price      DECIMAL,
    QuantityLeft integer,
    Brandid    integer,
    Categoryid integer,
    Strapid    integer,
    Movementid integer,
    foreign key(brandid) references Brands(id),
    foreign key(categoryid) references Categories(id),
    foreign key(strapid) references Straps(id),
    foreign key(movementid) references Movements(id)
)engine =InnoDB;

update products set shortname='Đồng hồ nam Seiko 5 Quân Đội SNK805K2S' where id=1;
select*from products;
create table PROMOTIONS
(
	Id integer auto_increment primary key,
    Name nvarchar(255),
    Percent integer,
    StartDate date,
    EndDate date
)engine=InnoDB;

create table ORDERS(
	Id integer auto_increment primary key,
    CreateDate date,
    PromotionId integer,
    UserEmail nvarchar(255),
    PaymentMethod nvarchar(255),
    DeliveryAddress nvarchar(255),
    foreign key(promotionid) references Promotions(id),
    foreign key(useremail) references Users(email)
)engine=InnoDB;
select*from Orders;
create table ORDERDETAILS(
	Id integer auto_increment primary key,
    ProductId integer,
    OrderId integer,
    Quantity integer,
    TotalPrice decimal,
    foreign key(ProductId) references Products(Id),
    foreign key(OrderId) references Orders(Id)
)engine=InnoDB;
select*from Orderdetails;

create table USERS(
    Email nvarchar(255) primary key,
    Password char(68),
    FullName nvarchar(255),
    PhoneNumber nvarchar(10),
    Sex bit
)engine=InnoDB;

create table ROLES(
    Email nvarchar(255),
    Role nvarchar(255),
    unique key(email,role),
    foreign key(Email) references USERS(Email)
)engine=InnoDB;	

    
    select * from brands;
    select * from movements;
    select * from categories;
    select * from straps;
    select * from products;
    
    update products set image ='https://donghoduyanh.com/images/products/2020/03/17/large/dong_ho_orient_ra-ak0305s10b.jpg.webp' where id=5;
    
    insert into Users (email,password) values
    ('cuong@gmail.com','{bcrypt}$2a$10$dy3JFkM1jYYkELLNoRIJh./QaTciwRqQEos12m72RxA3IrsNTNGqK'),
    ('do@gmail.com','{bcrypt}$2a$10$ImX1FYAqSyMOemxifjfIO.nX.t08.JTxFLJ7Oy2tv/7K3zvg5Av.O'),
    ('manh@gmail.com','{bcrypt}$2a$10$rryPC4IJVwshAbGNVUgkI.pQYWfv6eDbL5C4j6tPuMxlG8WdrLKgy');
    
    insert into ROLES values
    ('cuong@gmail.com','GUEST'),
    ('cuong@gmail.com','EMPLOYEE'),
    ('cuong@gmail.com','ADMIN'),
    ('do@gmail.com','EMPLOYEE'),
    ('do@gmail.com','GUEST'),
    ('manh@gmail.com','GUEST');
    
    
    select * from users;
    select * from roles;


    
    
    