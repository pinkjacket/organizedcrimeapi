# _Crimes API_

#### _An API about organized crime, 1/26/2018_

#### By _**James Donlan**_

## Description

_The mafia, the yakuza, the Irish mob, Bratva. Throughout history, powerful groups such as these have risen to control illegal activity in their areas. They're kind of scary but pretty interesting, and with this API you can pull up interesting facts about them any time! From membership numbers to their relationship with local governments, it's all here._

_As someone who takes an interest in the world of organized crime, and therefore knows a lot about it, I thought an API about it would be neat. It's pretty basic right now, but functioning, and I can see building it out to include more variables and classes, like one for specific incidents. After all, what's the point of being able to pull up a profile on Meyer Lansky if you can't read about the time he tried to kill someone by poisoning a chicken and then carrying it around while he figured out how he was going to get them to eat it? (he never quite managed it).

For now there's just organizations and individuals. Individuals get a name and a description and belong to an organization, since this isn't about lone wolves, and organizations get a name, a true name (the mafia don't call themselves the mafia, and the yakuza prefer to be said to be walking "the extreme path"), location, a brief assessment of their current membership, and a brief assessment of their relationship with the local government (while the mafia has been pretty much crushed in America for a while now thanks to RICO statutes, the yakuza are extremely cozy with Japan's conservative government, to say nothing of the corporate world).

Currently it's only set up as far as organizations working properly through Postman, an example of which can be seen here https://imgur.com/a/gxwl1

## Data Models

* _Organization_
  * _name (Yakuza)_
  * _truename (The Extreme Path)_
  * _location (Japan)_
  * _membership (roughly 102,000)_
  * _govtrelationship (cozy)_

* _Individual (not currently routed)_
  * _name (Kiryu Kazuma)_
  * _description (The Dragon of Dojima)_

## Endpoints

* _/organizations_
  * GET to list all organizations
* _/organizations/:id_
  * GET with number in place of :id to view details of corresponding organization
* _/organizations/new_
 * POST to using the above data model to create and store a new organization

## Setup/Installation Requirements

* _Clone from github_
* _open in IntelliJ_
* _Run App_
* _Open Postman_
* _Navigate to endpoint urls and GET to read existing information or POST following the model to create new data_
* _Further explanation of Postman can be found here https://www.learnhowtoprogram.com/java/api-development-extended-topics/jadle-frontend-json-gson-and-postman_

## Known Bugs

_currently unfinished_

## Technologies Used

_Java_
_Spark_
_SQL_
_JSON_

### License

*MIT License*

Copyright (c) 2018 **_James Donlan_**
