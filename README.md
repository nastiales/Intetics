# Intetics
My internship code submission

Unfortunately, I didn't have time to complete all functionality but I was able to code and test the following:
1. Client Search
2. Retrieve client cars
3. Add new client car

Database used: Oracle XE
Tables created: SYSTEM.CLIENTS, SYSTEM.CARS,SYSTEM.ORDERS

The program uses a central servlet for primary control which is ClientSearch.java and DAO is TestDAO.java which uses JDBC.

How to execute the program:
1. Setup the database from the DB dump provided on Git in the Database_dump.zip file.
2. Get eclipse project and open in Eclipse.
3. Make sure to have ojdbc jar and Tomcat installed.
4. Start server and open web browser to page: http://localhost:8080/ClientSearch/ClientSearch.jsp



