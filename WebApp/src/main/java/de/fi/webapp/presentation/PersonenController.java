package de.fi.webapp.presentation;


import de.fi.webapp.presentation.dto.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/personen")

//@SessionScope
public class PersonenController {
    public PersonenController() {
        System.out.println("Constructor PersonenController");
    }

    @Operation(summary = "Liefert eine Person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person gefunden",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDto.class)) }),
            @ApiResponse(responseCode = "400", description = "ungueltige ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person nicht gefunden",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "internal server error",
                    content = @Content)})

    @GetMapping(path=  "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDto> getPersonById(@PathVariable UUID id) {

        if(id.toString().endsWith("7")) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new PersonDto());
    }

    @GetMapping(path = "", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<PersonDto>> findAll(
            @RequestParam(required = false, defaultValue = "Fritz") String vorname,
            @RequestParam(required = false, defaultValue = "Schmitt")String nachname
    ) {

        System.out.println(String.format("Vorname = %s, Nachname = %s", vorname, nachname));
        List personen = List.of(
                new PersonDto(),
                new PersonDto(null,"John","Wayne"),
                new PersonDto(null,"John","Rambo"),
                new PersonDto(null,"John","McClaine"),
                new PersonDto(null,"John","Wick"),
                new PersonDto(null,"John Boy","Walton")
        );

        return ResponseEntity.ok(personen);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonen(@PathVariable  UUID id) {
        if(id.toString().endsWith("7"))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@Valid @RequestBody PersonDto personDto, UriComponentsBuilder uriBuilder ) {
        // person speichern

        UriComponents uriComponents = uriBuilder.path("/v1/personen/{id}").buildAndExpand(personDto.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePerson(@PathVariable  UUID id,@Valid @RequestBody PersonDto personDTO)  {

        if(!  id.equals(personDTO.getId())) throw new IllegalArgumentException("Upps");

        if(id.toString().endsWith("7")) return ResponseEntity.ok().build();

        return ResponseEntity.notFound().build();
    }
}
