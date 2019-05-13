# Archetype for common REST API automation testing framework

This archetype project is created for distributing common REST API automation testing framework.

## Deployment

The following Jenkins job deploys this archetype project to Nexus repository:

http://jenkins.aureacentral.com/job/EngQAIntegration/job/common-restapi-archetype-deployment/

Currently version 1.0 is available on Nexus https://nexus.devfactory.com/repository/testautomation-testrail-integration

### Usage

To create your project basing on the given archetype the following parameters should be set:

```
 groupId = com.xo.restapi.template
 artifactId = restapi-framework-template-archetype
 version = 1.0
```
 
Also you have to add a repository entry to your ${user.home}/.m2/settings.xml once:

```
<profiles>
      <profile>      
      <id>xo</id>
        <activation>
        <activeByDefault>true</activeByDefault>
		</activation>
      <repositories>
        <repository>
          <id>testautomation-testrail-integration</id>
          <url>https://nexus.devfactory.com/repository/testautomation-testrail-integration</url>
          <releases>
            <enabled>true</enabled>
            <checksumPolicy>fail</checksumPolicy>
          </releases>
          <snapshots>
            <enabled>true</enabled>
            <checksumPolicy>warn</checksumPolicy>
          </snapshots>
        </repository>
      </repositories>
    </profile>    
  </profiles>
```
 
## Customization

Once you created the project based on this archetype it should be customized.
All sample classes should be exchanged with those which are specific for your project.
However general structure should be preserved.

Pay attention to comments describing class purposes.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
