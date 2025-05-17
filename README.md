# SpringBoot-Microservices

## Overview

This repository contains a collection of microservices built using Spring Boot with Gradle. It includes services such as Eureka Server, Chat Service, Engagement Service, and User Service, designed to demonstrate a microservices architecture.

## Services

- **EurekaServer**: The service discovery server.
- **SOA-Chat-Service**: Handles chat-related functionalities.
- **SOA-Engagement-Service**: Manages engagement features.
- **SOA-User-Service**: Manages user-related operations.

## Prerequisites

- Java 17
- Gradle

## Setup Instructions

1. Clone the repository:

   ```
   git clone https://github.com/medhedimaaroufi/SpringBoot-Microservices.git
   ```

2. Navigate to the project directory:

   ```
   cd SpringBoot-Microservices
   ```

3. Build the project using Gradle:

   ```
   gradle build
   ```

4. Run the Eureka Server first:

   ```
   cd EurekaServer
   gradle bootRun
   ```

5. Run other services in separate terminals:

   ```
   cd SOA-Chat-Service
   gradle bootRun
   ```

   Repeat for Engagement and User services.

## Monitoring Eureka Server

The Eureka Server provides a dashboard to monitor registered services. Once the Eureka Server is running:

1. Open your browser and navigate to:

   ```
   http://localhost:8761
   ```

2. You will see the Eureka dashboard, which lists all registered microservices, their status, and other details.

## Contributing

Feel free to fork this repository and submit pull requests. Please ensure your code follows the project standards.

## Contact

For questions or support, contact medhedimaaroufi (GitHub profile).