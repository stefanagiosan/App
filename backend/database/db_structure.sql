CREATE DATABASE FirstStepApp;
USE FirstStepApp
GO

BEGIN TRANSACTION
    CREATE TABLE Universities (
        universityId INT PRIMARY KEY IDENTITY,
        name VARCHAR(150) NOT NULL,
        img NVARCHAR(MAX) NOT NULL
    );
COMMIT TRANSACTION

BEGIN TRANSACTION
    CREATE TABLE Faculties (
        facultyId INT PRIMARY KEY IDENTITY,
        name VARCHAR(150) NOT NULL,
        university INT NOT NULL,
        CONSTRAINT FK_faculties_universities FOREIGN KEY(university) REFERENCES Universities(universityId)
           ON UPDATE CASCADE
           ON DELETE CASCADE
    );
COMMIT TRANSACTION

BEGIN TRANSACTION
    CREATE TABLE Announcements (
        announcementId INT PRIMARY KEY IDENTITY,
        title VARCHAR(MAX) NOT NULL,
        text VARCHAR(MAX) NOT NULL,
        university INT,
        faculty INT,
        url NVARCHAR(MAX),
        CONSTRAINT FK_announcements_universities FOREIGN KEY(university) REFERENCES Universities(universityId)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
        CONSTRAINT FK_announcements_faculties FOREIGN KEY(faculty) REFERENCES Faculties(facultyId)
    );
COMMIT TRANSACTION

CREATE OR ALTER TRIGGER DeleteAnnouncementsFromFaculty ON Faculties AFTER DELETE AS
BEGIN
	SET NOCOUNT ON;
    DELETE FROM Announcements WHERE faculty IN (SELECT facultyId FROM deleted);
END

BEGIN TRANSACTION
    CREATE TABLE Locations (
        locationId INT PRIMARY KEY IDENTITY,
        name VARCHAR(200) NOT NULL,
        type VARCHAR(100),
        latitude DECIMAL(8, 6),
        longitude DECIMAL(9, 6),
        img NVARCHAR(MAX),
        site NVARCHAR(MAX),
        description NVARCHAR(MAX)
    );
COMMIT TRANSACTION

BEGIN TRANSACTION
    CREATE TABLE Events (
        eventId INT PRIMARY KEY IDENTITY,
        name VARCHAR(150) NOT NULL,
        description VARCHAR(MAX),
        participants INT DEFAULT 0,
        eventDate DATE NOT NULL,
        location INT NOT NULL,
        CONSTRAINT FK_events_location FOREIGN KEY(location) REFERENCES Locations(locationId)
            ON UPDATE CASCADE
            ON DELETE CASCADE
    );
COMMIT TRANSACTION

BEGIN TRANSACTION
    CREATE TABLE Users (
        userId UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
        name VARCHAR(150) NOT NULL,
        email VARCHAR(100) NOT NULL,
        password VARCHAR(150) NOT NULL,
        university INT NOT NULL,
        faculty INT NOT NULL,
        role VARCHAR(50) NOT NULL
        CONSTRAINT FK_users_universities FOREIGN KEY(university) REFERENCES Universities(universityId)
           ON UPDATE CASCADE
           ON DELETE CASCADE,
        CONSTRAINT FK_users_faculties FOREIGN KEY(faculty) REFERENCES Faculties(facultyId)
    );
COMMIT TRANSACTION

CREATE OR ALTER TRIGGER DeleteUsersFromFaculty ON Faculties AFTER DELETE AS
BEGIN
	SET NOCOUNT ON;
    DELETE FROM Users WHERE faculty IN (SELECT facultyId FROM deleted);
END

BEGIN TRANSACTION
    CREATE TABLE Participants (
        participantId INT PRIMARY KEY IDENTITY,
        userEmail VARCHAR(100) NOT NULL,
        eventId INT NOT NULL
    );
COMMIT TRANSACTION

BEGIN TRANSACTION
    CREATE TABLE Questions (
        questionId INT PRIMARY KEY IDENTITY,
        text NVARCHAR(MAX) NOT NULL,
        questionDate DATE NOT NULL,
        category VARCHAR(150) NOT NULL,
        posterId UNIQUEIDENTIFIER NOT NULL,
        CONSTRAINT FK_questions_users FOREIGN KEY(posterId) REFERENCES Users(userId)
           ON UPDATE CASCADE
           ON DELETE CASCADE
    );
COMMIT TRANSACTION

BEGIN TRANSACTION
    CREATE TABLE Answers (
        answerId INT PRIMARY KEY IDENTITY,
        text NVARCHAR(MAX) NOT NULL,
        answerDate DATE NOT NULL,
        posterId UNIQUEIDENTIFIER NOT NULL,
        question INT NOT NULL,
        CONSTRAINT FK_answers_users FOREIGN KEY(posterId) REFERENCES Users(userId)
         ON UPDATE CASCADE
         ON DELETE CASCADE,
        CONSTRAINT FK_answers_questions FOREIGN KEY(question) REFERENCES Questions(questionId)
    );
COMMIT TRANSACTION

CREATE OR ALTER TRIGGER DeleteAnswersFromQuestion ON Questions AFTER DELETE AS
BEGIN
	SET NOCOUNT ON;
    DELETE FROM Answers WHERE question IN (SELECT questionId FROM deleted);
END