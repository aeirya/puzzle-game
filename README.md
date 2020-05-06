Another puzzle game
---
there's a config file @ src/resources/config
0 stands for the non-digit tile.

this project uses factory and singleton design pattern.
and a couple of dependency injections here and there.
and there are places dependency inversions happen (some of them thanks to dependency injections).

control isn't cenetralized by a public static singleton object but by the game controller (and thanks to dependency inversions).

and i guess i used my interpretion of MVC pattern for designing board and puzzle piece.