### Assumptions
1. The board cell is at max 100
2. The snake head and ladder bottom can not exists together whereas other combination are possible

### Pros
1. Follows Single responsibility principle as we have separate entity class for Board, Ladder, Player, Snake

### Cons
1. Dont follow open closed principle as we can't change board size for different game
2. Dont follow Liskov substitution principle as we haven't created class for dice and dice max is fixed as 6
3. we dont have game manager to manage n games concurrently