# **Assignment 5**
OMSCS CS6300 - Software Development Process, Summer 2024 

Shashvat Sinha <<ssinha96@gatech.edu>>


# Overview
This is my implementation of the assignment 5, to design a job offer manager and comparison tool for George P. Burdell. All the best, George!

# Approach
## Iterative Design
I have elected to design this software in an iterative manner. In the past decade or more, the process of building software via a full up-front design has been discredited. The current preferred approach in software design, for both large complex enterprise grade applications, and for small, one off personal projects has been to build them iteratively.

The design of the software is therefore deliberately lightweight, and is intended to inform and suggest, rather than being a prescriptive, conformal document. As we build the software based on this initial design document, we evolve this design based on our real-time evaluation of the work that we complete, and its suitability to the needs of Mr. Burdell (and others like him).

## Modular Components
The system design is envisoned as modular, with each component being a stand alone, independent, reusable, unit testable, and deployable. The intention of this design is also to make it extensible, and one that could potentially be used in a multi-user system, or by Mr. Burdell as an overall career manageement tool (i.e. not just for his next job).

The design is intended to be used in a containerized, microservice architecture, with the front end connecting to the service layer via a REST API. The back-end could be implemented as a set of microservices, each running in their own containers.

At the current, simple, single user, single job search stage of this software, we expect there to be only one microservice.

# Implementation
The three major components of this software will be the service layer, the database and the user interface. At this stage in the design, we're going to focus primarily on the service layer and then on the user interface. The data storage/persistence layer will be left till later, and we expect it to be a simple design using a relational database management system (RDBMS).

The service layer provides the main business logic of the application independent of how Mr. Burdell might interact with it. We shall now discuss the classes and service endpoints.

## Service Layer - Classes
### User Class
The ```User``` class is designed so that it can be used to represent multiple users of this application. It therefore has amongst its properties a user ID, and personal information about the user. The fields
```userID```, ```firstName``` and ```lastName``` are self explanatory. In our first deployment for Mr. Burdell, we can default these values to 1, "George P." and "Burdell", and not implement any means to add new users.

### Job Class
The ```Job``` class contains all the information that we might need about a specific job. I have also included a ```status``` field, which will be unumerated between ```['current', 'past', 'offered', 'expired']``` and dates of the jobs. I expect that Mr. Burdell will like this software enough to want to continue using it in the future throughout his career, and with acceess to the source code, will appreciate the extensibility he has. Therefore there is a 0..n relationship between the user and jobs, i.e. we do not assume that the user has a job - they may be unemployed, or be a full time student. Also, we are not putting a constraint in how many past, current or future jobs Mr. Burdell may have. While we wish that Mr. Burdell gets a job that is both financially rewarding and intellectually satisfying, we are leaving open the possibility that Mr. Burdell may have more than one job at a given time, either to make ends meet, and/or to give him an outlet for his entreprenurial and creative side.

### Weights Class
Each user object will contain one instance of a ```Weights``` object, which contains the job preferences for the user. We expect that even in the future, a user will have only one set of preferences. We also expect that the preferences for the user may be expanded, e.g. a set of preferred locations. Upon initialization, an object of this class has ```1``` as the values of all the weights. Allowable values (integers) are from 0 (no interest/don’t care) to 9 (highest interest).

### Location Class
We have defined a ```Location``` class, and it will be used to denote the location of a job and also the location of a person. While it is not a requirement now, we expect that a person will want to set a location and then assign a weight to a preferred location when choosing between jobs. From personal experience, location is often the second or third most important factor for job searchers (the first two are pay and role). I'm not quite sure how I want to denote fully remote jobs. The location class has a 1..n relatinship with a user - each user can have one location, but one location can have multiple users. We've kept an m..n relationship between jobs and locations, since jobs can be offered in multiple locations. 

## Service Layer - Endpoints
We have the following endpoints for services provided by the Service Layer:

### ```upsertJob()```
This method call allows the caller to add a job to the list of jobs that the current user has. The caller provides information about the job, including whether it is the current job, a past job or an offered job. Note that the system does not assume that the user has a job. If information for an existing job is entered, the method updates the job in place with new information. This way, a job can be made ```current``` from ```offered``` (i.e. an offer is accepted) and so on. This also allows Mr. Burdell to negotiate for better terms and update the offer in case the compensation changes.

### ```removeJob()```
This is for housekeeping and in case an incorrect entry has been made. We expect that one wouldn't normally remove a job in the normal course of events. If an offer is withdrawn or not accepted, it will eventually go into a state of ```expired```, therefore removing it from consideration. But if needed, calling this method with a jobID will delete the Job from the list of jobs for the user. 

### ```getJobList()``` 
Returns the list of jobs that are in the states ```offered``` and ```current```. 

### ```compareJobs()```
Given two different jobs, this method will return a comparison of the jobs ranked against each other.
When ranking jobs, a job’s score is computed as the weighted average of:

```AYS + AYB + TDF + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8))```

where:
- AYS = Yearly Salary Adjusted for cost of living
- AYB = Yearly Bonus Adjusted for cost of living
- TDF = Training and Development Fund  ($0 to $18000 inclusive annually)
- LT = Leave Time  (0-100 whole number days inclusive)
- RWT = Telework Days per Week 


### ```getJobPrefs()```
This method return the preferences that the user has stored for their job search, i.e. the comparison weights for each of the job attributes. It starts off as empty.

### ```upsertJobPrefs()```
This method allows the caller to enter or update the stored job search preferences, i.e. the weights of the various attributes of a job for a comparison.

## User Interface Layer
Here we shall describe the proposed components of a user interface. We are assuming that the user interface is either an app on an edge computing device (e.g. the users phone or computer), or is a webpage that will be rendered. In either case, the user interface will communicate with the service layer via the REST API described above.

### Home Screen
The home screen of the application presents Mr. Burdell with a main menu, with the ability to enter or edit job details, including new offers and existing jobs, update the job preferences (i.e. the comparison weights) and go to the comparison screen. The comparison screen button is disabled unless there is at least one job in ```offered``` state. 

The current design assumes single user operation entirely within Mr. Burdell's control, and therefore has no implementation for access controls and identity checks. This are left for a future expansion of this product.

### Add/Update Job Screen
This is the screen that allows Mr. Burdell to enter new jobs into his list of jobs, or update jobs that he already has entered. Mr. Burdell would use this screen to enter his current job, any past jobs that he would like to enter, any future offers that he would like to enter, and even any expired offers. And Mr. Burdell would also user this to update existing jobs, e.g. if he accepts an offer or resigns a job. This method relies on the ```upsertJob()``` API endpoint.
The following fields are available on this screen:
-    Title
-    Company
-    Location (entered as city and state)
-    Cost of living in the location (expressed as an index)
-    Yearly salary 
-    Yearly bonus 
-    Training and Development Fund
-    Leave Time
-    Telework Days per Week

The screen also has ```Save``` and ```Cancel``` buttons.


### Prefs Screen
This screen allows Mr. Burdell to update his preferred weights for the jobs attributes for comparison purposes. As mentioned in the description of the ```Weights``` class, the default values of all weights is ```1```. This screen users the ```getJobPrefs()``` and ```upsertJobPrefs()``` API endpoints.

### ListJobs Screen
This screen allows Mr. Burdell to see a list of all the jobs he has on offer, and is currently working at, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.

It also allows him to select two jobs to compare. 

This screen is only available when Mr. Burdell has already entered at least two jobs into the system in either of the states ```current``` and ```offered```.

This screen uses the ```getJobsList()``` API endpoint.

### CompareJobs Screen
This screen takes the two jobs Mr. Burdell has selected from the ```ListJobs``` screen and compares them according to the job preferences weights. This screen uses the ```compareJobs()``` endpoint, which contains the business logic for ranking and comparing jobs.

# Conclusion

As we go through the process of developing this application for Mr. Burdell, we will continue to update and refine this design, and also the eventual application itself. In fact, within the course of writing this document, the design was updated two more times.
