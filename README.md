# cst (Customer Service Tool)

A spike to integrate:

* [Reapp](http://reapp.io/) - Reapp is a collection of packages for building user interfaces using React. Apps can be deployed to mobile platforms including iOS and Android using Apache Cordova.
* [Couchbase Server](http://www.couchbase.com/nosql-databases/couchbase-server) - Couchbase is a document-oriented NoSQL database.
* [Spring Boot](http://projects.spring.io/spring-boot/) - Spring Boot is a Java application development framework ideally suited to a [microservices](http://martinfowler.com/articles/microservices.html) architecture.

This project is a demo of a customer service tool that collects events from an analytical pipeline into a serving layer (Couchbase) for delivery to a mobile customer enquiry tool.

The following test document (fictitious data) can be loaded into Couchbase.

    {
      "name": "Elizabeth Marks",
      "events": [
        {
          "reference": "0034 9932 9932",
          "agentLanId": "D756259",
          "subtype": "New Service",
          "agentName": "Sean M",
          "agentOu": "Product Sales",
          "details": "__100GB Entertainer Bundle__\n* Home Phone\n* ADSL\n* Foxtel",
          "time": "2015-07-20 22:18:41.857",
          "type": "Order",
          "status": "Complete (Approved)"
        },
        {
          "type": "Service Request",
          "subtype": "Complaint",
          "time": "2015-06-21 22:18:41.857"
        },
        {
          "type": "Interaction",
          "subtype": "Change of Details",
          "time": "2015-05-22 22:18:41.857"
        },
        {
          "reference": "0034 9932 9932",
          "sentTo": "0410 541 223",
          "subtype": "Exceed Data Limit",
          "time": "2015-05-15 22:18:41.857",
          "notificationType": "SMS",
          "type": "Notification",
          "message": "Lorem ipsum"
        }
      ],
      "id": "2004226978"
    }
