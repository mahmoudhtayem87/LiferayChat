create table CHAT_ChatUser (
	userId LONG not null primary key,
	fullName VARCHAR(75) null,
	avatar VARCHAR(75) null
);

create table CHAT_Message (
	messageId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	toUserId LONG,
	fromUserId LONG,
	messageType VARCHAR(75) null,
	messageText VARCHAR(200) null
);