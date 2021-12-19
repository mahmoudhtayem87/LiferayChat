# Liferay Live Chat

This project has been implemented to demonstrate how we can utilize the web socket technology with liferay dxp, and to respond to our intranet customers who were looking for this functionality.

###### The project has three major modules:
- **Server Module** : which implements the javax websockets, and provides the chat endpoint, there is an http filter that has been implemented in order to secure the handshake request for the chat.
- **Service builder Module**: this is where your chat history is saved, very simple implementation.
- **User Interface Module**: i have used angular to implement the user interface.

###### To Do
- Add the unread messages counter
- Enhance the user interface
- Secure the service builder apis.

> Note:
Users list has been scopped to the group level where you are using the chat widget

###### Demo

![](https://github.com/mahmoudhtayem87/LiferayChat/raw/ee49e319aa4ff7f8d19aefd8dd2742955bb29c25/resources/Screen-Recording-2021-12-19-at-1.gif)
