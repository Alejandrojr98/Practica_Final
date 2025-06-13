FROM ubuntu:latest
LABEL authors="IDS"

ENTRYPOINT ["top", "-b"]