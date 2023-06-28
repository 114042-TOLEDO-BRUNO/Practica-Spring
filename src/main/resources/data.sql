insert into players (id,user_name,password,email,avatar,last_login,created_at,updated_at)
values(1000000,'APP',null,null,null,current_timestamp,current_timestamp,current_timestamp);
insert into players (id,user_name,password,email,avatar,last_login,created_at,updated_at)
values(100,'bruno','Password3#','bruno@bruno.com',null,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

insert into games(id,code,name,description,rules)
values(1000000,'RPS','ROCK,PAPER SCISSORS','rock,paper scissors is a a simple hand game typically played between two individuals, '||
'the game involves each player simultaneosly forming one of three shapes with their hand: '||
'a closed first representing a rock, an open hand with the palm facing downward representing '||
'a sheet of paper, or an extended index and middle finger forming '||
'a V shape to represent scissors. '||
'To play this game we will replace the shapes of the hands with letters, '||
'R for rock, P for paper and S for sccisors','the objetive of the game is to defeat the opponent by selecting a hand '||
'shape that defeats their choice according to a set of predetermined rules: '||
'rock crushes scissors, scissors cuts a paper, and paper cover rock.'||
'The outcome of each round is determined by comparing the hand shapes. '||
'and the player with the winning shape scores a point');
insert into matches(id,game_id,player_id,created_at,updated_at,status)
values(1000000,1000000,100,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'STARTED');
insert into matches(id,game_id,player_id,created_at,updated_at,status)
values(1000001,1000000,100,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'FINISHED');
insert into matches(id,game_id,player_id,created_at,updated_at,status)
values(1000002,1000000,100,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'CANCELED');
