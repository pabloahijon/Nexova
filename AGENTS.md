# Project instructions

This repository contains a univerity software engineering project for a housing rental platform

## Technology

- Java
- Maven
- Spring Boot
- Spring Data JPA
- JUnit

## Arquitecture

Prefer a layer  architecture

Controler -> Service -> Repository -> Persistence

Business logic should not be placed directly in controllers.

## Development process

Before implementing a task:

1. Read the related issue and its acceptance criteria
2. Inspect the relevant repository files
3. Propose an implementation plan
4. Identify affected components and possible risks.
5. Do not make changes until the plan has been reviewed

 After implementation:

 1. Build the project
 2. Execute the relevant tests
 3. Explain the changes performed
 4. Report any unresolved problem or assumption

## Restrictions

- Do not invent requirements
- Do not silently change architecture
- Do not remove tests to make the build pass
- Do not integrate or approve changes

## Skill: Review persistence implementation

When reviewing a persistence implementation:

1. Review entities, repositories, services and controllers.
2. Verify that business logic is kept outside controllers.
3. Review entity identifiers, JPA relationships and cardinalities.
4. Review the dependencies and H2/JPA configuration.
5. Check that persistence is implemented through the expected architecture:
   Controller -> Service -> Repository -> Persistence.

### Skill: Review JUnit tests

Use this skill when implementing or reviewing automated tests.

1. Read the related issue, acceptance criteria and relevant entries in `TEST_PLAN.md`.
2. Inspect the production code and the affected test classes.
3. Check that each relevant test protects a clear behavior or criterion.
4. Review whether the test uses suitable valid, invalid or boundary data when applicable.
5. Check that assertions verify meaningful outcomes and are not trivially always true.
6. Review whether the test scope is appropriate and avoids unnecessary coupling to implementation details.
7. Check that the test name clearly describes the behavior being verified.
8. Execute the relevant Maven test or verification command.
9. Summarize:
   - what behavior is protected;
   - any weak, fragile or missing test;
   - assumptions or pending questions.

Do not:

- remove or disable tests to make the build pass;
- weaken assertions to obtain a green result;
- change production requirements to fit the test;
- hide failing tests or verification errors;
- add unrelated functionality;
- approve or integrate changes automatically.

Human review is required before integration.

### Agent limits

- Do not invent requirements or relationships.
- Do not expand the scope of the issue.
- Do not approve or integrate changes.
- The team must execute the final verification and decide whether the implementation is accepted.