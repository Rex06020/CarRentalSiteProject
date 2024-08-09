CREATE TABLE `Car` (
    `CarID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CarType` CHAR(50),
    `Price` INT,
    `Date` DATE,
    `PeopleNub` INT,
    `Car_Status` ENUM('use', 'unuse'),
    `C_Location` CHAR(50)
);
CREATE TABLE `Order`(
    `OrderID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `MemberID` INT ,
    `Detail_ID` INT ,
    `Od_Status` ENUM('("completed"', '"renting")') 
);
CREATE TABLE `Order_Detail` (
    `Detail_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CarType` CHAR(50),
    `Price` INT,
    `Date` DATE,
    `MemberID` INT,
    `Days` INT,
    `Location` CHAR(50)
);
CREATE TABLE `Member`(
    `MemberID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Age` INT,
    `Gender` ENUM(
        '"male"',
        '"female"',
        '"othersexual"'
    ) ,
    `Name` CHAR(50) ,
    `Email` CHAR(50) ,
    `LicenseNub` CHAR(50) ,
    `Address` CHAR(50) ,
    `Phone` CHAR(50) ,
    `login`BOOLEAN
);