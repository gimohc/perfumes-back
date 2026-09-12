$baseDir = "ruml-backend-core\ruml-backend-core-payment"
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
    <artifactId>ruml-backend-core-payment</artifactId>
    <packaging>pom</packaging>
    <modules>
        <module>ruml-backend-core-payment-entity</module>
        <module>ruml-backend-core-payment-port</module>
        <module>ruml-backend-core-payment-dao</module>
        <module>ruml-backend-core-payment-dao-jpa</module>
        <module>ruml-backend-core-payment-factory</module>
        <module>ruml-backend-core-payment-usecase</module>
    </modules>
</project>
"@

Set-Content -Path "$baseDir\pom.xml" -Value $parentPom

foreach ($mod in $modules) {
    $modDir = "$baseDir\ruml-backend-core-payment-$mod"
    New-Item -ItemType Directory -Path "$modDir\src\main\java\com\ruml\ecommerce\core\payment\$mod" -Force
    New-Item -ItemType Directory -Path "$modDir\src\test\java\com\ruml\ecommerce\core\payment\$mod" -Force
    
    $modPom = @"
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.ruml.ecommerce</groupId>
        <artifactId>ruml-backend-core-payment</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <artifactId>ruml-backend-core-payment-$mod</artifactId>
    
    <dependencies>
    </dependencies>
</project>
"@
    Set-Content -Path "$modDir\pom.xml" -Value $modPom
}
