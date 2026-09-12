# Stage 1: Build the application
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY ruml-backend/pom.xml ruml-backend/
COPY ruml-backend/ruml-backend-core/pom.xml ruml-backend/ruml-backend-core/
COPY ruml-backend/ruml-backend-presentation/pom.xml ruml-backend/ruml-backend-presentation/

# Give execution permission to maven wrapper
RUN chmod +x ./mvnw

# We could download dependencies here for caching, but for simplicity we will just copy source and build
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests -pl ruml-backend/ruml-backend-presentation/ruml-backend-presentation-controller-main -am

# Extract layers using Spring Boot's layertools
WORKDIR /app/ruml-backend/ruml-backend-presentation/ruml-backend-presentation-controller-main/target
RUN java -Djarmode=layertools -jar ruml-backend-presentation-controller-main-1.0-SNAPSHOT.jar extract

# Stage 2: Create the runtime image
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Add a non-root user
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy extracted layers
COPY --from=builder /app/ruml-backend/ruml-backend-presentation/ruml-backend-presentation-controller-main/target/dependencies/ ./
COPY --from=builder /app/ruml-backend/ruml-backend-presentation/ruml-backend-presentation-controller-main/target/spring-boot-loader/ ./
COPY --from=builder /app/ruml-backend/ruml-backend-presentation/ruml-backend-presentation-controller-main/target/snapshot-dependencies/ ./
COPY --from=builder /app/ruml-backend/ruml-backend-presentation/ruml-backend-presentation-controller-main/target/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
EXPOSE 8080
