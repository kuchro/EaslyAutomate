# EaslyAutomate

This project is in progress...
I will try to update this project asap.

---

Idea: Java-lib which will help you to create full automate process for your E2E tests and other stuff which should be automate.

Requirements
----------------- 
* Java IDE - for this project im using intellij idea.
* Gradle - im using: gradle-4.2.1

And other libs which should be in gradle.build - you can check in EaslyAutomate\build.gradle
* 'org.seleniumhq.selenium', name: 'selenium-java', 
* 'org.yaml', name: 'snakeyaml', version: '1.21'
* 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.5'
* 'com.fasterxml.jackson.dataformat', name: 'jackson-dataformat-yaml', version: '2.9.5'


Usage
--------------
In root dir of your project/POC place one config file *.json/*.yml/*.yaml  - these extensions are allowed. After this we have to create systemproperty to load specific data for env:
```java
systemProperty("prop.env","TEST");

```

To run this from gradle cmd: 

```
gradle -Dprop.env=PRODUCTION test
```

### For Json format, we should keep this structure:
```json
{  
   "configuration":{  
      "TEST":{  
         "browserName":"Chrome",
         "urladdress":"http://www.test.pl/",
         "filePaths":{  
            "logfile":"C://test/log/",
            "excelfile":"C:/test/excel/",
            "csvfile":"C:/test/csv/"
         },
         "dataBase":{  
            "postgres":{  
               "driverName":"org.postgresql.Driver",
               "url":"jdbc:postgresql://127.0.0.1:5432/jdbc",
               "user":{  
                  "userName":"admin",
                  "password":"admin"
               }
            }
         },
         "serversData":{  
            "sftp":{  
               "host":"10.10.22.0",
               "port":"21",
               "user":{  
                  "userName":"sftpuser",
                  "password":"userpwd"
               }
            }
         }
      },
      "DEV":{  
         "browserName":"Mozilla",
         "urladdress":"http://www.test.pl/",
         "filePaths":{  
            "logfile":"C://test/log",
            "excelfile":"C:/test/excel"
         },
         "dataBase":{  
            "postgres":{  
               "driverName":"org.postgresql.Driver",
               "url":"jdbc:postgresql://127.0.0.1:5432/jdbc",
               "user":{  
                  "userName":"admin",
                  "password":"admin"
               }
            },
            "mssql":{  
               "driverName":"com.microsoft.sqlserver.jdbc.SQLServerDriver",
               "url":"jdbc:sqlserver://10.0.0.1:1433;database=xxx",
               "user":{  
                  "userName":"admin",
                  "password":"admin"
               }
            }
         },
         "serversData":{  
            "sftp":{  
               "host":"10.10.22.0",
               "port":"21",
               "user":{  
                  "userName":"sftpuser",
                  "password":"userpwd"
               }
            },
            "smtp":{  
               "host":"smtp.company.com",
               "port":"25",
               "user":{  
                  "userName":"smtpuser",
                  "password":"userpwd"
               }
            }
         }
      }
   }
}


```
### "configuration" object is required

### For YAML format, we should keep this structure:

```
configuration:
	TEST:
	 browserName: Chrome
	 urladdress: https://google.pl
	 filePaths:
		 logfile: C://test/log/
		 excelfile: C://test/excelfile/
		 csvfile: C://test/csv/
	 serversData:
		 sftp:
			host: 10.10.22.2
			port: 21
			user:
			  userName: Karol
			  password: haslo

	DEV:
	 browserName: Chrome
	 urladdress: https://google.pl
	 filePaths:
		 logfile: C://test/log/
		 excelfile: C://test/excelfile/
		 csvfile: C://test/csv/
	 dataBase:
		 postgres:
			driverName: org.postgresql.Driver
			url: jdbc:postgresql://127.0.0.1:5432/jdbc
			user:
			  userName: user
			  password: haslo
	 serversData:
		sftp:
			host: 10.10.22.2
			port: 21
			user:
			  userName: Karol
			  password: haslo

```
### "configuration" object is required

### This will automatically map data for lib model(under: pl.easlyautomate.model), those data will be used in the rest of library





