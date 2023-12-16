# Use the official MySQL 8.0 image as the base image
FROM mysql:8.0

# Expose port 3306 for MySQL
EXPOSE 3306

# Set environment variables for MySQL configuration
ENV MYSQL_ROOT_PASSWORD=""
ENV MYSQL_ALLOW_EMPTY_PASSWORD=true
ENV MYSQL_USER=petclinic
ENV MYSQL_PASSWORD=petclinic
ENV MYSQL_DATABASE=petclinic

# Create volumes for MySQL data and configuration
VOLUME /var/lib/mysql
VOLUME /etc/mysql/conf.d
