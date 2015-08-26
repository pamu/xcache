# xcache
High throughput, low latency and thread safe LRU Cache

LRU cache

1) In Memory 

2) Simple put and get operations are supported

3) Least recently used items are thrown away

4) Thread safe (concurrency doesn't corrupt the data structure)

5) Minimal locking

# Cache operations from multiple threads
![XCache](https://raw.githubusercontent.com/pamu/xcache/master/images/xcache.png)

# build and Run this project

```
    sbt clean compile run
```

# To run test cases

```
    sbt test
```

# Performance Stats

![Stats](https://raw.githubusercontent.com/pamu/xcache/master/images/xcache-stats.png)

# Optimised

![Optimised](https://raw.githubusercontent.com/pamu/xcache/master/images/xcache-optimised.png)
