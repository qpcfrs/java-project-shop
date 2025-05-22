# Base image dùng Eclipse Temurin JDK 24
FROM eclipse-temurin:24-jdk as builder

# Set thư mục làm việc
WORKDIR /app

# Copy toàn bộ mã nguồn
COPY . .

# Build project bằng Maven Wrapper (không cần cài Maven ngoài)
RUN ./mvnw clean package -DskipTests

# ---------------------------------------------------------
# Stage chạy app
FROM eclipse-temurin:24-jdk

# Tạo thư mục app trong image
WORKDIR /app

# Copy file .jar từ stage build sang
COPY --from=builder /app/target/*.jar app.jar

# Cổng mặc định Spring Boot
EXPOSE 8080

# Lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "shop-app.jar"]
