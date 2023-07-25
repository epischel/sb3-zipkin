# sb3-zipkin
Exploring Spring Boot 3, Tracing and Zipkin

The goal is to detect x_b3_traceid and x_b3_spanid headers in http request (from cloud foundry router) and to add those headers in outgoing calls.

Side effect is to provide metrics to prometheus.

One observation: using `RestTemplate` the spanid in the outgoing http request is not the one in the log statement one source code line above.
So correlation is only possible using the traceid but not the spanid
