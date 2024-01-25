# ChatColor System

Disclaimer: This was made for students/beginner/medior Spigot Java Developers on the Plugin Dev Community: https://discord.gg/learnspigot . 
Mostly basic Java/Spigot methods are being used.

ChatColor System is a medium/hard project, you see these type of plugins mostly in lobbies or minigames.

How it works:
* Player runs a command that will open a GUI with selectable colors. Here players can choose one of the colors.
* After the player selects the color, the GUI will close and whenever the player chats the message will be in that color.

Required Features:
* Flexibility with selecting chatcolors
* Easy to add new existing chatcolors or hex colors.

Udemy: https://www.udemy.com/course/develop-minecraft-plugins-java-programming/

Suggested Lectures:
* Lecture 10-14: Java Basics
* Lecture 16: Events
* Lecture 17: Commands
* Lecture 36: Toggling
* Lecture 48: GUI Creation
* Lecture 49: GUI Interaction

Hints:
|| Create a Player Manager class to keep record of the players/implement methods that will update colors.
* Make use of the Join/Quit events to save a custom player object so that you can save the color.
* Make use of an Enum to store the colors.||

Source-Code: https://github.com/Tqqn/ChatColors

Note: This plugin has been build on 1.20.4. If you use lower versions, maybe some methods will not work/or need changes.
I am using the kyori.adventure API for the chat colors. You can use other API's or the deprecated spigot methods (not recommended).
