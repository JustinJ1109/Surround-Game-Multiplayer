# CIS457-Project-3

A Client-server implementation of the Surround Game to play online multiplayer 

## Surround Game
The game is simple. Choose a number of players. Each player will take turns to place a single tile at a time on a 10x10 board.  
The game ends when the board is filled up.  
When a player fully surrounds a group of tiles, they take those tiles and are given points for the number of tiles they hold at the end.  
Whichever player has the most points at the end is the winner.  
  
## ClientModel
This class is responsible for the backend logic of the client. Anything that is sent to/from the server travels through here 


## ClientGUI
This is the GUI of that the user interacts with. There is a number of menus that the user can navigate through to communicate with the server:  
- Setting up a game   
- Joining a game  
- Looking for games that the server currently has available  

## GameServer
Main server launcher. Will dispatch serverHandlers as needed as clients request to join
Default port 1370. Set custom port by launching with args ('java GameServer \<port>')
  
## ServerHandler
Helper threads that service each client and respond to requests made.
Validates requests, tracks gamestate, and broadcasts updates to clients
