## Logistics-Status-Tracking-Website

### Description
This is a Demo app about how to use spring boot, mysql, redis, docker, docker compose to build a logistics status tracking website.

### Tech Stack
- Language: Java 17
- Backend: Spring Boot 3
- Dependency Management: Maven
- Database: MySQL
- Cache: Redis
- Reverse Proxy: Nginx
- Deployment Environment: AWS EC2 Ubuntu 22.04
- Deployment: Docker, Docker Compose

### How to run
If you want to run this project locally, you need to follow the steps below:

- Clone the repository to your local machine or EC2 instance <br>
`git clone https://github.com/scolley31/Logistics-Status-Tracking-Website.git`
- Inside the project directory <br>
`cd Logistics-Status-Tracking-Website`
- execute docker-compose <br>
`sudo docker compose -f compose.yaml up --build`

### How to use
After you run the project, you can use the following API to test the project: <br>
1. GET http://localhost:8080/logistics/fake?num={counts} <br>
Fake data will be generated and stored in the database.


2. GET http://localhost:8080/logistics/query?sno={sno} <br>
Query the logistics status by sno. <br>

Response
```json
{
  "status":"success",
  "data":{
    "sno":1,
    "tracking_status":"CREATED",
    "estimated_delivery":"2021-05-20",
    "details":[
      {
        "id":1,
        "date":"2021-05-20",
        "time":"10:00:00",
        "status":"CREATED",
        "location_id":1,
        "location_title":"台北市"
      }
    ],
    "recipient":{
      "id":"e2b0e34b-3b8f-4ed2-8b3e-381af37f779b",
      "name":"王小明",
      "address":"台北市",
      "phone":"0912345678"
    },
    "current_location":{
      "location_id":8726512802663579523,
      "title":"台北市",
      "city":"台北市",
      "address":"台北市"
    }
  },
  "error":null
}
```

### Public Server
If you want to access the public server, you can use the following API to test the project:
1. GET https://scolley31.com/logistics/fake?num={counts} <br>
2. GET https://scolley31.com/logistics/query?sno={sno} <br>

### What I finished in this project
1. Deploy the project to AWS EC2 Ubuntu 22.04 and use Nginx to be a reverse proxy.
2. Add the fake data generator API.
3. Add the query API.
4. Use MySQL to store the data.
5. Use Redis to cache the data (one hours expired and can't update active).
6. Use Docker Compose to build the project (Spring boot 3 + redis + mysql).
7. Write the shell script to query data and summary the logistics status.
8. Use cronjob to and execute shell script and executed at 00:00, 08:00, 16:00, 24:00 every day. 
The generated log file will put at `/home/ubuntu`.

### Question
1. What is cron? And how to use it? <br>
cron is a time-based job scheduler in Unix-like computer operating systems. Users that set up and maintain cron to do schedule jobs (commands or shell scripts)at fixed times, dates, or intervals. It typically automates system maintenance or administration—though its general-purpose nature makes it useful for things like downloading files from the Internet and downloading email at regular intervals. <br><br>
Follow the steps below to use cron: <br><br>
    - Create a shell script to query data and summary the logistics status in database. File in
      `/Logistics-Status-Tracking-Website/cronjob.sh`
    - Open the cron table <br>
       `crontab -e` <br>
    - Add the following line to the cron table <br>
       `0 0,8,16 * * * /home/ubuntu/Logistics-Status-Tracking-Website/cronjob.sh >> /home/ubuntu/cronjob.log` <br>
    - We can use `crontab -l` to check the cron table. <br>
    - Now the cronjob will be executed at 00:00, 08:00, 16:00 every day. The generated log file will put at `/home/ubuntu`. <br>

2. In this project, Nginx is used as a reverse proxy. How to configure it? <br>
The configuration file is at `/etc/nginx/sites-available/default`. Nginx listens to port 80 and path `/logistics/` to forward the request to port 8080 that listened to the spring boot application. <br>
```
server {
	listen 80 default_server;
	listen [::]:80 default_server;

	root /var/www/html;

	server_name _;

	location / {
		# First attempt to serve request as file, then
		# as directory, then fall back to displaying a 404.
		try_files $uri $uri/ =404;
	}

	location /api/ {
            proxy_pass http://localhost:8080; 
            proxy_http_version 1.1;
            proxy_set_header Upgrade $http_upgrade;
            proxy_set_header Connection 'upgrade';
            proxy_set_header Host $host;
            proxy_cache_bypass $http_upgrade;
	}

	location /logistics/ {
            proxy_pass http://localhost:8080;
            proxy_http_version 1.1;
            proxy_set_header Upgrade $http_upgrade;
            proxy_set_header Connection 'upgrade';
            proxy_set_header Host $host;
            proxy_cache_bypass $http_upgrade;
        }
}
```

3. What is Forward Proxy? What is Reverse Proxy? <br>
Forward Proxy: A forward proxy is an intermediary server that sits between the client and the origin server. In order to get content from the origin server, the client sends a request to the proxy naming the origin server as the target. The proxy then requests the content from the origin server and returns it to the client. The client must be specially configured to use the forward proxy to access other sites. <br>
```Important: Forward proxies should be used to protect the identity of clients; not to protect the identity of servers.``` <br>
Reverse Proxy: A reverse proxy is an intermediary proxy service which takes a client request, passes it on to one or more servers, and subsequently delivers the server’s response to the client.<br>
```Important: Reverse proxies should be used to protect the identity of servers; not to protect the identity of clients.``` <br>

