# Irfan Spring Boot Simple CRUD REST API

## Overview

This Spring Boot application serves as a REST API using MongoDB as its database.

## Prerequisites

- Java 8 or later installed
- Docker installed

## Getting Started

## Setup MongoDB using Docker

1. **Pull MongoDB Image:**

   Open a terminal and run the following command to pull the latest MongoDB image from Docker Hub:

   ```bash
   docker pull mongo
   docker run -d -p 27017:27017 --name mongodb-container mongo
   docker ps