# Tennis Scoring Simulator
A simple java application to simulate Tennis scoring for a match

## Prerequisites
- Java 8
- Gradle 6.x (eg. 6.7.1)
- SonarQube for static code analysis (optional)
- Junit for unit testing

## Description:
- The application is a simulation of Tennis match between two players. 
- A match has one set and a set has many games
- A game is won by the first player to have won at least 4 points in total and at least 2 points more than the opponent.
- If at least 3 points have been scored by each player, and the scores are equal, the score is "deuce".
- If at least 3 points have been scored by each side and a player has one more point than his opponent, the score of the game is "advantage" for the player in the lead.
- A player wins a set by winning at least 6 games and at least 2 games more than the opponent.
- If one player has won six games and the opponent five, an additional game is played. If the leading player wins that game, the player wins the set 7–5. If the trailing player wins the game, a tie-break is played.
- A tie-break, played under a separate set of rules, allows one player to win one more game and thus the set, to give a final set score of 7–6. A tie-break is scored one point at a time. The tie-break game continues until one player wins seven points by a margin of two or more points. Instead of being scored from 0, 15, 30, 40 like regular games, the score for a tie breaker goes up incrementally from 0 by 1. i.e a player's score will go from 0 to 1 to 2 to 3 …etc.

More Details - https://github.com/DiUS/coding-tests/blob/master/dius_tennis.md

**Constraints:**
- Only one match set and multiple games

## Concept:
![TennsiBoard](https://i2.wp.com/sportoutloud.com/wp-content/uploads/2020/05/tennis-score.jpg "Simulator Concept")

Rules - https://en.wikipedia.org/wiki/Tennis_scoring_system

## Solution:
- **Add Points** As a standard tennis tournament, point added to the player for every win. 
- The current point will be maintained at the players profile level to check the result for every game.
- Based on the tennis rules, the points difference will be calculated to find the winner of each game and add game point to the players profile. 
- Finally, the player who got 2 or more game difference win the match if no tie break. 
- If the match is a tie breaker, then the additional points will be calculated and difference more than 2 will be announced as a winner. 

## Compile, Run and Test:
- Gradle clean - **./gradlew clean**
- Gradle run - **./gradlew run**
- Grale run without additional logging  - **./gradlew run --console plain**
- SonarQube code analysis - **./gradlew -Dsonar.host.url=http://localhost:9000 sonarqube**
- Execute the jar directly(without Gradle) - **java -jar tennis-simulator.jar**

## Example: 
**Case 1**
```
*** Welcome to Tennis Match ***
Please enter the Player 1 name:
Novak
Please enter the Player 2 name:
Roger
Thanks for the player details
Please enter a valid command as below
'TYPE 1 or 2 to add points for Players accordingly. Options :- ', 1, 2, SCORE, QUIT
1
0-0, 15-0
1
0-0, 30-0
2
0-0, 30-15
2
0-0, 30-30
2
0-0, 30-40
2
0-1
Score
0-1, 0-0
QUIT
Current Match Status: 0-1, 0-0
Thanks for playing. Happy New Year 2021!!
```

**Case 2**
```
*** Welcome to Tennis Match ***
Please enter the Player 1 name:
Roger
Please enter the Player 2 name:
Novak
Thanks for the player details
Please enter a valid command as below
'TYPE 1 or 2 to add points for Players accordingly. Options :- ', 1, 2, SCORE, QUIT
1
....
...
...
1
5-0, 30-0
1
5-0, 40-0
1
6-0, Roger wins the match
Congrats!!. Thanks for playing the game.
```
**Case 3**

```
*** Welcome to Tennis Match ***
Please enter the Player 1 name:
A
Please enter the Player 2 name:
B
Thanks for the player details
Please enter a valid command as below
'TYPE 1 or 2 to add points for Players accordingly. Options :- ', 1, 2, SCORE, QUIT
1
0-0, 15-0
.....
...
2
1-0, 30-30
1
1-0, 40-30
2
1-0, Deuce
1
1-0, Advantage A
1
2-0

```

## Junit Test Results: 
```
./gradlew test

BUILD SUCCESSFUL in 0s
3 actionable tasks: 3 up-to-date

```
