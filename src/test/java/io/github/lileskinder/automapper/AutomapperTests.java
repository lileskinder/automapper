package io.github.lileskinder.automapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutomapperTests {

    @Test
    public void testMap_SingleObject_fromRecordDTO() {
        // Arrange: Create a source object
        UserRecordDTO userRecordDTO = new UserRecordDTO("Alice", 30);

        // Act: Map the DTO to the domain model
        User user = AutoMapper.map(userRecordDTO, User.class);

        // Assert: Verify that the fields are mapped correctly
        assertNotNull(user);
        assertEquals("Alice", user.getName());
        assertEquals(30, user.getAge());
    }

    @Test
    public void testMap_SingleObject_fromDTO() {
        // Arrange: Create a source object
        UserDTO userDTO = new UserDTO("Alice", 30);

        // Act: Map the DTO to the domain model
        User user = AutoMapper.map(userDTO, User.class);

        // Assert: Verify that the fields are mapped correctly
        assertNotNull(user);
        assertEquals("Alice", user.getName());
        assertEquals(30, user.getAge());
    }

    @Test
    public void testMap_SingleObject_fromRecordDTO_missingFields() {
        // Arrange: Create a source object
        UserRecordMissingFieldDTO userRecordDTO = new UserRecordMissingFieldDTO("Alice");

        // Act: Map the DTO to the domain model
        User user = AutoMapper.map(userRecordDTO, User.class);

        // Assert: Verify that the fields are mapped correctly
        assertNotNull(user);
        assertEquals("Alice", user.getName());
        assertNull(user.getAge());
    }

    @Test
    public void testMap_SingleObject_toRecordDTO() {
        // Arrange: Create a source object
        User user = new User("Alice", 30);

        // Act: Map the DTO to the domain model
        UserRecordDTO userRecordDto = AutoMapper.map(user, UserRecordDTO.class);

        // Assert: Verify that the fields are mapped correctly
        assertNotNull(userRecordDto);
        assertEquals("Alice", userRecordDto.name());
        assertEquals(30, userRecordDto.age());
    }



    @Test
    public void testMap_SingleObject_toDTO_missing_fields() {
        // Arrange: Create a source object
        User user = new User("Alice");

        // Act: Map the DTO to the domain model
        UserRecordMissingFieldDTO userRecordDto = AutoMapper.map(user, UserRecordMissingFieldDTO.class);

        // Assert: Verify that the fields are mapped correctly
        assertNotNull(userRecordDto);
        assertEquals("Alice", userRecordDto.name());
    }

    @Test
    public void testMap_NullSource() {
        // Act: Map a null source object
        User user = AutoMapper.map(null, User.class);

        // Assert: Verify that the result is null
        assertNull(user);
    }
}
