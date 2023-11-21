provider "kafka" {
  bootstrap_servers = ["kafka-0-broker.oamsan.io:9092", "kafka-1-broker.oamsan.io:9092", "kafka-2-broker.oamsan.io:9092"]
  skip_tls_verify   = true
  tls_enabled       = false
}

variable "topic_names" {
  type    = list(string)
  default = ["topic1", "topic2", "topic3"]
}

resource "kafka_topic" "topics" {
  count = length(var.topic_names)
  name       = var.topic_names[count.index]
  partitions = 1
  replication_factor  = 1
}

