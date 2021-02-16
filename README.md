# learning
Computer Engineering fundamentals, Learning repo

**Kubernetes Example**


service1 : runs on 8080

service2 : runs on 8081


service2 -> calling -> service1 


Service2 refering service1 in yaml as 

service1:
  host: jsun    # this will be name of kubernetes service that is expose for pod service1
  port: 8080
  
`docker build -t service2 .`

`docker run -it -p8081:8081 service2:latest
`


Create Deployment

`kubectl create secret docker-registry jsec --docker-server=https://hub.docker.com/ --docker-username=iamjc321 --docker-password=<password> --docker-email=<email>
`

`k create deployment jsun --image=iamjc/service1`

`k create deployment jsun2 --image=iamjc/service2
`

Debugging

`k describe deployments.apps jsun
k logs jsun-64fdb8677f-c26tg --v=3 -f
k rollout restart deployment jsun2

k expose deployment jsun --type=NodePort --port=8080

k expose deployment jsun2 --type=NodePort --port=8081

minikube service --url jsun


consumer  
 gradle jib --image=iamjc321/consumer
  
`
