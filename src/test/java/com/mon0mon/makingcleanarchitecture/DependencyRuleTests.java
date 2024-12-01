package com.mon0mon.makingcleanarchitecture;

import com.mon0mon.makingcleanarchitecture.archunit.HexagonalArchitecture;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class DependencyRuleTests {

    @Test
    void validateRegistrationContextArchitecture() {
        HexagonalArchitecture.basePackage("com.mon0mon.makingcleanarchitecture")

                             .withDomainLayer("application.domain")

                             .withAdaptersLayer("adapter")
                             .incoming("in.web")
                             .outgoing("out.persistence")
                             .and()

                             .withApplicationLayer("application")
                             .incomingPorts("port.in")
                             .outgoingPorts("port.out")
                             .and()

                             .withConfiguration("configuration")
                             .check(new ClassFileImporter()
                                     .importPackages("com.mon0mon.makingcleanarchitecture.."));
    }

    @Test
    void domainModelDoesNotDependOnOutside() {
        noClasses()
                .that()
                .resideInAPackage("com.mon0mon.makingcleanarchitecture.application.domain.model..")
                .should()
                .dependOnClassesThat()
                .resideOutsideOfPackages(
                        "com.mon0mon.makingcleanarchitecture.application.domain.model..",
                        "lombok..",
                        "java.."
                )
                .check(new ClassFileImporter()
                        .importPackages("com.mon0mon.makingcleanarchitecture.."));
    }

}
