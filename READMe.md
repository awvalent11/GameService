Top rated sports books: 

FanDuel, Caesars, Bet365, Fanatics, DraftKings, 
BetRivers, BetMGM, Betway, ClutchBet, Desert Diamond, 

-> Scrap these bad boys for odds 

-> Apache Kafka for scores and resolving bets 




Path 2 Prod 
Run Dockerfile
docker build awvalent7/gameservice:tag .

aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 637423531283.dkr.ecr.us-east-2.amazonaws.com

docker images

docker tag *local container Image ID* 637423531283.dkr.ecr.region.amazonaws.com/my-repository:tag

docker push 637423531283.dkr.ecr.region.amazonaws.com/my-repository:tag