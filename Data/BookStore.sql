CREATE DATABASE BookStore;


CREATE TABLE Users
(
  userID VARCHAR(20) NOT NULL,
  pass VARCHAR(20) NOT NULL,
  roleUser VARCHAR(20) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  PRIMARY KEY (userID)
);

CREATE TABLE Books
(
  bookID VARCHAR(30) NOT NULL,
  titleBook NVARCHAR(30) NOT NULL,
  author NVARCHAR(30) NOT NULL,
  descriptionBook NVARCHAR(50) NOT NULL,
  imagerName VARCHAR(30) NULL,
  price VARCHAR(30) NOT NULL,
  quantityBook INT NOT NULL,
  category VARCHAR(30) NOT NULL,
  statusBook VARCHAR(10) NOT NULL,
  dateCreate VARCHAR(30) NOT NULL,
  PRIMARY KEY (bookID)
);

CREATE TABLE Builds
(
  buildID VARCHAR(30) NOT NULL,
  dateBuild VARCHAR(50) NOT NULL,
  titleBook NVARCHAR(50) NOT NULL,
  quantityBuild INT NOT NULL,
  totalBuild VARCHAR(30) NOT NULL,
  payment VARCHAR(20) NOT NULL,
  statusBuild VARCHAR(20) NOT NULL,
  descriptionBuild VARCHAR(50) NULL,
  userID VARCHAR(20) NOT NULL,
  PRIMARY KEY (buildID),
  FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE Discount
(
  discountID VARCHAR(20) NOT NULL,
  descriptionDiscount NVARCHAR(50) NOT NULL,
  statusDiscount VARCHAR(100) NOT NULL,
  codeDiscount VARCHAR(20) NOT NULL,
  PRIMARY KEY (discountID)
);

CREATE TABLE BookinBuild
(
  bookID VARCHAR(30) NOT NULL,
  buildID VARCHAR(30) NOT NULL,
  PRIMARY KEY (bookID, buildID),
  FOREIGN KEY (bookID) REFERENCES Books(bookID),
  FOREIGN KEY (buildID) REFERENCES Builds(buildID)
);

CREATE TABLE UserHaveDiscount
(
  discountID VARCHAR(20) NOT NULL,
  userID VARCHAR(20) NOT NULL,
  PRIMARY KEY (discountID, userID),
  FOREIGN KEY (discountID) REFERENCES Discount(discountID),
  FOREIGN KEY (userID) REFERENCES Users(userID)
);


SELECT bookID,titleBook,imagerName,descriptionBook,price,author FROM dbo.Books WHERE quantityBook > 0 AND statusBook = 'ready'
SELECT roleUser FROM dbo.Users WHERE userID = 'linhnd' AND pass = '123456'N
SELECT bookID,titleBook,imagerName,descriptionBook,price,author,category FROM dbo.Books WHERE quantityBook > 0 AND statusBook = 'ready' AND (titleBook LIKE N'%%' OR category LIKE N'%%')

SELECT titleBook,author,descriptionBook,price,imagerName FROM dbo.Books WHERE bookID = ?;
SELECT quantityBook,titleBook FROM dbo.Books WHERE bookID = ? AND quantityBook < ?;
INSERT dbo.Builds
        ( buildID ,
          dateBuild ,
          totalBuild ,
          payment ,
          statusBuild ,
          descriptionBuild ,
          userID
        )
VALUES  ( '' , -- buildID - varchar(30)
          '' , -- dateBuild - varchar(50)
          '' , -- totalBuild - varchar(30)
          '' , -- payment - varchar(20)
          '' , -- statusBuild - varchar(20)
          '' , -- descriptionBuild - varchar(50)
          ''  -- userID - varchar(20)
        );
INSERT dbo.BookinBuild
        ( bookID, buildID, quantity )
VALUES  ( '', -- bookID - varchar(30)
          '', -- buildID - varchar(30)
          0  -- quantity - int
          );

UPDATE dbo.Books SET quantityBook = ? WHERE bookID = ?;
SELECT quantityBook FROM dbo.Books WHERE bookID = ?;
DELETE dbo.UserHaveDiscount WHERE userID = ? AND discountID = ?;
SELECT titleBook,dateBuild FROM dbo.Builds,dbo.BookinBuild,dbo.Books WHERE dbo.Builds.buildID = dbo.BookinBuild.buildID AND dbo.BookinBuild.bookID = dbo.Books.bookID AND userID = ? AND titleBook LIKE ;


SELECT dbo.Builds.buildID FROM dbo.Builds WHERE dateBuild BETWEEN '2020-02-21' AND '2020-02-24';
SELECT bookID,titleBook,imagerName,descriptionBook,price,author,category,quantityBook FROM dbo.Books WHERE statusBook = 'ready'