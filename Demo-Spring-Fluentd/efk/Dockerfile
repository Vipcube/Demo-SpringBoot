# fluentd/Dockerfile
FROM fluent/fluentd:v1.11-1
USER root
RUN ["gem", "install", "fluent-plugin-elasticsearch", "--no-document", "--version", "4.1.2"]
RUN ["gem", "install", "fluent-plugin-rewrite-tag-filter"]
RUN ["gem", "install", "fluent-plugin-record-modifier", "--no-document"]
USER fluent