$baseDir = "ruml-backend-core\ruml-backend-core-inventory"
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
    <artifactId>ruml-backend-core-inventory</artifactId>
    <packaging>pom</packaging>
    <modules>
        <module>ruml-backend-core-inventory-entity</module>
        <module>ruml-backend-core-inventory-port</module>
        <module>ruml-backend-core-inventory-dao</module>
        <module>ruml-backend-core-inventory-dao-jpa</module>
        <module>ruml-backend-core-inventory-factory</module>
        <module>ruml-backend-core-inventory-usecase</module>
    </modules>
</project>
"@

Set-Content -Path "$baseDir\pom.xml" -Value $parentPom

foreach ($mod in $modules) {
    $modDir = "$baseDir\ruml-backend-core-inventory-$mod"
    New-Item -ItemType Directory -Path "$modDir\src\main\java\com\ruml\ecommerce\core\inventory\$mod" -Force
    New-Item -ItemType Directory -Path "$modDir\src\test\java\com\ruml\ecommerce\core\inventory\$mod" -Force
    
    $modPom = @"
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.ruml.ecommerce</groupId>
        <artifactId>ruml-backend-core-inventory</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <artifactId>ruml-backend-core-inventory-$mod</artifactId>
    
    <dependencies>
    </dependencies>
</project>
"@
    Set-Content -Path "$modDir\pom.xml" -Value $modPom
}
