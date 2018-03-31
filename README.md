#Git Workflow Practice Project
####This project will be used to understand and practice a well designed workflow of team development using git


####Objectives for this project
* To understand branching for each feature/ticket
* To understand using the master branch as an implied "approved" commit by any given developer
* To understand how to use rebase to ensure the branch you are working will always be up to date with the master branch
* To grasp a solid understanding of keeping code environment ignorant



#####This project uses the gradle wrapper to alleviate the need for every developer to download, unzip and map the GRADLE_HOME environment variable as well as add $GRADLE_HOME/bin to your PATH variable


###First run the database migrations
```
gradlew flywayMigrate -i
```

###How to run this project
```
gradlew bootRun
```

###How to run integration tests
```
gradlew clean test
```

###Test reports are found here
```
${buildDir}\reports\tests\test\index.html
```