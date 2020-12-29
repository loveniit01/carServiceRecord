from destination folder where your java maven project store 
1--> build image 
docker image build -t my-java-docker .
2--> to check build image
docker image ls

3--> docker image Run
docker run -itd my-java-docker

4--> to enter in bash 
docker exec -it d3 /bin/bash // d3 is docker image 

5--> check logs 
docker logs -tf d3 // d3 is docker image of java application , -tf stand for tail 