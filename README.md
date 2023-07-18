# currency-exchange-service-v2
* Add VM Argument, if we want to change what port we are starting up on: `-Dserver.port=8001`
V1.0:
* Needs Zipkin running locally, if we want to capitalize on the distributed tracing.

### Build docker image by hand:
`docker build . -t daedalus1215/currency-exchange-service:latest`
`docker run -p 8000:8000 daedalus1215/currency-exchange-service:latest`
`docker push daedalus1215/currency-exchange-service:latest`