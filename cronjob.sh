#!/bin/bash

# Program:
#       This program create a JSON file with the tracking status counts from the table of logistics_statue in mysql.
# History:
# 2023/12/17 Scolley First release


# Database connection details
DB_HOST="localhost"
DB_PORT="3306"
DB_USER="petclinic"
DB_PASSWORD="petclinic"
DB_NAME="petclinic"  # Use your actual database name

# Table to query
TABLE_NAME="logistics_statue"

# Output JSON file
OUTPUT_JSON="output.json"

# Run MySQL query and save the results to a temporary file
TMP_OUTPUT="temp_output.json"
sudo docker exec -i -t logisticsstatustrackingwebsite-mysqlserver-1 mysql -h$DB_HOST -P$DB_PORT -u$DB_USER -p$DB_PASSWORD $DB_NAME -e "SELECT tracking_status FROM $TABLE_NAME;" > $TMP_OUTPUT

# Check if the query was successful
if [ $? -ne 0 ]; then
  echo "Error executing the query."
  exit 1
fi

# Use awk to sanitize and count occurrences of each tracking status
tracking_counts=$(awk 'NR > 1 {gsub(/[[:cntrl:]]/, "", $2); status = toupper($2); if (status != "" && status != "TRACKING_STATUS") counts[status]++ } END { for (i in counts) print "\"" i "\":" counts[i] "," }' $TMP_OUTPUT | tr -d '\n' | sed 's/,$//')

# Format the result as the desired JSON structure
JSON_RESULT='{"created_dt": "'$(date -u +"%Y-%m-%dT%H:%M:%SZ")'", "trackingSummary": {'$tracking_counts'}}'

# Save the result to the output JSON file
echo $JSON_RESULT | jq '.' > $OUTPUT_JSON

# Check if the operation was successful
if [ $? -eq 0 ]; then
  echo "JSON file created successfully. Results saved to $OUTPUT_JSON"
else
  echo "Error creating the JSON file."
fi

# Clean up temporary files
rm $TMP_OUTPUT
