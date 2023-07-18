# currency-exchange-service-v2
* Add VM Argument, if we want to change what port we are starting up on: `-Dserver.port=8001`
V1.0:
* Needs Zipkin running locally, if we want to capitalize on the distributed tracing.

### Build docker image by hand:
1. Build app
2. Move currency-exchange-service...jar file out of `target`
3. `docker build . -t daedalus1215/currency-exchange-service:latest`
4. `docker run -p 8000:8000 daedalus1215/currency-exchange-service:latest`
5. `docker push daedalus1215/currency-exchange-service:latest`