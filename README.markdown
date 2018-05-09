A [Giter8][g8] template for custom serialization and deserialization in kafka. It is a sample application to show the usecase of that.

**Prerequisite:**
If you do not have kafka in your system. Download it from [here](https://www.apache.org/dyn/closer.cgi?path=/kafka/1.1.0/kafka_2.11-1.1.0.tgz)

**1) Extract the folder**

```tar -xzf kafka_2.11-1.1.0.tgz```

```cd kafka_2.11-1.1.0 ```

**2) Start the Zookeeper**

```bin/zookeeper-server-start.sh config/zookeeper.properties```

**3) Start the Kafka Server **

```bin/kafka-server-start.sh config/server.properties```

# How to set up ?

**1) Clone the application**

```sbt new jainnancy/kafka-custom-serialization.g8```

**2) Compile the application**

```sbt clean compile ```

**3) Run the application**
     a) start producer // producer will start writing data to kafka topic
     b) start consumer // consumer will start consuming data from kafka and print it to console


Template license
----------------
Written in <2018> by <Nancy Jain> <jain.nancy94@gmail.com>
[other author/contributor lines as appropriate]

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
