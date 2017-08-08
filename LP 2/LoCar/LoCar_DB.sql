drop table user;
drop table car;
drop table rental;
drop table rating;
drop table comment;

create table user(
    userId bigint not null primary key generated always as identity(start with 1, increment by 1),
    pwd varchar(16) not null,
    fk_userType tinyint not null,
)

create table userType(
    typeId bigint not null primary key generated always as identity(start with 1, increment by 1),
    type varchar(10),
)
            
create table userInfo(
    userInfoId bigint not null primary key generated always as identity(start with 1, increment by 1),
    name varchar (50) not null,
    gender char not null,
    rg varchar (9) not null, 
    cpf varchar(11),
    cnpj varchar (20),
    passport varchar(20),
    fk_address bigint not null,
    email varchar(25) not null,
    fk_clienInfo bigint,
    fk_employeInfo bigint,
    tel varchar(10) not null,
    cel varchar(10) not null,
    firstAccess timestamp notnull,
    lastAccess timestamp notnull,
) 

create table clientInfo(
    clientInfoId bigint not null primary key generated always as identity(start with 1, increment by 1),
    fk_cnhInfo not null,
    workWhere varchar(20) not null,
    workWith varchar(20) not null,
    fk_addressWork not null,
    referenceName varchar (20) not null,
    referenceTel varchar (10) not null,
)

create table cnhInfo(
    cnhInfoId bigint not null primary key generated always as identity(start with 1, increment by 1),
    
    typeB boolean not null,
    cnhNum varchar(10) not null,
    cnhRegist varchar (15) not null,
    venc timestamp not null,
)

create table employeInfo(
    employeInfoId bigint not null primary key generated always as identity(start with 1, increment by 1),
    funct varchar (20) not null,
    dateAdmission timestamp not null,
    workPass varchar(20) not null,
    workPassSerie varchar(20) not null,
    pisPasesp varchar(20) not null,
    manager bigint,
)

create table address(
    addressId bigint not null primary key generated always as identity(start with 1, increment by 1),
    street varchar(20) not null,
    number varchar(5) not null,
    city varchar (20) not null,
    estate varchar (20) not null,
    zip varchar (10) not null,
)
    
create table car(
    carId bigint not null primary key generated always as identity(start with 1, increment by 1),
    model varchar(15) not null,
    yearModel int not null,
    fk_categoryId tinyint not null,
    color varchar(10) not null,
    isAvailable boolean not null,
    chassi varchar(17) not null,
    brand varchar(20) not null,
    plate varchar(8) not null,
    descritpion varchar(100) not null,
)

create table category(
    categoryId bigint not null primary key generated always as identity(start with 1, increment by 1),
    price int not null,
    basePrice int not null,
    name varchar(20) not null,
    details varchar(100) not null,
)

create table rental(
    rentalId bigint not null primary key generated always as identity (start with 1, increment by 1),
    fk_userId bigint not null,
    fk_carId bigint not null,
    orderDate timestamp not null,
    initDate timestamp not null,
    endDate timestamp not null,
    status varchar(10) not null,
    cost int not null,
    fk_paymentInfo bigint not null, 
)

create table comment(
    commentId bigint not null primary key generated always as identity(start with 1, increment by 1),
    fk_rentalId bigint not null,
    commentTxt varchar(140) not null,
    commentDate timestamp not null,
    rating tinyint not null,
)


alter table user
add foreign key(fk_userType)
references userType(typeId)
on delete cascade;

alter table user
add foreign key(userInfoId)
references userInfo(userInfoId)
on delete cascade;

alter table userInfo
add foreign key(fk_cnhInfo)
references cnhInfo(cnhInfoId)
on delete cascade;

alter table userInfo
add foreign key(fk_employeInfo)
references employInfo(employeInfoId)
on delete cascade;

alter table userInfo
add foreign key(fk_address)
references address(addressId)
on delete cascade;

alter table car
add foreign key(fk_storeId)
references store(storeId)
on delete cascade;

alter table rental
add foreign key(fk_userId)
references usr(userId)
on delete cascade;

alter table rental
add foreign key(fk_carId)
references car(carId)
on delete cascade;

alter table comment
add foreign key(fk_rentalId)
references rental(rentalId)
on delete cascade;
