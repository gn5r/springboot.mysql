# Spring Boot + MySQL + JDBCサンプル

## データベース
    create database sample
  
## テーブルとその中身
    create table sample(
    id int not null primary key auto_increment,
    name varchar(255) not null,
    email varchar(255) not null,
    created datetime not null default current_timestamp,
    modified datetime not null default current_timestamp on update current_timestamp
    );
    
## テーブルにデータを追加
    insert into sample.sample(name,email)values(
    "gn5r",
    "gn5r@exsample.com"),
    ("Gin.Ray",
    "Gin.Ray@exsample.com")
    );
    
## テーブルデータの更新
    update sample.sample set カラム名=値
