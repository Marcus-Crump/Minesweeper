# Minesweeper (Java)

## Overview
A small Minesweeper implementation written in Java as an early learning project.
Built by extending and reverse-engineering provided starter code and using Java documentation to implement game logic.

## What’s Implemented
- Core cell/game representation (`Cell`)
- Game controller/runner (`Minesweeper`)
- A preset difficulty configuration (`Easy`)

## Known Limitations / Incomplete Features
- Win condition detection is not implemented (game does not currently recognize a completed board)
- Mine generation logic needs revision and may not guarantee correct placement
- There are known issues when switching between the level selector and the game window, including inconsistent window closing/opening behavior

## How to Run
This repo currently includes source files (`.java`). Compile and run with:

```bash
javac *.java
java Minesweeper
