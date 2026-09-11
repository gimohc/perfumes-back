$baseDir = "ruml-backend-core\ruml-backend-core-b2b"
$modules = @("entity", "port", "dao", "dao-jpa", "factory", "usecase")

New-Item -ItemType Directory -Path $baseDir -Force

$parentPom = @"
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.ruml.ecommerce</groupId>
        <artifactId>ruml-backend-core</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <artifactId>ruml-backend-core-b2b</artifactId>
    <packaging>pom</packaging>
    <modules>
        <module>ruml-backend-core-b2b-entity</module>
        <module>ruml-backend-core-b2b-port</module>
        <module>ruml-backend-core-b2b-dao</module>
        <module>ruml-backend-core-b2b-dao-jpa</module>
        <module>ruml-backend-core-b2b-factory</module>
        <module>ruml-backend-core-b2b-usecase</module>
    </modules>
</project>
"@

Set-Content -Path "$baseDir\pom.xml" -Value $parentPom

foreach ($mod in $modules) {
    $modDir = "$baseDir\ruml-backend-core-b2b-$mod"
    New-Item -ItemType Directory -Path "$modDir\src\main\java\com\ruml\ecommerce\core\b2b\$mod" -Force
    New-Item -ItemType Directory -Path "$modDir\src\test\java\com\ruml\ecommerce\core\b2b\$mod" -Force
    
    $modPom = @"
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.ruml.ecommerce</groupId>
        <artifactId>ruml-backend-core-b2b</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <artifactId>ruml-backend-core-b2b-$mod</artifactId>
    
    <dependencies>
    </dependencies>
</project>
"@
    Set-Content -Path "$modDir\pom.xml" -Value $modPom
}
