# Pong

A two-player Pong game built in Java on an instructor-provided game engine, featuring real-time collision detection, dual control schemes, and a bonus "smashball" mode.

## Features

- **Two-player gameplay** — one player uses WASD, the other uses arrow keys
- **Real-time collision detection** — paddle and wall collision handling, plus miss/scoring detection
- **Score tracking** — live scoreboard tracking points for both players
- **Smashball mode** — a bonus mode with dynamic speed-up mechanics
- **Game engine** — built on `GDV5`, an instructor-provided game engine base that handles the game loop, rendering, and input

## Tech Stack

- **Language:** Java
- **Libraries:** Java AWT/Swing (rendering, input handling)

## How to Run

1. Clone the repo
2. Compile the `.java` files
3. Run `PongRunner`

Player 1 controls: `WASD`
Player 2 controls: `Arrow keys`

## Project Structure

- `PongRunner` — main game loop and mode/state management
- `Ball` — ball movement, collision, and scoring logic
- `Paddle` — paddle movement and control handling
- `Scoreboard` — score tracking and game-over logic
- `GDV5` — custom game engine base (rendering, input, game loop)
