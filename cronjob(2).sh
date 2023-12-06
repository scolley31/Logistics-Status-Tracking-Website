#!/bin/bash

# Database connection details
DB_HOST="localhost"
DB_PORT="3306"
DB_USER="petclinic"
DB_PASSWORD="petclinic"
DB_NAME="petclinic"  # Use your actual database name

# Table to query
TABLE_NAME="logistics_statue"

# Query to execute
SQL_QUERY="SELECT * FROM $TABLE_NAME;"

# Output JSON file
OUTPUT_JSON="output.json"

# Run MySQL query and output to JSON file
sudo docker exec -i -t your_mysql_container_name mysql -h$DB_HOST -P$DB_PORT -u$DB_USER -p$DB_PASSWORD $DB_NAME -e "$SQL_QUERY" | jq '.' > $OUTPUT_JSON

# Check if the query was successful
if [ $? -eq 0 ]; then
  echo "Query executed successfully. Results saved to $OUTPUT_JSON"
else
  echo "Error executing the query."
fi
